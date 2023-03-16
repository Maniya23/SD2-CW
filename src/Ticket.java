public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;


    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters for ticket information
    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public void print() {

        // Printing the ticket information
        System.out.println("Name : " + person.getName());
        System.out.println("Surname : " +person.getSurname());
        System.out.println("Email : " + person.getEmail());
        System.out.println("Seat row : "+ row);
        System.out.println("Seat No. : "+ seat);
        System.out.println("Price : "+ price);
    }

}
