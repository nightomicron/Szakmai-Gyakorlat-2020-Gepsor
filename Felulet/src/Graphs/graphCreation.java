package Graphs;


import Start.SplashScreen;
import Tube.Node;
import Tube.Product;
import Tube.SetUp;
import java.util.ArrayList;


public class graphCreation {
    public static ArrayList<ArrayList> create(SetUp conf, Product pcb){
        
        ArrayList<ArrayList> graph = new ArrayList<ArrayList>();
        
        ArrayList<ArrayList> modules = new ArrayList<ArrayList>();
        ArrayList<ArrayList> comptypes = new ArrayList<ArrayList>();
        ArrayList<ArrayList> heads = new ArrayList<ArrayList>();
        ArrayList<ArrayList> slots = new ArrayList<ArrayList>();
        ArrayList<ArrayList> nozzles = new ArrayList<ArrayList>();
        ArrayList<ArrayList> components = new ArrayList<ArrayList>();
        
        Object[] c = conf.getC();
        
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
        //level of modules
        for(int i = 0; i<conf.getM(); i++){
            ArrayList<Node> mod = new ArrayList<Node>();
            Node namem = new Node("m" + (i+1), 1);
            mod.add(namem); //adding name for the module node
            
            //level of heads
            for(int j = 0; j<conf.getH(); j++){
                ArrayList<Node> head = new ArrayList<Node>();
                Node h = new Node("h" + (i+1) + "_" + (j+1), 2); //creating the connecting nodes of the current module
                mod.add(h); //adding connections to the current module node
                
                head.add(h); //naming the current head node
                int currentc = Integer.parseInt(c[j].toString()); //slots of the currently checked head
                
                //level of slots
                for(int k = 0; k<currentc; k++){
                    ArrayList<Node> slot = new ArrayList<Node>();
                    Node s = new Node("s" + (i+1) + "_" + (j+1) + "_" + (k+1), 3); //creating connecting nodes of the current head
                    head.add(s); //adding connections to the current head node
                    
                    slot.add(s); //naming the current slot node (as the currently created connection)
                    
                    //level of nozzles
                    //insert next for cycle here
                }
                
                heads.add(head);
            }
            
            modules.add(mod);
        }
        graph.add(modules);
        graph.add(heads);
        
        return graph;
        
    }
}
