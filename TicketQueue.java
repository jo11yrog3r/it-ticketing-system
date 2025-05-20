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
}
