
package Tube;

public class Node {
    String label;
    int type; //1: module (m), 2: head (h), 3: slot (s), 4: nozzle (n), 5: components (r), 6: component types (a)

    public Node(String label, int type) {
        this.label = label;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public int getType() {
        return type;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setType(int type) {
        this.type = type;
    }
}
