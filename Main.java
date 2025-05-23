import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketQueue queue = new TicketQueue();
        Scanner scanner = new Scanner(System.in);
        boolean remain = true;
        boolean valid = false;
        boolean searchLoop = true;
        int intInput;
        String txtInput = "";
        // char newLine = 10;

        // Default filler tickets
        queue.createTicket("Bob", "Tech. Kai", 3, "20-03-2025 15:59"); // id 1
        queue.createTicket("Kelly", "Tech. Wilson", 4, "20-03-2025 16:05"); // id 2
        queue.createTicket("Mike", "Tech. Prince", 1, "20-03-2025 13:31"); // id 3

        // [worked] queue.deleteTicket(2);
        // [worked] queue.listTickets();

        while (remain) {
            menuSplash(); // ASCII title
            System.out.print("Select the number of your desired action:\n[1] Create a ticket\n[2] Search for a ticket\n[3] Edit a ticket\n[4] Delete a ticket\n[5] View all tickets\n>>> ");
            intInput = scanner.nextInt();
            scanner.nextLine();

            // Validate
            while (!valid) {
            if (menuValidation(intInput) == true) {
                valid = true;
            } else {
                System.out.print("[ERROR] Invalid value. Enter a value between 1-5.\n>>> ");
                intInput = scanner.nextInt();
                scanner.nextLine();
            }
           }

        switch (intInput) {
            case 1: // Create ticket
                String creator;
                String owner;
                int priority;
                String timestamp;
                boolean createValid = false;

                System.out.print("Enter ticket creator name:\n>>> ");
                creator = scanner.nextLine();
                System.out.print("Enter technician name:\n>>> ");
                owner = scanner.nextLine();
                System.out.print("Enter priority (1-5):\n>>> ");
                priority = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter time & date of submission (dd/mm/yyyy [time]):\n>>> ");
                timestamp = scanner.nextLine();

                queue.createTicket(creator, owner, priority, timestamp);
                break;
            case 2: // Search for ticket
                while (searchLoop) {
                    System.out.print("Search by [I]D or [C]ancel\n>>> ");
                    txtInput = scanner.nextLine();

                    if (!txtInput.toUpperCase().equals("C") && !txtInput.toUpperCase().equals("I")) {
                        System.out.println("[ERROR] Invalid input. Must be I or C.");
                        searchLoop = true;
                    } else {
                        searchLoop = false;
                    }
                }

                searchLoop = true;

                if (txtInput.toUpperCase().equals("C")) {
                    break;
                } else if (txtInput.toUpperCase().equals("I")) {
                    System.out.print("Enter your ticket ID:\n>>> ");
                    intInput = scanner.nextInt();
                    scanner.nextLine();

                    queue.searchTicket(intInput);
                }
                break;
            case 3: // Edit a ticket
                while (searchLoop) {
                    System.out.print("Search by [I]D or [C]ancel\n>>> ");
                    txtInput = scanner.nextLine();

                    if (!txtInput.toUpperCase().equals("C") && !txtInput.toUpperCase().equals("I")) {
                        System.out.println("[ERROR] Invalid input. Must be I or C.");
                        searchLoop = true;
                    } else {
                        searchLoop = false;
                    }
                }

                searchLoop = true;

                if (txtInput.toUpperCase().equals("C")) {
                    break;
                } else if (txtInput.toUpperCase().equals("I")) {
                    System.out.print("Enter your ticket ID:\n>>> ");
                    intInput = scanner.nextInt();
                    scanner.nextLine();

                    queue.searchTicket(intInput);
                }

                queue.updateTicket(intInput);
                break;
            case 4: // Delete a ticket
                System.out.print("Enter the ticket ID to delete:\n>>> ");
                intInput = scanner.nextInt();
                scanner.nextLine();

                queue.deleteTicket(intInput);
                break;
            case 5: // List all tickets
                queue.listTickets();
                break;
        }
    }
}

    private static void menuSplash() {
        System.out.println("  _______      __        __  _                _____            __               ");
        System.out.println(" /_  __(______/ /_____  / /_(_____  ____ _   / ___/__  _______/ /____  ____ ___ ");
        System.out.println("  / / / / ___/ //_/ _ \\/ __/ / __ \\/ __ `/   \\__ \\/ / / / ___/ __/ _ \\/ __ `__ \\");
        System.out.println(" / / / / /__/ ,< /  __/ /_/ / / / / /_/ /   ___/ / /_/ (__  / /_/  __/ / / / / /");
        System.out.println("/_/ /_/\\___/_/|_|\\___/\\__/_/_/ /_/\\__, /   /____/\\__, /____/\\__/\\___/_/ /_/ /_/ ");
        System.out.println("                                 /____/         /____/                          ");
        System.out.println("________________________________________________________________________________\n");
    }

    private static boolean menuValidation(int input) {
        if (input >= 1 && input <= 5) {
            return true;
        } else {
            return false;
        }
    }
}
