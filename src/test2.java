public class test2 {
        public static void main(String[] args) {
            int [] row1 = {0,0,0,0,1,0,0,1,0,1,0,0};
            int [] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            int [] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


            System.out.println("\t***********\n\t*  STAGE  *\n\t***********");
            System.out.print("\t");
            print(row1);
            System.out.print("\n  ");
            print(row2);
            System.out.println();
            print(row3);
    }

    public static void print(int[] row) {
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
    }
}
