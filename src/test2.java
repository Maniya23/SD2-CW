public class test2 {
    public static void main(String[] args) {
        int [] row1 = {0,0,0,0,0,0,0,0,0,0,0,0};
        int [] row2 = {1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1};
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
}