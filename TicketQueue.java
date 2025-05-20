public class TicketQueue {
    private Node head;
    private int nextId = 1;
    
    public TicketQueue() {
        this.head = null;
    }

    public void createTicket(String creator,  String owner, int priority, String timestamp) {
        // Setting ID
        int id = nextId;
        nextId++; // This implementation for a ticket ID is basic and has no persistence. When the program closes, all tickets will be lost

        // Creating objects
        Ticket ticket = new Ticket(id, creator, owner, priority, timestamp);
        Node node = new Node(ticket);

        /* 
        If no head, set latest node as head
        OR 
        If latest ticket has a higher priority than head, replace head with it
        BODY
        Exit method
        */
        if (head == null || ticket.getPriority() < head.ticket.getPriority()) {
            node.next = head;
            head = node;
            return;
        } 

        // Searches list for the next ticket with lower priority than current
        Node current = head; // Start
        while (current.next != null && current.next.ticket.getPriority() <= ticket.getPriority()) {
            current = current.next;
        }

        // Inserting node
        node.next = current.next;
        current.next = node;
    }

    public void listTickets() {
        // Loops through the list with Node.next and prints using the Ticket.toString() method
        System.out.print("\n"); // New line on beginning of list

        Node current = head; // Start
        while (current != null) {
            if (current.next != null) {
                System.out.println(current.ticket.toString());
            } else { // Consider the last ticket is at the end of the list. Why do a useless extra check for every item if I know where it is? Specificity in the conditions
                System.out.println(current.ticket.toStringEnd());
            }

            current = current.next;
        }
    }

    public void deleteTicket(int id) {
        if (head == null) { // Again, head == null means that the list is empty
            System.out.println("[ERROR] There are no tickets to delete.\n");
            return;
        } else if (head.ticket.getId() == id) { // If given ID matches first item on list, delete that ticket
            head = head.next; // Effectively deletes the original head node, replacing it with the next ticket in the list
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.ticket.getId() != id) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR] No such ticket exists with the ID [" + id + "]. \n");
            return;
        }

        System.out.println("[INFO] Ticket with ID " + current.ticket.getId() + " successfully deleted.");
        previous.next = current.next; // Removes the specific ticket
    }

    public Ticket searchTicket(int id) {
        if (head == null) {
            System.out.println("[ERROR] There are no tickets to search for.\n");
            return null;
        }
        
        Node current = head;
        while (current != null && current.ticket.getId() != id) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR] No such ticket exists with the ID [" + id + "]. \n");
            return null;
        }

        System.out.println("[INFO] Ticket " + current.ticket.getId() + " found.");
        System.out.println(current.ticket.toString());
        return current.ticket;
    }
}
