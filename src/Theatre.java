import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
* 4COSC010C - Software Development II
* A program created for 'New Theatre' to manage and control the seats that have been sold and the seats that are still available for one of their theatre sessions.
* Name : H.M.R.D. Fonseka
* IIT ID : 20210776
* UoW ID : w1953863
*/

public class Theatre {
    public static void main(String[] args) {

        // Variable Declaration
        int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ArrayList<Ticket> tickets = new ArrayList<>();
        boolean repeat = true;
        int userOption;
        String saveAndExit;


        //Making Scanner object
        Scanner scanner = new Scanner(System.in);

        String mainMenu = """
                -------------------------------------------------
                Please select an option:
                1) Buy a ticket
                2) Print seating area
                3) Cancel ticket
                4) List available seats
                5) Save to file
                6) Load from file
                7) Print ticket information and total price
                8) Sort tickets by price
                \t0) Quit
                -------------------------------------------------
                """;

        System.out.println("Welcome to the New Theatre\n");

        //Iterating main menu
        do {
            System.out.println(mainMenu);
            try {
                System.out.print("Please enter your option here : ");
                userOption = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid - Enter only integers");
                scanner.nextLine();
                continue;
            }

            if (userOption == 1)
                buy_ticket(row1, row2, row3, scanner, tickets);
            else if (userOption == 2)
                print_seating_area(row1, row2, row3);
            else if (userOption == 3)
                cancel_ticket(row1, row2, row3, scanner, tickets);
            else if (userOption == 4)
                show_ticket(row1, row2, row3);
            else if (userOption == 5)
                save(row1, row2, row3);
            else if (userOption == 6)
                load(row1, row2, row3);
            else if (userOption == 7)
                show_tickets_info(tickets);
            else if (userOption == 8)
                sort_tickets(tickets);

            else if (userOption == 0) {
                System.out.print("Do you want to save the data before exiting the program (y/n) : ");
                saveAndExit = scanner.next();
                saveAndExit.toLowerCase();

                // Asking to save the file before exit
                if (saveAndExit == "y" || saveAndExit == "yes")
                    save(row1, row2, row3);

                System.out.println("Thank you for using New Theatre");
                repeat = false;

            } else
                System.out.println("Invalid - Enter a valid input");
        } while (repeat == true);

    }

    // Method added to buy tickets when user selects 1 from the main menu.
    private static void buy_ticket(int[] row1, int[] row2, int[] row3, Scanner scanner, ArrayList<Ticket> tickets) {
        int rowNo = 0;
        int seatNo = 0;

        // Taking row number as input
        do {

            try {
                System.out.print("Please enter the row number : ");
                rowNo = scanner.nextInt();

                if (rowNo > 3 || rowNo < 1)
                    System.out.println("Invalid row number");

            } catch (Exception e) {
                System.out.println("Invalid - Enter only integers");
                scanner.nextLine();
            }
        } while (rowNo > 3 || rowNo < 1);


        // If row is 1
        if (rowNo == 1) {
            //Taking seat no as input
            while (true) {
                do {
                    try {
                        System.out.print("Please enter the seat number : ");
                        seatNo = scanner.nextInt();

                        if (seatNo > 12 || seatNo < 1)
                            System.out.println("Invalid seat number");

                    } catch (Exception e) {
                        System.out.println("Invalid - Enter only integers");
                        scanner.nextLine();
                    }
                } while (seatNo > 12 || seatNo < 1);

                seatNo = seatNo - 1;
                if (row1[seatNo] == 0) {
                    row1[seatNo] = 1;

                    double price = 25;
                    ticketing_person(scanner, rowNo, seatNo+1, price, tickets); // Creating a new person and a ticket
                    System.out.println("Seat booked Successfully");
                    break;
                } else {
                    System.out.println("Seat is already occupied\n");
                }
            }


        } else if (rowNo == 2) { // If row is 2
            // Taking seat no as input
            while (true) {
                do {
                    try {
                        System.out.print("Please enter the seat number : ");
                        seatNo = scanner.nextInt();

                        if (seatNo > 16 || seatNo < 1)
                            System.out.println("Invalid seat number");

                    } catch (Exception e) {
                        System.out.println("Invalid - Enter only integers");
                        scanner.nextLine();
                    }
                } while (seatNo > 16 || seatNo < 1);

                seatNo = seatNo - 1;
                if (row2[seatNo] == 0) {
                    row2[seatNo] = 1;

                    double price = 20;
                    ticketing_person(scanner, rowNo, seatNo+1, price, tickets); // Creating a new person and a ticket
                    System.out.println("Seat booked Successfully");
                    break;

                } else
                    System.out.println("Seat is already occupied\n");
            }
        } else if (rowNo == 3) { // If row is 3
            //Taking seat no as input
            while (true) {
                do {
                    try {
                        System.out.print("Please enter the seat number : ");
                        seatNo = scanner.nextInt();

                        if (seatNo > 20 || seatNo < 1)
                            System.out.println("Invalid seat number");

                    } catch (Exception e) {
                        System.out.println("Invalid - Enter only integers");
                        scanner.nextLine();
                    }
                } while (seatNo > 20 || seatNo < 1);

                seatNo = seatNo - 1;
                if (row3[seatNo] == 0) {
                    row3[seatNo] = 1;

                    double price = 10;
                    ticketing_person(scanner, rowNo, seatNo+1, price, tickets); // Creating a new person and a ticket
                    System.out.println("Seat booked Successfully");
                    break;

                } else
                    System.out.println("Seat is already occupied\n");
            }
        }
        System.out.println("\n");
    }

    // Method added to create a ticket and a person when buying a ticket.
    private static void ticketing_person(Scanner scanner, int rowNo, int seatNo, double price, ArrayList<Ticket> tickets) {
        // Taking person details
        System.out.print("Enter your First Name : ");
        String name = scanner.next();
        System.out.print("Enter your Surname : ");
        String sName = scanner.next();
        System.out.println("Enter your Email : ");
        String email = scanner.next();

        // Creating a new person
        Person person = new Person(name, sName, email);

        // Creating a new ticket
        Ticket ticket = new Ticket(rowNo, seatNo, price, person);

        // Adding tickets
        tickets.add(ticket);
    }

    // Method added to show the seats that have been sold and the seats that are still available. This function is called when user selects 2 on the main menu
    private static void print_seating_area(int[] row1, int[] row2, int[] row3) {
        // Printing stage
        System.out.println("\t***********\n\t*  STAGE  *\n\t***********");
        System.out.print("\t");
        print_seat_rows(row1);
        System.out.print("  ");
        print_seat_rows(row2);
        print_seat_rows(row3);

        System.out.println("\n");
    }

    // Method added to print each row from the print_seating_area function
    private static void print_seat_rows(int[] row) {

        //　Printing the seating area of the theatre
        int count = 1;
        for (int element : row) {

            if (count == (row.length) / 2) {
                if (element == 0)
                    System.out.print("O");
                else
                    System.out.print("X");

                System.out.print(" ");
            } else {
                if (element == 0)
                    System.out.print("O");
                else
                    System.out.print("X");
            }

            count += 1;
        }
        System.out.println("");
    }

    // Method added to cancel booked tickets. This method is called when user selects 3 in the main menu.
    private static void cancel_ticket(int[] row1, int[] row2, int[] row3, Scanner scanner, ArrayList<Ticket> tickets) {

        int rowNo = 0;
        int seatNo = 0;

        // Asking user for the row to change
        do {
            try {
                System.out.print("Enter the row number (from 1 to 3) : ");
                rowNo = scanner.nextInt();

                if (rowNo > 3 || rowNo < 1)
                    System.out.println("Invalid row number");

            } catch (Exception e) {
                System.out.println("Invalid - Enter only integers");
                scanner.next();
            }
        } while (rowNo > 3 || rowNo < 1);

        if (rowNo == 1) { // If row no is 1

            // Asking user for the seat to cancel
            do {
                try {
                    System.out.print("Enter the seat number : ");
                    seatNo = scanner.nextInt();

                    if (seatNo < 1 || seatNo > 12)
                        System.out.println("Invalid seat number");

                } catch (Exception e) {
                    System.out.println("Invalid - Enter only integers");
                    scanner.nextLine();
                }
            } while (seatNo < 1 || seatNo > 12);

            seatNo -= 1;
            if (row1[seatNo] == 1) {
                row1[seatNo] = 0;


                System.out.println("Row " + rowNo + " seat " + (seatNo + 1) + " is now available");
            } else
                System.out.println("This seat is already available");

        } else if (rowNo == 2) { // If row no is 2

            // Asking user for the seat to cancel
            do {
                try {
                    System.out.print("Enter the seat number : ");
                    seatNo = scanner.nextInt();

                    if (seatNo < 1 || seatNo > 16)
                        System.out.println("Invalid seat number");

                } catch (Exception e) {
                    System.out.println("Invalid - Enter only integers");
                    scanner.nextLine();
                }
            } while (seatNo < 1 || seatNo > 16);

            seatNo -= 1;
            if (row2[seatNo] == 1) {
                row2[seatNo] = 0;

                System.out.println("Row " + rowNo + " seat " + (seatNo + 1) + " is now available");
            } else
                System.out.println("This seat is already available");

        } else { // if row no is 3

            // Asking user for the seat to cancel
            do {
                try {
                    System.out.print("Enter the seat number : ");
                    seatNo = scanner.nextInt();

                    if (seatNo < 1 || seatNo > 20)
                        System.out.println("Invalid seat number");

                } catch (Exception e) {
                    System.out.println("Invalid - Enter only integers");
                    scanner.nextLine();
                }
            } while (seatNo < 1 || seatNo > 20);

            seatNo -= 1;
            if (row3[seatNo] == 1) {
                row3[seatNo] = 0;

                System.out.println("Row " + rowNo + " seat " + (seatNo + 1) + " is now available");
            } else
                System.out.println("This seat is already available");
        }

        // Removing the ticket object from the tickets arraylist.
        seatNo+=1;
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getRow() == rowNo && tickets.get(i).getSeat() == seatNo) {
                tickets.remove(i);
            }
        }
        System.out.println("\n");

    }

    // Method added to show seats available in each row. This method is called when user selects 4 in the main menu.
    private static void show_ticket(int[] row1, int[] row2, int[] row3) {

        // Printing the available seats
        System.out.print("Seats available in row 1 : ");
        print_seats_available(row1);

        System.out.print("\nSeats available in row 2 : ");
        print_seats_available(row2);

        System.out.print("\nSeats available in row 3 : ");
        print_seats_available(row3);

        System.out.println("\n\n");
    }

    // method added to print the rows that are given from the function show_ticket.
    private static void print_seats_available(int[] row) {

        // Printing available seats
        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                count++;
                if (count == 1) {
                    System.out.print(i + 1);
                } else {
                    System.out.print("," + (i + 1));
                }
            }
        }
        System.out.print(".");
    }

    // Method added to save the row information to a file. This method is called when user selects 5 in the main menu.
    private static void save(int[] row1, int[] row2, int[] row3) {
        // Write the row and seat info to the file
        try {
            FileWriter seatFile = new FileWriter("SeatInfo.txt");
            for (int i = 0; i < row1.length; i++) {
                seatFile.write(row1[i] + " ");
            }
            for (int i = 0; i < row2.length; i++) {
                seatFile.write(row2[i] + " ");
            }
            for (int i = 0; i < row3.length; i++) {
                seatFile.write(row3[i] + " ");
            }

            seatFile.close();
            System.out.println("Seat information was successfully written to file");
        } catch (IOException e) {
            System.out.println("An error was occurred while writing to file");
        }
    }

    // Method added to load the row information from a saved file. This method is called when user selects 6 in the main menu.
    private static void load(int[] row1, int[] row2, int[] row3) {
        int[] row = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


        // Read information form the saved file
        try {
            File file = new File("SeatInfo.txt");
            Scanner file_reader = new Scanner(file);
            while (file_reader.hasNextLine()) {
                for (int i = 0; i < row.length; i++) {
                    if (file_reader.hasNext()) {
                        int digit = Integer.parseInt(file_reader.next()); // Saving the information to a large array
                        row[i] = digit;
                    }

                }
                break;

            }
            file_reader.close();
            System.out.println("File has been loaded successfully.......");
        } catch (IOException e) {
            System.out.println("Error while reading a file.");
            e.printStackTrace();
        }

        // Separating the larger array's information in to the 3 rows
        int count = 0;
        for (int i = 0; i < row1.length; i++) {
            row1[i] = row[count];
            count += 1;
        }

        for (int i = 0; i < row2.length; i++) {
            row2[i] = row[count];
            count += 1;
        }

        for (int i = 0; i < row3.length; i++) {
            row3[i] = row[count];
            count += 1;
        }
    }

    // Method added to show the tickets and the information that was created relating to the booked tickets. This method is called when user selects 7 in the main menu.
    private static void show_tickets_info(ArrayList<Ticket> tickets) {
        int count = 1;
        double totalTicketPrice = 0;


        // Printing the tickets
        for (Ticket e : tickets) {
            System.out.println("Ticket " + count);
            e.print();
            System.out.println("--------------------------------------------");
            totalTicketPrice = totalTicketPrice + e.getPrice();
            count++;
        }

        System.out.println("Total price of the tickets : " + totalTicketPrice); // Total price of all the tickets
    }

    // Method added to sort the tickets in the ascending order according to the price given. This method is called when user selects 8 in the main menu.
    private static void sort_tickets(ArrayList<Ticket> tickets) {

        // Creating a new array list of type Tickets
        ArrayList<Ticket> sortTickets = new ArrayList<>();

        // Adding the elements in tickets to new array
        for (int i = 0; i < tickets.size(); i++) {
            sortTickets.add(tickets.get(i));
        }
        SelectionSort(sortTickets); // function to sort the new array of tickets
    }

    // Method added to sort the tickets using the Selection sort method.
    private static void SelectionSort(ArrayList<Ticket> sortTickets) {  // Selection sort method referred from Lecture 8 - Sorting and Search Algorithms
        int count = 1;
        int minIndex;
        Ticket temp;
        int arrayLen = sortTickets.size();

        // Sorting the tickets
        for (int start = 0; start < arrayLen - 1; start++) {
            minIndex = start;
            for (int i = start + 1; i <= arrayLen - 1; i++) {
                if (sortTickets.get(i).getPrice() < sortTickets.get(minIndex).getPrice())
                    minIndex = i;
                Collections.swap(sortTickets, start, minIndex); // Using Swap method in the Collections class in java referred from ("JavaTpoint") website.
            }
        }

        // Printing the sorted tickets
        for (Ticket e:sortTickets) {
            System.out.println("Ticket : "+count);
            e.print();
            System.out.println("-----------------------------------------------");
            count++;
        }
    }
}

/*code references
* Lecture notes week 8. Sorting and search algorithms. Accessed on (16/03/2023).
*
* JavaTpoint. Java Collections swap() Method. https://www.javatpoint.com/java-collections-swap-method. Accessed on [18/03/2023].
*
* */
