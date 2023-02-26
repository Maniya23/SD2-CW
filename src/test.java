public class test {
    public static void main(String[] args) {
        int [] row1 = {0,0,0,0,0,0,0,0,0,0,0,0};
        int [] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0};

        System.out.print("Seats available in row 1 : ");
        print_seats_available(row1);

        System.out.print("\nSeats available in row 2 : ");
        print_seats_available(row2);

        System.out.print("\nSeats available in row 3 : ");
        print_seats_available(row3);

        System.out.println("\n\n");
    }

    public static void print_seats_available(int []row) {
        int count = 1;

        for (int element:row) {
            if (element == 0) {
                System.out.print(count);
                if (count != row.length)
                    System.out.print(", ");
                else
                    System.out.println(".");
            }
            count+=1;
        }
    }
}