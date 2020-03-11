
package Graphs;

import Tube.Node;
import java.util.ArrayList;

public class graphAnalysis {
    public static ArrayList<Node> connections(ArrayList<ArrayList> graph, String search, int category){
        ArrayList<Node> list = new ArrayList<Node>();
        ArrayList<ArrayList> nodes = new ArrayList<ArrayList>();
        
        switch(category){
            case 1:
                nodes = graph.get(1);
                break;
            case 2:
                nodes = graph.get(2);
                break;
            case 3:
                nodes = graph.get(3);
                break;
            case 4:
                nodes = graph.get(4);
                break;
            case 5:
                nodes = graph.get(5);
                break;
            case 6:
                nodes = graph.get(0);
                break;
            default:
                System.out.println("Wrong caregory");
                break;
        }
        
        for(int i=0; i<nodes.size(); i++){
            ArrayList<Node> nodeconnect = nodes.get(i);
            Node currentnode = nodeconnect.get(0);
            if(search.equals(currentnode.getLabel())){
                for(int j=1; j<nodeconnect.size(); j++){
                    Node connection = nodeconnect.get(j);
                    list.add(connection);
                }
            }
        }
        
        return list;
    }
    
    public static ArrayList<Node> parentNode(ArrayList<ArrayList> graph, String search, int category){
        ArrayList<Node> list = new ArrayList<Node>();
        ArrayList<ArrayList> nodes = new ArrayList<ArrayList>();
        
        switch(category){
            case 1:
                nodes = graph.get(0);
                break;
            case 2:
                nodes = graph.get(1);
                break;
            case 3:
                nodes = graph.get(2);
                break;
            case 4:
                nodes = graph.get(3);
                break;
            case 5:
                nodes = graph.get(4);
                break;
            case 6:
                nodes = graph.get(5);
                break;
            default:
                System.out.println("Wrong caregory");
                break;
        }
        
        for(int i=0; i<nodes.size(); i++){
            ArrayList<Node> nodeconnect = nodes.get(i);
            for(int j=1; j<nodeconnect.size(); j++){
                Node currentnode = nodeconnect.get(j);
                if(search.equals(currentnode.getLabel())){
                    Node parentnode = nodeconnect.get(0);
                    list.add(parentnode);
                }
            }
        }
        
        return list;
    }
    
    public static double edgesSum(ArrayList<ArrayList> graph){
        double edge = 0;
        double nodeNum = 0;
        
        for(int i=0; i<graph.size(); i++){
            ArrayList<ArrayList> nodecategory = graph.get(i);
            nodeNum += nodecategory.size();
            for(int j=0; j<nodecategory.size(); j++){
                ArrayList<Node> nodeconnect = nodecategory.get(j);
                for(int k=1; k<nodeconnect.size(); k++){
                    edge++;
                }
            }
        }
        edge = edge / nodeNum;
        
        return edge;
        
    }
    
    public static ArrayList<Double> edgesAverage(ArrayList<ArrayList> graph){
        ArrayList<Double> average = new ArrayList<Double>();
        for(int i = 0; i<graph.size(); i++){
            ArrayList<ArrayList> nodecategory = graph.get(i);
            double nodeNum = nodecategory.size();
            double edgeNum = 0;
            for(int j = 0; j<nodecategory.size(); j++){
                ArrayList<Node> nodeconnect = nodecategory.get(j);
                for(int k=1; k<nodeconnect.size(); k++){
                    edgeNum++;
                }
            }
            double averageNum = edgeNum / nodeNum;
            average.add(averageNum);
        }
        return average;
    }
}
