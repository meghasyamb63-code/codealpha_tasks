public class Booking {

    private Room room;
    private Customer customer;

    public Booking(Room room, Customer customer) {
        this.room = room;
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return room.toString() + " | Customer: " + customer.toString();
    }
}