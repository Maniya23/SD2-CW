import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;


public class Theatre {
    public static void main(String[] args) {

        int [] row1 = {0,0,0,0,0,0,0,0,0,0,0,0};
        int [] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean repeat = true;
        int userOption;
        String saveAndExit;


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
                    0) Quit
                -------------------------------------------------
                """;

        System.out.println("Welcome to the New Theatre\n");

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
                buy_ticket(row1, row2, row3, scanner);
            else if (userOption == 2)
                print_seating_area(row1, row2, row3);
            else if (userOption == 3)
                cancel_ticket(row1, row2, row3, scanner);
            else if (userOption == 4)
                show_ticket(row1, row2, row3);
            else if (userOption == 5)
                save(row1, row2, row3);
            else if (userOption == 6)
                load(row1, row2, row3);
            else if (userOption == 0) {
                System.out.print("Do you want to save the data before exiting the program (y/n) : ");
                saveAndExit = scanner.next();
                saveAndExit.toLowerCase();

                if ( saveAndExit=="y" || saveAndExit=="yes" )
                    save(row1,row2,row3);

                System.out.println("Thank you for using New Theatre");
                repeat=false;

            } else
                System.out.println("Invalid - Enter a valid integer");
        } while (repeat==true);

    }

    public static void buy_ticket(int[] row1, int[] row2, int[] row3,Scanner scanner) {
        int rowNo = 0;
        int seatNo = 0;

        do {

            try {
                System.out.print("Please enter the row number : ");
                rowNo = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid - Enter only integers");
                scanner.nextLine();
            }
        }while (rowNo > 3 || rowNo < 1) ;
        

        if (rowNo==1) {
            while (true) {
                do {
                    try {
                        System.out.print("Please enter the seat number : ");
                        seatNo = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid - Enter only integers");
                        scanner.nextLine();
                    }
                } while (seatNo > 12 || seatNo < 1);

                seatNo = seatNo - 1;
                if (row1[seatNo] == 0) {
                    row1[seatNo] = 1;
                    break;
                }
                else {
                    System.out.println("Seat is already occupied\n");
                }
            }

        } else if (rowNo==2) {
            while (true) {
                do {
                    try {
                        System.out.print("Please enter the seat number : ");
                        seatNo = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid - Enter only integers");
                        scanner.nextLine();
                    }
                } while (seatNo > 16 || seatNo < 1);

                seatNo = seatNo - 1;
                if (row2[seatNo] == 0) {
                    row2[seatNo] = 1;
                    break;
                }else
                    System.out.println("Seat is already occupied\n");
            }
        } else if (rowNo==3) {
            while (true) {
                do {
                    try {
                        System.out.print("Please enter the seat number : ");
                        seatNo = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid - Enter only integers");
                        scanner.nextLine();
                    }
                } while (seatNo > 20 || seatNo < 1);

                seatNo = seatNo - 1;
                if (row3[seatNo] == 0) {
                    row3[seatNo] = 1;
                    break;
                } else
                    System.out.println("Seat is already occupied\n");
            }
        }
        System.out.println("\n");
    }

    public static void print_seating_area(int[] row1, int[] row2, int[] row3) {
        System.out.println("\t***********\n\t*  STAGE  *\n\t***********");
        System.out.print("\t");
        print_seat_rows(row1);
        System.out.print("\n  ");
        print_seat_rows(row2);
        System.out.println();
        print_seat_rows(row3);

        System.out.println("\n\n");
    }

    public static void print_seat_rows(int[] row) {
        int count=1;
        for (int element:row) {

            if (count==(row.length)/2) {
                if (element == 0)
                    System.out.print("O");
                else
                    System.out.print("X");

                System.out.print(" ");
            }
            else {
                if (element == 0)
                    System.out.print("O");
                else
                    System.out.print("X");
            }

            count+=1;
        }
        System.out.println("");
    }

    public static void cancel_ticket(int[] row1, int[] row2, int[] row3, Scanner scanner) {

        int rowNo = 0;
        int seatNo = 0;

        do {
            try {
                System.out.print("Enter the row number (from 1 to 3) : ");
                rowNo = scanner.nextInt();
            } catch(Exception e) {
                System.out.println("Invalid - Enter only integers");
                scanner.next();
            }
        } while (rowNo > 3 || rowNo < 1);

        if (rowNo==1) {
            do {
                try {
                    System.out.print("Enter the seat number : ");
                    seatNo = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid - Enter only integers");
                    scanner.nextLine();
                }
            } while (seatNo<1 || seatNo>12);

            seatNo-=1;
            if (row1[seatNo]==1) {
                row1[seatNo] = 0;
                System.out.println("Row "+rowNo+" seat "+(seatNo+1)+" is now available");
            }
            else
                System.out.println("This seat is already available");
        } else if (rowNo==2) {
            do {
                System.out.print("Enter the seat number : ");
                seatNo = scanner.nextInt();
            } while (seatNo<1 || seatNo>16);

            seatNo-=1;
            if (row2[seatNo]==1) {
                row2[seatNo] = 0;
                System.out.println("Row "+rowNo+" seat "+(seatNo+1)+" is now available");
            }
            else
                System.out.println("This seat is already available");
        } else{
            do {
                System.out.print("Enter the seat number : ");
                seatNo = scanner.nextInt();
            } while (seatNo<1 || seatNo>20);

            seatNo-=1;
            if (row3[seatNo]==1) {
                row3[seatNo] = 0;
                System.out.println("Row "+rowNo+" seat "+(seatNo+1)+" is now available");
            }
            else
                System.out.println("This seat is already available");
        }

        System.out.println("\n\n");

    }

    public static void show_ticket(int[] row1, int[] row2, int[] row3) {

        System.out.print("Seats available in row 1 : ");
        print_seats_available(row1);

        System.out.print("\nSeats available in row 2 : ");
        print_seats_available(row2);

        System.out.print("\nSeats available in row 3 : ");
        print_seats_available(row3);

        System.out.println("\n\n");
    }

    public static void print_seats_available(int []row) {
        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                count++;
                if (count == 1) {
                    System.out.print(i+1);
                } else {
                    System.out.print("," + (i+1));
                }
            }
        }
        System.out.print(".");
    }

    public static void save(int[] row1, int[] row2, int[] row3) {
        //Write to the file
        try {
            FileWriter seatFile = new FileWriter("SeatInfoTest.txt");
            for (int i = 0; i < row1.length; i++) {
                seatFile.write(row1[i] +" ");
            }
            for (int i = 0; i < row2.length; i++) {
                seatFile.write(row2[i] +" ");
            }
            for (int i = 0; i < row3.length; i++) {
                seatFile.write(row3[i] +" ");
            }

            seatFile.close();
            System.out.println("Seat information was successfully written to file");
        } catch (IOException e) {
            System.out.println("An error was occurred while writing to file");
        }
    }

    public static void load(int[] row1, int[] row2, int[] row3) {
        int [] row = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


        //Read from the file
        try {
            File file = new File("SeatInfoTest.txt");
            Scanner file_reader = new Scanner(file);
            while (file_reader.hasNextLine()) {
                for (int i = 0; i < row.length; i++) {
                    if (file_reader.hasNext()) {
                        int digit = Integer.parseInt(file_reader.next());
                        row[i] = digit;
                    }

                }
                break;

            }
            file_reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading a file.");
            e.printStackTrace();
        }

        int count=0;
        for (int i = 0; i < row1.length; i++) {
            row1[i]=row[count];
            count+=1;
        }

        for (int i = 0; i < row2.length; i++) {
            row2[i]=row[count];
            count+=1;
        }

        for (int i = 0; i < row3.length; i++) {
            row3[i]=row[count];
            count+=1;
        }
    }

}
