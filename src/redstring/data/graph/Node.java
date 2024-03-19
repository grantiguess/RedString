package redstring.data.graph;

import java.util.ArrayList;
import java.util.List;

public class Node extends Entry {

	/** List of graph definitions that could potentially replace the node in a graph
	 *  (Reverse Blackboxing)
	 */
	@SuppressWarnings("unused")
	private ArrayList<Graph> definitions;
	
	/** Element contained in the node */
	private Object data;
	
	/** List of edges for this node */
    private List<Edge> edges;

    /**
     * Constructor for a Node
     * @param element the element to initialize
     */
    public Node(Object data) {
    	this(); //runs empty constructor
        this.data = data;
    }
    
    public Node() {
    	this.edges = new ArrayList<>();
        this.definitions = new ArrayList<Graph>();
    }

    /**
     * Adds an edge to a given node's list of edges
     * @param edge the edge to add
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    /**
     * Gets a list of all the edges of a given node
     * @return list of all the edges of a given node
     */
    public List<Edge> getEdges() {
        return edges;
    }
    
    /**
     * Gets the element contained in a given node
     * @return the element
     */
    public Object getData() {
    	return this.data;
    }
    
    public ArrayList<Graph> getDefinitions() {
    	return this.definitions;
    }
    
    public boolean addDefinition(Graph g) {
    	return this.definitions.add(g);
    }

}
