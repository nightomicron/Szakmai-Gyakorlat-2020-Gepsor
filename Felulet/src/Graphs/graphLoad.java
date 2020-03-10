
package Graphs;

import Tube.Node;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class graphLoad {
    public static ArrayList<ArrayList> loadGraph(String fname) throws FileNotFoundException, IOException{
        ArrayList<ArrayList> modules = new ArrayList<ArrayList>();
        ArrayList<ArrayList> graph=new ArrayList<ArrayList>();
        ArrayList<ArrayList> comptypes = new ArrayList<ArrayList>();
        ArrayList<ArrayList> heads = new ArrayList<ArrayList>();
        ArrayList<ArrayList> slots = new ArrayList<ArrayList>();
        ArrayList<ArrayList> nozzles = new ArrayList<ArrayList>();
        ArrayList<ArrayList> components = new ArrayList<ArrayList>();
         
         //arraylist graph > arraylist modules > node components > objectnode
         //1: module (m), 2: head (h), 3: slot (s), 4: nozzle (n), 5: components (r), 6: component types (a)
        try
        {
            BufferedReader br= new BufferedReader(new FileReader(fname));
            String sor;
            while((sor=br.readLine())!=null)
            {
                if(sor != ""){
                    switch(sor.charAt(0)){
                    case 'a' :
                        String a[]=sor.split(" ");
                        ArrayList<Node> alist = new ArrayList<Node>();
                        Node aparent = new Node(a[0],6);
                        alist.add(aparent);
                        System.out.print(aparent.getLabel() + " ");
                        for(int i = 1 ; i < a.length; i++){
                            Node child = new Node(a[i],1);
                            alist.add(child);
                            System.out.print(child.getLabel() + " ");
                        }
                        System.out.println();
                        comptypes.add(alist);
                        break;
                    case 'm' :
                        String m[]=sor.split(" ");
                        ArrayList<Node> mlist = new ArrayList<Node>();
                        Node mparent = new Node(m[0],1);
                        mlist.add(mparent);
                        for(int i = 1 ; i < m.length; i++){
                            Node child = new Node(m[i],2);
                            mlist.add(child);
                        }
                        modules.add(mlist);
                        break;
                        
                    case 'h' :
                        String h[]=sor.split(" ");
                        ArrayList<Node> hlist = new ArrayList<Node>();
                        Node hparent = new Node(h[0],2);
                        hlist.add(hparent);
                        for(int i = 1 ; i < h.length; i++){
                            Node child = new Node(h[i],3);
                            hlist.add(child);
                        }
                        heads.add(hlist);
                        break;
                    case 's' :
                        String s[]=sor.split(" ");
                        ArrayList<Node> slist = new ArrayList<Node>();
                        Node sparent = new Node(s[0],2);
                        slist.add(sparent);
                        for(int i = 1 ; i < s.length; i++){
                            Node child = new Node(s[i],3);
                            slist.add(child);
                        }
                        slots.add(slist);
                        break;
                    case 'n' :
                        String n[]=sor.split(" ");
                        ArrayList<Node> nlist = new ArrayList<Node>();
                        Node nparent = new Node(n[0],2);
                        nlist.add(nparent);
                        for(int i = 1 ; i < n.length; i++){
                            Node child = new Node(n[i],3);
                            nlist.add(child);
                        }
                        nozzles.add(nlist);
                        break;
                    case 'r' :
                        String r[]=sor.split(" ");
                        ArrayList<Node> rlist = new ArrayList<Node>();
                        Node rparent = new Node(r[0],2);
                        rlist.add(rparent);
                        for(int i = 1 ; i < r.length; i++){
                            Node child = new Node(r[i],3);
                            rlist.add(child);
                        }
                        components.add(rlist);
                        break;
                    }
                }
               
                
                
                //listába rakás helye 
            }
            graph.add(comptypes);
            graph.add(modules);
            graph.add(heads);
            graph.add(slots);
            graph.add(nozzles);
            graph.add(components);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return graph;
        
    }
}
