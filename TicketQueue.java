import java.util.Scanner;

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
            System.out.println("[INFO] Successfully created ticket with ID " + node.ticket.getId() + ".");
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
        System.out.println("[INFO] Successfully created ticket with ID " + node.ticket.getId() + ".");
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
        Scanner scanner = new Scanner(System.in);
        String txtInput = "";

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

        System.out.println("[INFO] Found ticket with ID " + current.ticket.getId() + "...\n");
        System.out.println(current.ticket.toString());

        while (!txtInput.toUpperCase().equals("Y") && !txtInput.toUpperCase().equals("N")) {
            System.out.print("Are you sure you want to delete this ticket? Y/n\n>>> ");
            txtInput = scanner.nextLine();

            if (txtInput.toUpperCase().equals("Y")) {
                System.out.println("[INFO] Ticket with ID " + current.ticket.getId() + " successfully deleted.");
                previous.next = current.next; // Removes the specific ticket
            } else if (txtInput.toUpperCase().equals("N")) {
                return;
            } else {
                System.out.println("[ERROR] Invalid input. Must be Yy/Nn.");
            }
        }
    }

    public Node searchTicket(int id) {
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

        System.out.println("[INFO] Ticket " + current.ticket.getId() + " found.\n");
        System.out.println(current.ticket.toString());
        return current;
    }

    public void updateTicket(int id) {
        searchTicket(id);
        Scanner scanner = new Scanner(System.in);
        boolean looping = true;
        boolean incorrect = true;
        String txtInput = "";
        int intInput;

        Node current = searchTicket(id);
        while (looping) {
            incorrect = true; // Refreshing so the inner while loop can iterate properly
            System.out.print(">>> Editable fields: [O]wner, [P]riority, [C]ancel\n>>> "); // User selects what value to edit
            txtInput = scanner.nextLine();

            if (txtInput.toUpperCase().equals("O")) { // Normalize user input and check it
                System.out.print(">>> " + current.ticket.getOwner() + " -> ");
                txtInput = scanner.nextLine();
                current.ticket.setOwner(txtInput);
            } else if (txtInput.toUpperCase().equals("P")) {
                System.out.print(">>> " + current.ticket.getPriority() + " -> ");
                intInput = scanner.nextInt();
                scanner.nextLine();
                current.ticket.setPriority(intInput);
            } else {
                System.out.println(">>> Edit cancelled.");
                return;
            }

            while (incorrect) {
                System.out.print(">>> Edit another value? Y/n\n>>> ");
                txtInput = scanner.nextLine();
                if (txtInput.toUpperCase().equals("Y")) {
                    incorrect = false; // Must be set to false so it won't iterate the incorrect loop
                } else if (txtInput.toUpperCase().equals("N")) {
                    incorrect = false;
                    looping = false;
                    break;
                } else {
                    System.out.println("[ERROR] Invalid response, must be Yy/Nn.\n");
                    incorrect = true;
                }
            }
        }
        System.out.println("[INFO] Ticket " + current.ticket.getId() + " edited.\n");
        System.out.println(current.ticket.toString());
    }
}
