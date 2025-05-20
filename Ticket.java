public class Ticket {
    // Instance variables
    private int id;
    private String creator;
    private String owner;
    private int priority;
    private String timestamp;

    // Ticket constructor
    public Ticket (int id, String creator, String owner, int priority, String timestamp) {
        this.id = id;
        this.creator = creator;
        this.owner = owner;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId() { return id; }
    public String getCreator() { return creator; }
    public String getOwner() { return owner; }
    public int getPriority() { return priority; }
    public String getTimestamp() { return timestamp; }

    // Setters
    public void setOwner (String owner) { this.owner = owner; }
    public void setPriority (int priority) {this.priority = priority; }

    // ToDo toString format ticket information
    
}