package Graphs;


import Start.SplashScreen;
import Tube.Node;
import Tube.Product;
import Tube.SetUp;
import java.util.ArrayList;


public class graphCreation {
    //this method returns a graph converted from a configuration file and a pcb file
    //parameters are: setup configuration file, pcb file
    public static ArrayList<ArrayList> create(SetUp conf, Product pcb){
        
        ArrayList<ArrayList> graph = new ArrayList<ArrayList>();
        
        ArrayList<ArrayList> modules = new ArrayList<ArrayList>();
        ArrayList<ArrayList> comptypes = new ArrayList<ArrayList>();
        ArrayList<ArrayList> heads = new ArrayList<ArrayList>();
        ArrayList<ArrayList> slots = new ArrayList<ArrayList>();
        ArrayList<ArrayList> nozzles = new ArrayList<ArrayList>();
        ArrayList<ArrayList> components = new ArrayList<ArrayList>();
        
        Object[] c = conf.getC();
        Object[][] nh = conf.getNh();
        Object[][] an = conf.getAn();
        Object[][] rtable = pcb.getR();
        
        //componenttypes and its connections into arraylist
        for(int i = 1; i<conf.getA()+1; i++){
            ArrayList<Node> al = new ArrayList<Node>();
            Node name = new Node("a" + i, 6);
            al.add(name);
            for(int j = 1; j<conf.getM()+1; j++){
                Node m = new Node("m" + j, 1);
                al.add(m);
            }
            comptypes.add(al);
        }
        graph.add(comptypes);
        
        //modules and their connections into arraylist
        //level of initialization
        for(int i = 0; i<conf.getM(); i++){
            ArrayList<Node> mod = new ArrayList<Node>();
            Node namem = new Node("m" + (i+1), 1);
            mod.add(namem); //adding name for the module node
            
            //level of modules
            for(int j = 0; j<conf.getH(); j++){
                ArrayList<Node> head = new ArrayList<Node>();
                Node h = new Node("h" + (i+1) + "_" + (j+1), 2); //creating the connecting nodes of the current module
                mod.add(h); //adding connections to the current module node
                
                head.add(h); //naming the current head node
                int currentc = Integer.parseInt(c[j].toString()); //slots of the currently checked head
                
                //level of heads
                for(int k = 0; k<currentc; k++){
                    ArrayList<Node> slot = new ArrayList<Node>();
                    Node s = new Node("s" + (i+1) + "_" + (j+1) + "_" + (k+1), 3); //creating connecting nodes of the current head
                    head.add(s); //adding connections to the current head node
                    
                    slot.add(s); //naming the current slot node (as the currently created connection)
                    
                    //level of slots
                    for(int row = 0; row<conf.getN(); row++){
                        if(Integer.parseInt(nh[row][j].toString()) == 1){
                            Node n = new Node("n" + (i+1) + "_" + (j+1) + "_" + (k+1) + "_" + (row+1), 4);
                            slot.add(n); //adding connections to the current slot node
                                
                            ArrayList<Node> nozzle = new ArrayList<Node>();
                            nozzle.add(n); //naming the current nozzle node
                            
                            //level of nozzles
                            for(int v=0; v<pcb.getB(); v++){
                                for(int t=0; t<conf.getA(); t++){
                                    if(Integer.parseInt(an[t][row].toString()) == 1){
                                        int counterd = Integer.parseInt(rtable[v][t].toString()); //rTable variable at the right cell
                                        for(int counter=0; counter<counterd; counter++){
                                            Node r = new Node("r" + (t+1) + "_" + (v+1) + "_" + (counter+1), 5);
                                            nozzle.add(r); //adding connections to the current nozzle node
                                            
                                            //level of components
                                            boolean contains = false;
                                            for(int checker=0; checker < components.size(); checker++){ //checking if the currently created component node exists or not
                                                ArrayList<Node> extract = components.get(checker);      //if it exists then it wont add it to the components list
                                                Node check = extract.get(0);                            //we avoid repetition
                                                if(r.getLabel().equals(check.getLabel())){
                                                    contains = true;
                                                }
                                            }
                                            
                                            if(contains==false){
                                                ArrayList<Node> component = new ArrayList<Node>();
                                                component.add(r);
                                                    
                                                Node a = new Node("a" + (t+1), 6);
                                                component.add(a);
                                                components.add(component);
                                            }
                                        }
                                    }
                                }
                            }
                            
                            nozzles.add(nozzle);
                        }
                    }
                        
                    slots.add(slot);
                }
                
                heads.add(head);
            }
            
            modules.add(mod);
        }
        graph.add(modules);
        graph.add(heads);
        graph.add(slots);
        graph.add(nozzles);
        graph.add(components);
        
        return graph;
        
    }
}
