public class Ticket {
    // Instance variables
    private int id;
    private String creator;
    private String owner;
    private int priority;
    private String timestamp;
    
    private char newLine = 10;

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
    public String toString() {
        String priorityMessage = "";

        switch (priority) {
            case 1:
                priorityMessage = "TICKET (1 - SECURITY ISSUE)";
                break;
            case 2:
                priorityMessage = "TICKET (2 - NETWORK ISSUE)";
                break;
            case 3:
                priorityMessage = "TICKET (3 - SOFTWARE / APP INSTALLATION)";
                break;
            case 4:
                priorityMessage = "TICKET (4 - NEW COMPUTER CONFIGURATION)";
                break;
            default:
                break;
        }

        return priorityMessage + newLine + "ID : " + id + newLine + "Priority : " + priority + newLine + "Submitted by : " + creator + newLine + "Assigned to: " + owner + newLine + "Submitted : " + timestamp + newLine;
    }

    public String toStringEnd() {
        String priorityMessage = "";

        switch (priority) {
            case 1:
                priorityMessage = "TICKET (1 - SECURITY ISSUE)";
                break;
            case 2:
                priorityMessage = "TICKET (2 - NETWORK ISSUE)";
                break;
            case 3:
                priorityMessage = "TICKET (3 - SOFTWARE / APP INSTALLATION)";
                break;
            case 4:
                priorityMessage = "TICKET (4 - NEW COMPUTER CONFIGURATION)";
                break;
            default:
                break;
        }

        return priorityMessage + newLine + "ID : " + id + newLine + "Priority : " + priority + newLine + "Submitted by : " + creator + newLine + "Assigned to: " + owner + newLine + "Submitted : " + timestamp;
    }
}