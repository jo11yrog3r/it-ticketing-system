public class Main {
    public static void main(String[] args) {
        TicketQueue queue = new TicketQueue();

        // Default filler tickets
        queue.createTicket("Bob", "Tech. Kai", 3, "20-03-2025 15:59");
        queue.createTicket("Kelly", "Tech. Wilson", 4, "20-03-2025 16:05");
        queue.createTicket("Mike", "Tech. Prince", 1, "20-03-2025 13:31");

        queue.listTickets();
    }
}
