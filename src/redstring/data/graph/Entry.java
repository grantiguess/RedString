package redstring.data.graph;

public abstract class Entry {
	/** Name of the entry */
    private String name;
    /** Description of the entry */
    private String description;
    /** Picture of the entry */
    private String picture;
    /** Color of the entry */
    private String color;
    /** Unique ID of the entry */
    private long id;

    public Entry() {
    	this.name = "Untitled";
    	this.description = "No description.";
    	this.picture = "";
    	this.id = -1;
    }
    
    public Entry(String name, String description, String picture, String color, long id) {
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.color = color;
        this.id = id;
    }

    // Getters and setters for name, description, and picture

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String getId() {
        return picture;
    }

    public void setId(long id) {
        this.id = id;
    }
}
