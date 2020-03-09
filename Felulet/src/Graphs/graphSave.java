
package Graphs;

import Tube.Node;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class graphSave {
    
    //this method saves the graph nodes and their connecting nodes to a file
    //example:
    //Node1, Connection1, Connection2
    //Node2, Connection1, Connection2
    public static void saveGraph(ArrayList<ArrayList> graph, String fname) throws FileNotFoundException{
        ArrayList<ArrayList> modules = graph.get(1);
        ArrayList<ArrayList> comptypes = graph.get(0);
        ArrayList<ArrayList> heads = graph.get(2);
        ArrayList<ArrayList> slots = graph.get(3);
        ArrayList<ArrayList> nozzles = graph.get(4);
        ArrayList<ArrayList> components = graph.get(5);
                
        PrintStream out = new PrintStream(new FileOutputStream(fname));
        System.setOut(out);
        
        for(int i=0; i<comptypes.size(); i++){
            ArrayList<Node> a = comptypes.get(i);
            Node node = a.get(0);
            System.out.print(node.getLabel() + ", ");
            for(int j=1; j<a.size(); j++){
                node = a.get(j);
                if(j != a.size()-1){
                    System.out.print(node.getLabel() + ", ");
                }else{
                    System.out.println(node.getLabel());
                }
            }
        }
        for(int i=0; i<modules.size(); i++){
            ArrayList<Node> m = modules.get(i);
            Node node = m.get(0);
            System.out.print(node.getLabel() + ", ");
            for(int j=1; j<m.size(); j++){
                node = m.get(j);
                if(j != m.size()-1){
                    System.out.print(node.getLabel() + ", ");
                }else{
                    System.out.println(node.getLabel());
                }
            }
        }
        for(int i=0; i<heads.size(); i++){
            ArrayList<Node> h = heads.get(i);
            Node node = h.get(0);
            System.out.print(node.getLabel() + ", ");
            for(int j=1; j<h.size(); j++){
                node = h.get(j);
                if(j != h.size()-1){
                    System.out.print(node.getLabel() + ", ");
                }else{
                    System.out.println(node.getLabel());
                }
            }
        }
        for(int i=0; i<slots.size(); i++){
            ArrayList<Node> s = slots.get(i);
            Node node = s.get(0);
            System.out.print(node.getLabel() + ", ");
            for(int j=1; j<s.size(); j++){
                node = s.get(j);
                if(j != s.size()-1){
                    System.out.print(node.getLabel() + ", ");
                }else{
                    System.out.println(node.getLabel());
                }
            }
        }
        for(int i=0; i<nozzles.size(); i++){
            ArrayList<Node> n = nozzles.get(i);
            Node node = n.get(0);
            System.out.print(node.getLabel() + ", ");
            for(int j=1; j<n.size(); j++){
                node = n.get(j);
                if(j != n.size()-1){
                    System.out.print(node.getLabel() + ", ");
                }else{
                    System.out.println(node.getLabel());
                }
            }
        }
        for(int i=0; i<components.size(); i++){
            ArrayList<Node> r = components.get(i);
            Node node = r.get(0);
            System.out.print(node.getLabel() + ", ");
            for(int j=1; j<r.size(); j++){
                node = r.get(j);
                if(j != r.size()-1){
                    System.out.print(node.getLabel() + ", ");
                }else{
                    System.out.println(node.getLabel());
                }
            }
        }
        
        out.close();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
}
