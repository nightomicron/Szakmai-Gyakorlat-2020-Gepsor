package Graphs;


import Start.SplashScreen;
import Tube.Product;
import Tube.SetUp;
import java.util.ArrayList;


public class graphCreation {
    public static void create(SetUp conf, Product pcb){
        ArrayList<ArrayList> modules = new ArrayList<ArrayList>();
        ArrayList<ArrayList> heads = new ArrayList<ArrayList>();
        ArrayList<ArrayList> slots = new ArrayList<ArrayList>();
        ArrayList<ArrayList> nozzles = new ArrayList<ArrayList>();
        ArrayList<ArrayList> componenttypes = new ArrayList<ArrayList>();
        ArrayList<ArrayList> components = new ArrayList<ArrayList>();
        Object[] c = conf.getC();
        
        ArrayList<Integer> sizem = new ArrayList<Integer>();
        for(int i = 0; i<conf.getM(); i++){
            ArrayList<String> m = new ArrayList<String>();
            m.add("m"+(i+1));
            int tempm = 0;
            for(int j = 0; j<conf.getH();j++){
                m.add("h"+(i+1)+(j+1));
                tempm++;
            }
            modules.add(m);
            sizem.add(tempm);
        }
        
        int currentc = 0;
        for(int i = 0; i<modules.size(); i++){
            ArrayList<String> m = modules.get(i);
            for(int j = 0; j < sizem.get(i); j++){
                currentc = Integer.parseInt(c[j].toString());
                ArrayList<String> h = new ArrayList<String>();
                h.add(m.get(j+1));
                for(int k = 0; k<currentc; k++){
                    h.add("s"+(i+1)+(j+1)+(k+1));
                } 
                heads.add(h);
            }
        }
        System.out.println(heads);
    }
}
