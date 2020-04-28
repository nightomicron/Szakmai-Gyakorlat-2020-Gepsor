package RuntimeCalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//import configuration.ConfGraph;
import Tube.Graph;
import ilog.concert.IloException;
import ilog.concert.IloLPMatrix;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.cplex.IloCplex;
//import parameters.ParamsConf;
import Tube.SetUp;
//import parameters.ParamsPCB;
import Tube.Product;

public class SolveIP {
	private static int K = 100000;	// big constant	
        public static double seconds;
        public  static boolean ok = true;
	private static SetUp pConf;
	private static Product pPCB;
	private static int[] boards;	// solve for which boards 
	private static Graph confG; 
	
	//public SolveIP(ParamsConf pc, ParamsPCB pb, int[] b){
	public SolveIP(SetUp pc, Product pb, int[] b, Graph g){
		pConf = pc;
		pPCB = pb;
                int numPCB = pPCB.getB();
		if (b.length>numPCB){
			for (int i=0;i<b.length;i++){
				if (b[i]>numPCB-1){
					System.err.println("Invalid board index:"+b[i]);
					return;
				}
			}
			System.err.println("Invalid boards list, too many boards");
			return;
		}
		boards = b;
		confG = g;
	}
	
	public static double solve(int timeLimit){
	 long startTime = System.nanoTime();
	
            int t = 0;
                
                double objValue = -1;
 		//confG.showGraph();
		ArrayList<String> namesListX = new ArrayList<String>();	// edge placement - nozzles
		ArrayList<String> namesListY = new ArrayList<String>();	// edge nozzles - headslots
		ArrayList<String> namesListZ = new ArrayList<String>();	// edge headslots - heads
		ArrayList<String> namesListQ = new ArrayList<String>();	// edge heads - machines
		ArrayList<String> namesListC = new ArrayList<String>();	// edge component types - machines (feeders)
		ArrayList<String> namesListCycle = new ArrayList<String>();	// variable for number of cycles
		ArrayList<String> namesListLambda = new ArrayList<String>();	// extra variables for minmax objective function
		HashMap<String,Integer> x_map = new HashMap<String,Integer>();	// to get x variables by name (for constraint 1 and 6)
		ArrayList<Integer> ubListX = new ArrayList<Integer>();

                int numM = pConf.getM();
                int numH = pConf.getH();
		int numN = pConf.getN();
		int numC = pConf.getA();
		int numB = boards.length;
		int numVarY = confG.getConS();
		int numVarZ = confG.getConH();
		int numVarQ = confG.getConM();
		int numVarC = confG.getConA();
		int numVarX = 0;
		int numVarCycle = 0;
		int numVarLambda = 0;
		int numVarTotal = 0;
                
                Object[] Carray = pConf.getC();
                
		int numConstraints = 0;
		boolean[] isAssigned = new boolean[numC];	// does comp type is assigned to machine already or not
		for (int m=0;m<numM;m++){
			for (int i=0;i<numC;i++){
				isAssigned[i] = false;
			}
			
			for (int h=0;h<numH;h++){
				namesListQ.add("q_"+m+"_"+h);
				//numVarQ++;
                                
                                int capH = Integer.parseInt(Carray[h].toString());
				for (int z=0;z<capH;z++){
					namesListZ.add("z_"+m+"_"+h+"_"+z);
					//numVarZ++;
					for (int y=0;y<numN;y++){
						if (pConf.isCompatibleNozzleTHeadT(y, h)){
							namesListY.add("y_"+m+"_"+h+"_"+z+"_"+y);
							//numVarY++;
							for (int b=0;b<numB;b++){
								for (int c=0;c<numC;c++){
									if (pConf.isCompatibleCompTNozzleT(c,y)){
										if (!isAssigned[c]){
											namesListC.add("c_"+m+"_"+c);
											//numVarC++;
											isAssigned[c] = true;
										}
										String xName = "x_("+m+"_"+h+"_"+z+"_"+y+")_("+boards[b]+"_"+c+")";
										namesListX.add(xName);
										ubListX.add(pPCB.getPiecesComps(boards[b], c));
										x_map.put(xName, numVarX);
										numVarX++;
									}
								}
							}
						}
					}
				}
			}
		}
		numVarCycle = numM*numB;
		for (int m=0;m<numM;m++){
			for (int b=0;b<numB;b++){
				namesListCycle.add("cycle_"+m+"_"+b);
			}
		}
		numVarLambda = numB;
		for (int b=0;b<numB;b++){
			namesListLambda.add("lambda_"+boards[b]);
		}
		
		numVarTotal = numVarX+numVarY+numVarZ+numVarQ+numVarC+numVarCycle+numVarLambda;
		ArrayList<String> namesListVars = new ArrayList<String>();
		namesListVars.addAll(namesListX);
		namesListVars.addAll(namesListY);
		namesListVars.addAll(namesListZ);
		namesListVars.addAll(namesListQ);
		namesListVars.addAll(namesListC);
		namesListVars.addAll(namesListCycle);
		namesListVars.addAll(namesListLambda);
		
		
		try {
			//System.out.print("Build model ...");
			long start = System.currentTimeMillis();
			IloCplex cplex = new IloCplex();
 			IloLPMatrix lp = cplex.addLPMatrix();
 			
 			double[] varLB = new double[numVarTotal];	// v�ltoz�k als� korl�t
			Arrays.fill(varLB, 0);
			double[] varUB = new double[numVarTotal];	// v�ltoz�k fels� korl�t
			Arrays.fill(varUB, 1);
			
			for(int i=0;i<numVarX;i++){					// fels� korl�t az x-kre (component placement)
				varUB[i] = ubListX.get(i);
			}
			for (int b=numVarTotal-1;b>=numVarTotal-numB-numVarCycle;b--){	// fels� korl�t a szigm�ra (cycle) �s a lambd�ra (minmax)
				varUB[b]=Integer.MAX_VALUE;
			}
			String[] varName = new String[numVarTotal];	// v�ltoz�k neve
			varName = namesListVars.toArray(varName);
			IloNumVarType[] varType = new IloNumVarType[numVarTotal];	// v�ltoz�k t�pusa
			Arrays.fill(varType, IloNumVarType.Int);
			
			IloNumVar[] xVars = cplex.numVarArray(cplex.columnArray(lp,numVarTotal), varLB, varUB, varType , varName);		// v�ltoz�k vektora

			// CONSTRAINT 1: each placement is assigned to any nozzle
			// CONSTRAINT 2: if any component placement is assigned to a nozzle then the nozzle must be assigned to a head
			// CONSTRAINT 3: if a nozzle is assigned to a head-slot than the slot must be used 
			// CONSTRAINT 4: if a head-slot is used than the head must be assigned to a machine 
			// CONSTRAINT 5: at most one head is assigned to a machine
			// CONSTRAINT 6: if a component placement is assigned to a nozzle than the component type must be assigned that machine
			// CONSTRAINT 7: total width of the assigned component types to one machine must not exceed the feeder capacity
			// CONSTRAINT 8: count the cycles for each PCB and each machine module
			// CONSTRAINT 9: extra constraint instead of the minmax objective
			
			int idx_x = 0;
			int idx_y = numVarX;
			int idx_z = numVarX+numVarY;
			int idx_q = numVarX+numVarY+numVarZ;
			
			for (int m=0;m<numM;m++){	// machines
				IloLinearNumExpr c_5 = cplex.linearNumExpr();
				for (int h=0;h<numH;h++){	// heads
					c_5.addTerm(xVars[idx_q], 1);
					IloLinearNumExpr c_4 = cplex.linearNumExpr();
                                        int capH = Integer.parseInt(Carray[h].toString());
					for (int z=0;z<capH;z++){	// head slots
						c_4.addTerm(xVars[idx_z], 1);
						IloLinearNumExpr c_3 = cplex.linearNumExpr();
						for (int y=0;y<numN;y++){	// nozzles
							if (pConf.isCompatibleNozzleTHeadT(y, h)){
								c_3.addTerm(xVars[idx_y], 1);
								IloLinearNumExpr c_2 = cplex.linearNumExpr();
								for (int b=0;b<numB;b++){	// borads
									for (int c=0;c<numC;c++){	// component types
										if (pConf.isCompatibleCompTNozzleT(c,y)){
											c_2.addTerm(xVars[idx_x], 1);	// placements
											idx_x++;
										}
									}
								}
								c_2.addTerm(xVars[idx_y],-K);
								cplex.addLe(c_2, 0);			// CONSTRAINT 2
								numConstraints++;
								idx_y++;
							}
						}
						c_3.addTerm(xVars[idx_z], -1);
						cplex.addEq(c_3, 0);					// CONSTRAINT 3
						numConstraints++;
						idx_z++;
					}
					c_4.addTerm(xVars[idx_q], -K);
					cplex.addLe(c_4,0);							// CONSTRAINT 4
					numConstraints++;
					idx_q++;
				}
				cplex.addLe(c_5, 1);							// CONSTRAINT 5
				numConstraints++;
			}
			
			for (int c=0;c<numC;c++){		// component types
				for (int b=0;b<numB;b++){	// boards
					IloLinearNumExpr c_1 = cplex.linearNumExpr();
					for (int m=0;m<numM;m++){		// machines 
						for (int h=0;h<numH;h++){	// heads
                                                        int capH = Integer.parseInt(Carray[h].toString());
							for (int z=0;z<capH;z++){	// head slots
								for (int y=0;y<numN;y++){	// nozzles
									if (pConf.isCompatibleNozzleTHeadT(y, h) && pConf.isCompatibleCompTNozzleT(c,y)){
										String xName = "x_("+m+"_"+h+"_"+z+"_"+y+")_("+boards[b]+"_"+c+")";
										c_1.addTerm(xVars[x_map.get(xName)], 1);
									}
								}
							}
						}
					}
					cplex.addEq(c_1, pPCB.getPiecesComps(boards[b], c));					// CONSTRAINT 1
					numConstraints++;
				}
			}
			
			int idx_c = numVarX+numVarY+numVarZ+numVarQ;
			for (int m=0;m<numM;m++){		// machines
				IloLinearNumExpr c_7 = cplex.linearNumExpr();
				for (int c=0;c<numC;c++){		// component types
					IloLinearNumExpr c_6 = cplex.linearNumExpr();
					for (int b=0;b<numB;b++){	// boards
						for (int h=0;h<numH;h++){	// heads
                                                        int capH = Integer.parseInt(Carray[h].toString());
							for (int z=0;z<capH;z++){	// head slots
								for (int y=0;y<numN;y++){	// nozzles
									if (pConf.isCompatibleNozzleTHeadT(y, h) && pConf.isCompatibleCompTNozzleT(c,y)){
										String xName = "x_("+m+"_"+h+"_"+z+"_"+y+")_("+boards[b]+"_"+c+")";
										c_6.addTerm(xVars[x_map.get(xName)], 1);
									}
								}
							}
						}
					}
					c_6.addTerm(xVars[idx_c], -K);
					cplex.addLe(c_6, 0);						// CONSTRAINT 6
					numConstraints++;
					c_7.addTerm(xVars[idx_c], pConf.getCompWidth(c));
					idx_c++;
				}
				cplex.addLe(c_7, pConf.getF());	// CONSTRAINT 7
				numConstraints++;
			}
			
			int idx_cycle = numVarX+numVarY+numVarZ+numVarQ+numVarC;
			for (int m=0;m<numM;m++){		// machines
				for (int b=0;b<numB;b++){	// boards
					for (int h=0;h<numH;h++){	// heads
                                                int capH = Integer.parseInt(Carray[h].toString());
						for (int z=0;z<capH;z++){	// head slots
							for (int y=0;y<numN;y++){	// nozzles
								if (pConf.isCompatibleNozzleTHeadT(y, h)){
									IloLinearNumExpr c_8 = cplex.linearNumExpr();
									for (int c=0;c<numC;c++){		// component types
										if (pConf.isCompatibleCompTNozzleT(c,y)){
											String xName = "x_("+m+"_"+h+"_"+z+"_"+y+")_("+boards[b]+"_"+c+")";
											c_8.addTerm(xVars[x_map.get(xName)], 1);
										}
									}
									c_8.addTerm(xVars[idx_cycle], -1);
									cplex.addLe(c_8, 0);		// CONSTRAINT 8
									numConstraints++;
								}
							}	
						}
					}
					idx_cycle++;
				}
			}
			
			int idx_lambda = numVarX+numVarY+numVarZ+numVarQ+numVarC+numVarCycle;
			
			for (int b=0;b<numB;b++){
				for (int m=0;m<numM;m++){		// machines
					IloLinearNumExpr c_9 = cplex.linearNumExpr();
					for (int h=0;h<numH;h++){	// heads
                                                int capH = Integer.parseInt(Carray[h].toString());
						for (int z=0;z<capH;z++){	// head slots
							for (int y=0;y<numN;y++){	// nozzles
								if (pConf.isCompatibleNozzleTHeadT(y, h)){
									for (int c=0;c<numC;c++){		// component types
										if (pConf.isCompatibleCompTNozzleT(c,y)){
											String xName = "x_("+m+"_"+h+"_"+z+"_"+y+")_("+boards[b]+"_"+c+")";
											c_9.addTerm(xVars[x_map.get(xName)], pConf.getPickPlaceTimeHead(h));
										}
									}
								}
							}
						}
					}
					idx_cycle = numVarX+numVarY+numVarZ+numVarQ+numVarC+m*numB+b;
					c_9.addTerm(xVars[idx_cycle], pConf.getTravelingTimeHead(0));
					c_9.addTerm(xVars[idx_lambda], -1);
					cplex.addLe(c_9, 0);		// CONSTRAINT 9
					numConstraints++;
					//idx_cycle++;
				}
				idx_lambda++;
			}
			//until this
			// ADDITIONAL CONSTRAINTS
			// Fix some variables by the summarized and excluded configuration graph
                        /*
			int numFixed = 0;
			int numExcl = 0;
			for (int i=numVarX;i<numVarX+numVarY+numVarZ+numVarQ;i++){
				try {
					double edgeValue = confG.getEdgeValue(xVars[i].getName());
					if (edgeValue == 1){
						IloLinearNumExpr cExtra = cplex.linearNumExpr();
						cExtra.addTerm(xVars[i], 1);
						cplex.addEq(cExtra, 1);
						numConstraints++;
						numFixed++;
					}
					else if (edgeValue == -1){
						IloLinearNumExpr cExtra = cplex.linearNumExpr();
						cExtra.addTerm(xVars[i], 1);
						cplex.addEq(cExtra, 0);
						numConstraints++;
						numExcl++;
					}
				}
				catch (LabelException e){
					System.err.println("Error in adding constraints: wrong label reference:"+e.getLabel());
				}
			}
			*/
			
			
			// OBJECTIVE: minimize the number of cycles weighted by the number of PCBs
			IloLinearNumExpr obj = cplex.linearNumExpr();
			for (int b=0;b<numB;b++){
				obj.addTerm(xVars[numVarTotal-numB+b], pPCB.getPiecesPCBs(boards[b]));
			}
			cplex.addMinimize(obj);
			
			//cplex.exportModel("model.lp");
			
			long end = System.currentTimeMillis();
			//System.out.println("\t... Done in "+(end-start)/1000+" sec");
			//System.out.println("Start optmizing ...");
			start = System.currentTimeMillis();

			/**/
			cplex.setParam(IloCplex.BooleanParam.MemoryEmphasis, true);	// using hdd when memory not enough
			cplex.setParam(IloCplex.Param.WorkMem,1024);		// memory size for storage
			cplex.setParam(IloCplex.Param.MIP.Strategy.File,3);	// put the nodes into file and comressed
			cplex.setParam(IloCplex.Param.MIP.Limits.TreeMemory,2048);			// maximum memory for tree
			//cplex.setParam(IloCplex.Param.Threads,1);			// use only one thread
			//cplex.setParam(IloCplex.Param.MIP.Tolerances.MIPGap, 1.0e-2);
			//cplex.setParam(IloCplex.Param.MIP.Limits.Solutions, 1);	// stop after first feasible integer solution - h�lyes�g 
                        cplex.setParam(IloCplex.DoubleParam.TiLim, timeLimit);	// time limit second
                        cplex.setOut(null);	// output during run - comment for output
                        //OutputStream s = new FileOutputStream("log.txt");
                        //cplex.setOut(s);
                        //s.close();
                        //System.out.println("\tNumber of variables = "+numVarTotal+"\tNumber of constraints = "+numConstraints);
                        /*
                        if (numFixed>0){
                            System.out.println("\tNumber of fixed edges = "+numFixed+"\texcluded edges = "+numExcl);
                        }
                        */
                        try {
                            cplex.solve();	// start
                        } catch (IloException e){
                            // ???
                            System.err.println(e.getMessage());
                        }
			
			end = System.currentTimeMillis();
			
			if (cplex.getStatus().equals(IloCplex.Status.Error) || cplex.getStatus().equals(IloCplex.Status.Unknown)){
				System.err.println("Error in cplex Solve");
                                ok = false;
				//System.exit(1);
			}
			if (cplex.getStatus().equals(IloCplex.Status.Unbounded) || cplex.getStatus().equals(IloCplex.Status.Infeasible))
			{ 
				System.out.println("\tNo solution: Unbounded or Infeasible");
                                ok = false;
				//cplex.exportModel("model_infeasible.lp");
				//System.exit(1);
			}
			else {
				if (cplex.getStatus().equals(IloCplex.Status.Optimal) || cplex.getStatus().equals(IloCplex.Status.Feasible)){
					//cplex.exportModel("model_feasible.lp");
					
					try {
						/**/
						if (cplex.getStatus().equals(IloCplex.Status.Optimal)) {
						//	System.out.println("\tSolution found: Optimal");
						}
						if (cplex.getStatus().equals(IloCplex.Status.Feasible)) {
						//	System.out.println("\tSolution found: Feasible");
						}
						/**/
						objValue = cplex.getObjValue();
						//System.out.print("\tObjective value = "+objValue);
						//System.out.println("\t\tRelative solution gap = "+cplex.getMIPRelativeGap());
						
						double[] xValues  = cplex.getValues(xVars);	// return values of variables
						/*
						for (int i=0;i<numVarX+numVarY+numVarZ+numVarQ+numVarC+numVarCycle+numVarLambda;i++){
							if (Math.round(xValues[i])>0){
								System.out.println(xVars[i].getName()+" = "+ Math.round(xValues[i]));
							}
						}
						*/
						for (int i=numVarX;i<numVarX+numVarY+numVarZ+numVarQ+numVarC;i++){
							/*if (Math.round(xValues[i])>0){
								if (!confG.setEdgeValue(xVars[i].getName(), 1)){
									System.err.println("Error: "+xVars[i].getName());
								}
							}*/
						}
					}
					catch (Exception e){
						e.printStackTrace();
                                                ok = false;
					}
				}
			}
			/**/
			
			
			
			//System.out.println("... Done in "+(end-start)/1000+" sec");
			cplex.end();
                       
                        
		}
		catch (Exception e){
 			e.printStackTrace();
 		}
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                seconds = (double)totalTime / 1_000_000_000.0;
                System.out.println(seconds);
                        
                
		return objValue;
		
	}
	
	
}
