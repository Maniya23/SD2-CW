import java.io.*;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Theatre {
    public static void main(String[] args) {

        int [] row1 = {0,0,0,0,0,0,0,0,0,0,0,0};
        int [] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean repeat = true;


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
            System.out.print("PLease enter your option here : ");
            int userOption = scanner.nextInt();

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
            else if (userOption == 0) {
                System.out.println("Thank you for using New Theatre");
                repeat = false;
            }
        } while (repeat==true);

    }

    public static void buy_ticket(int[] row1, int[] row2, int[] row3,Scanner scanner) {
        int rowNo;
        int seatNo;

        do {
            System.out.print("Please enter the row number : ");
            rowNo = scanner.nextInt();
        } while (rowNo>3 || rowNo<1);

        if (rowNo==1) {
            while (true) {
                do {
                    System.out.print("Please enter the seat number : ");
                    seatNo = scanner.nextInt();
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
                    System.out.print("Please enter the seat number : ");
                    seatNo = scanner.nextInt();
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
                    System.out.print("Please enter the seat number : ");
                    seatNo = scanner.nextInt();
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
        System.out.println("\n\n");
    }

    public static void cancel_ticket(int[] row1, int[] row2, int[] row3, Scanner scanner) {

        int rowNo;
        int seatNo;

        do {
            System.out.print("Enter the row number (from 1 to 3) : ");
            rowNo = scanner.nextInt();
        } while (rowNo > 3 || rowNo < 1);

        if (rowNo==1) {
            do {
                System.out.print("Enter the seat number : ");
                seatNo = scanner.nextInt();
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

        int count;

        System.out.print("Seats available in row 1 : ");
        count=1;
        for (int element:row1) {
            if (element==0)
                System.out.print(count+", ");

            count+=1;
        }

        count=1;
        System.out.print("\nSeats available in row 1 : ");
        for (int element:row2) {
            if (element==0)
                System.out.print(count+", ");

            count+=1;
        }

        count=1;
        System.out.print("\nSeats available in row 3 : ");
        for (int element:row3) {
            if (element==0)
                System.out.print(count+", ");

            count+=1;
        }

        System.out.println("\n\n");
    }

    public static void save(int[] row1, int[] row2, int[] row3) {
    }
}
