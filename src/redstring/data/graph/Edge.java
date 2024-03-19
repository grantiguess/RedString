package redstring.data.graph;

import java.util.ArrayList;
import java.util.List;

public class Edge extends Entry {
    private Node source;
    private Node destination;
    
    private List<Node> definitions;

    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }
    
    public Edge(Node source, Node destination, Node def) {
        this.source = source;
        this.destination = destination;
        this.definitions = new ArrayList<>();
        definitions.add(def);
    }
    
    public Node getSource() {
    	return this.source;
    }
    
    public Node getDestination() {
    	return this.destination;
    }
}
