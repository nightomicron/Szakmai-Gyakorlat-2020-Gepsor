
package Graphs;

import Tube.Node;
import java.util.ArrayList;

public class graphAnalysis {
    //this method returns the connecting nodes of the chosen parent node
    //its parameters are: graph array, chosen parent node label, node type
    //types are 1: module (m), 2: head (h), 3: slot (s), 4: nozzle (n), 5: components (r), 6: component types (a)
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
    //this method returns the parent node of a chosen node
    //its parameters are: graph array, chosen node label, node type
    //types are 1: module (m), 2: head (h), 3: slot (s), 4: nozzle (n), 5: components (r), 6: component types (a)
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
    
    /*public static ArrayList<Integer> SumByType(ArrayList<ArrayList> graph){
        ArrayList<Integer> sum = new ArrayList<Integer>();
        for(int i = 0; i<graph.size(); i++){
            ArrayList<ArrayList> nodecategory = graph.get(i);
            int nodeNum = nodecategory.size();
            int edgeNum = 0;
            for(int j = 0; j<nodecategory.size(); j++){
                ArrayList<Node> nodeconnect = nodecategory.get(j);
                for(int k=1; k<nodeconnect.size(); k++){
                    edgeNum++;
                }
            }
            sum.add(edgeNum);
        }
        return sum;
    }*/
    
    //this method returns the average of the total sum of every edge of the graph
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
    //this method returns the average of the sum of every single edge of the graph by type
    //returns an arraylist
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
    //returns the average of the independent routes of a graph by type and also the total average
    public static ArrayList<String[]> independentRoutes(ArrayList<ArrayList> graph){
        ArrayList<ArrayList> modules = graph.get(1);
        ArrayList<ArrayList> comptypes = graph.get(0);
        ArrayList<ArrayList> heads = graph.get(2);
        ArrayList<ArrayList> slots = graph.get(3);
        ArrayList<ArrayList> nozzles = graph.get(4);
        ArrayList<ArrayList> components = graph.get(5);
        ArrayList<String[]> results = new ArrayList<String[]>();
        double averageOfAll = 0;
        
        for(int i=0; i<components.size(); i++){
            //setting up the variables, converting the component nodes to string
            ArrayList<Node> nodes = components.get(i);
            Node nodeComp = nodes.get(0);
            String currentcomp = nodeComp.getLabel();
            String[] nodeAverage = new String[2];
            nodeAverage[0] = currentcomp;
            double routes = 0;
            //checking the current components parents
            ArrayList<Node> compparents = parentNode(graph, currentcomp, 5);
            for(int j=0; j<compparents.size(); j++){
                Node nodeNozzle = compparents.get(j);
                String currentnozzle = nodeNozzle.getLabel();
                //checking the current nozzles parents
                ArrayList<Node> nozzleparents = parentNode(graph, currentnozzle, 4);
                for(int k=0; k<nozzleparents.size(); k++){
                    Node nodeSlot = nozzleparents.get(k);
                    String currentslot = nodeSlot.getLabel();
                    //checking the current slots parents
                    ArrayList<Node> slotparents = parentNode(graph, currentslot, 3);
                    for(int l=0; l<slotparents.size(); l++){
                        Node nodeHead = slotparents.get(l);
                        String currenthead = nodeHead.getLabel();
                        //checking the current heads parents
                        ArrayList<Node> headparents = parentNode(graph, currenthead, 2);
                        //adding the parents to the route counter
                        routes += headparents.size();
                    }
                }
            }
            //checking if there are routes
            if(routes != 0){
                routes = routes/modules.size();
                //adding the average of routes to the array
                nodeAverage[1] = routes+"";
                results.add(nodeAverage);
                averageOfAll += routes;
            }else{
                System.out.println("There are no routes for " + currentcomp);
            }
        }
        //counting the total average
        if(averageOfAll != 0){
            String[] nodeAverage = new String[2];
            averageOfAll = averageOfAll/components.size();
            nodeAverage[0] = "Total Average: ";
            nodeAverage[1] = averageOfAll+"";
            results.add(nodeAverage);
        }else{
            System.out.println("Something is not right, there are no routes between any components and modules at all");
        }
        return results;
        
        
    }
}
