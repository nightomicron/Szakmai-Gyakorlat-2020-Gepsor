
package Tube;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList> modules = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> heads = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> slots = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> nozzles = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> componenttypes = new ArrayList<ArrayList>();
    private ArrayList<ArrayList> components = new ArrayList<ArrayList>();
    
    private int numA;
    private int conA;
    private int numM;
    private int conM;
    private int numH;
    private int conH;
    private int numS;
    private int conS;
    private int conN;
    private int conR;
    
    public Graph() {
        numA = 0;
        conA = 0;
        numM = 0;
        conM = 0;
        numH = 0;
        conH = 0;
        numS = 0;
        conS = 0;
        conN = 0;
        conR = 0;
    }
    
    public void setModules(ArrayList<ArrayList> modules) {
        this.modules = modules;
    }

    public void setHeads(ArrayList<ArrayList> heads) {
        this.heads = heads;
    }

    public void setSlots(ArrayList<ArrayList> slots) {
        this.slots = slots;
    }

    public void setNozzles(ArrayList<ArrayList> nozzles) {
        this.nozzles = nozzles;
    }

    public void setComponenttypes(ArrayList<ArrayList> componenttypes) {
        this.componenttypes = componenttypes;
    }

    public void setComponents(ArrayList<ArrayList> components) {
        this.components = components;
    }

    public ArrayList<ArrayList> getModules() {
        return modules;
    }

    public ArrayList<ArrayList> getHeads() {
        return heads;
    }

    public ArrayList<ArrayList> getSlots() {
        return slots;
    }

    public ArrayList<ArrayList> getNozzles() {
        return nozzles;
    }

    public ArrayList<ArrayList> getComponenttypes() {
        return componenttypes;
    }

    public ArrayList<ArrayList> getComponents() {
        return components;
    }

    public int getNumA() {
        return numA;
    }

    public int getConA() {
        return conA;
    }

    public int getNumM() {
        return numM;
    }

    public int getConM() {
        return conM;
    }

    public int getNumH() {
        return numH;
    }

    public int getConH() {
        return conH;
    }

    public int getNumS() {
        return numS;
    }

    public int getConS() {
        return conS;
    }

    public void setNumA() {
        numA++;
    }

    public void setConA() {
        conA++;
    }

    public void setNumM() {
        numM++;
    }

    public void setConM() {
        conM++;
    }

    public void setNumH() {
        numH++;
    }

    public void setConH() {
        conH++;
    }

    public void setNumS() {
        numS++;
    }

    public void setConS() {
        conS++;
    }

    public int getConN() {
        return conN;
    }

    public int getConR() {
        return conR;
    }
    
    public void setConN() {
        conN++;
    }
    
    public void setConR() {
        conR++;
    }
}
