package redstring.data.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph extends Entry {
	
    private Map<Node, List<Edge>> adjacencyList;
    private String name;
    private boolean directed;
    
    public Graph() {
        adjacencyList = new HashMap<>();
        directed = true;
    }
    
    public Graph( boolean direction ) {
    	this.directed = direction;
    	adjacencyList = new HashMap<>();
    }
    
    public Map<Node, List<Edge>> getAdjacencyList() {
    	return this.adjacencyList;
    }
    
    public boolean isDirected() {
    	return this.directed;
    }
    
    public String getName() {
    	return this.name;
    }

    public void addNode(Node node) {
        adjacencyList.put(node, new ArrayList<>());
    }
    
    public void removeNode(Node node) {
        // Remove the node itself from the adjacency list
        adjacencyList.remove(node);

        // Remove any edges that have this node as the source or destination
        for (List<Edge> edges : adjacencyList.values()) {
            edges.removeIf(edge -> edge.getSource().equals(node) || edge.getDestination().equals(node));
        }
    }

    public void addEdge(Node source, Node destination) {
        if (!adjacencyList.containsKey(source)) {
            addNode(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addNode(destination);
        }
        Edge edge = new Edge(source, destination);
        adjacencyList.get(source).add(edge);
        // For an undirected graph, you can add the following lines to create a bidirectional edge:
        if ( !directed ) {
        	Edge reverseEdge = new Edge(destination, source);
            adjacencyList.get(destination).add(reverseEdge);
        }
    }
    
    public void removeEdge(Node source, Node destination) {
        if (adjacencyList.containsKey(source)) {
            List<Edge> edges = adjacencyList.get(source);
            edges.removeIf(edge -> edge.getDestination().equals(destination));
        }
        // For an undirected graph, you would also remove the reverse edge from the destination node's list.
        if (!directed && adjacencyList.containsKey(destination)) {
            List<Edge> edges = adjacencyList.get(destination);
            edges.removeIf(edge -> edge.getDestination().equals(destination));
        }
    }

    public List<Edge> getEdges(Node node) {
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }
	
    public Node compose(String name) {
    	Node n = new Node();
    	n.setName(name);
    	n.addDefinition(this);
    	
		return n;
    }
}
