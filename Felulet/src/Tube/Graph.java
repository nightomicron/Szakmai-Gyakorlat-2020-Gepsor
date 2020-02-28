
package Tube;

import java.util.ArrayList;

public class Graph {
    private ArrayList<String> modules = new ArrayList<String>();
    private ArrayList<String> heads = new ArrayList<String>();
    private ArrayList<String> slots = new ArrayList<String>();
    private ArrayList<String> nozzles = new ArrayList<String>();
    private ArrayList<String> componenttypes = new ArrayList<String>();
    private ArrayList<String> components = new ArrayList<String>();

    public Graph() {
        
    }
    
    public void setModules(ArrayList<String> modules) {
        this.modules = modules;
    }

    public void setHeads(ArrayList<String> heads) {
        this.heads = heads;
    }

    public void setSlots(ArrayList<String> slots) {
        this.slots = slots;
    }

    public void setNozzles(ArrayList<String> nozzles) {
        this.nozzles = nozzles;
    }

    public void setComponenttypes(ArrayList<String> componenttypes) {
        this.componenttypes = componenttypes;
    }

    public void setComponents(ArrayList<String> components) {
        this.components = components;
    }

    public ArrayList<String> getModules() {
        return modules;
    }

    public ArrayList<String> getHeads() {
        return heads;
    }

    public ArrayList<String> getSlots() {
        return slots;
    }

    public ArrayList<String> getNozzles() {
        return nozzles;
    }

    public ArrayList<String> getComponenttypes() {
        return componenttypes;
    }

    public ArrayList<String> getComponents() {
        return components;
    }
    
    
    
}
