package redstring.data.graph;

//Class to represent Edge Definitions
class EdgeDefinition {
	private Node node;
	private String color;
	private String title;

	public EdgeDefinition(Node node) {
		this.setNode(node);
		this.setColor(node.getColor());
		this.setTitle(title);
	}
	
	// Getters and setters for node, color, and title
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
