import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int [] row = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        try {
            FileWriter myWriter = new FileWriter("Seats.txt");
            myWriter.write(Arrays.toString(row));
            myWriter.close();
            System.out.println("Successfully wrote to file");

        } catch (IOException e) {
            System.out.println("An error has occurred while trying to write file");
        }
    }
}