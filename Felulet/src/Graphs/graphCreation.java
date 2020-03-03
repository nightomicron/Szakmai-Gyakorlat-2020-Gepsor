package Graphs;


import Start.SplashScreen;
import Tube.Graph;
import Tube.Product;
import Tube.SetUp;
import java.util.ArrayList;


public class graphCreation {
    public static Graph createLeft(SetUp conf, Product pcb){
        
        Graph sys = new Graph();
        
        ArrayList<ArrayList> modules = new ArrayList<ArrayList>();
        ArrayList<ArrayList> heads = new ArrayList<ArrayList>();
        ArrayList<ArrayList> slots = new ArrayList<ArrayList>();
        ArrayList<ArrayList> nozzles = new ArrayList<ArrayList>();
        ArrayList<ArrayList> componenttypes = new ArrayList<ArrayList>();
        ArrayList<ArrayList> components = new ArrayList<ArrayList>();
        Object[] c = conf.getC();
        
        //componenttypes and its connections into arraylist
        for(int i = 0; i<conf.getA(); i++){
            ArrayList<String> a = new ArrayList<String>();
            //adding name as the first item in the list
            a.add("A" + (i+1));
            sys.setNumA();
            //adding the connections
            for(int j = 0; j<conf.getM(); j++){
                a.add("M" + (j+1));
                sys.setConA();
            }
            componenttypes.add(a);
        }
        
        //modules and their connections into arraylist
        ArrayList<Integer> sizem = new ArrayList<Integer>();
        for(int i = 0; i<conf.getM(); i++){
            ArrayList<String> m = new ArrayList<String>();
            //adding name as the first item in the list
            m.add("M"+(i+1));
            //counter for heads
            sys.setNumM();
            int tempm = 0;
            //adding the connections
            for(int j = 0; j<conf.getH();j++){
                m.add("H"+(i+1)+(j+1));
                tempm++;
                sys.setConM();
            }
            modules.add(m);
            sizem.add(tempm);
        }
        
        //heads and their connections into arraylist
        int currentc = 0;
        //counter for slot number
        int temps = 0;
        for(int i = 0; i<modules.size(); i++){
            ArrayList<String> m = modules.get(i);
            for(int j = 0; j < sizem.get(i); j++){
                currentc = Integer.parseInt(c[j].toString());
                ArrayList<String> h = new ArrayList<String>();
                //adding name as the first item in the list
                h.add(m.get(j+1));
                sys.setNumH();
                //adding the connections
                for(int k = 0; k<currentc; k++){
                    h.add("S"+(i+1)+(j+1)+(k+1));
                    temps++;
                    sys.setConH();
                } 
                heads.add(h);
            }
        }
        
        //slots and their connections into arraylist
        /*Object[][] nh = conf.getNh();
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                System.out.print(nh[j][i]);
            }
            System.out.println();
        }*/
        
        //kerdes: mivan ha a index nagyobb mint 9 pl.: h1313 tizenharom tizenharom vagy szazharmincegy egy
        
        //arrays into OBJECT
        sys.setComponenttypes(componenttypes);
        sys.setModules(modules);
        sys.setHeads(heads);
        
        System.out.println(sys.getNumA());
        System.out.println(sys.getConA());
        System.out.println(sys.getNumM());
        System.out.println(sys.getConM());
        System.out.println(sys.getNumH());
        System.out.println(sys.getConH());
        return sys;
        
    }
}
