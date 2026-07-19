import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel() {

        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        // Default Rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    // Display Rooms
    public void displayRooms() {

        System.out.println("\n------------ Rooms ------------");

        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    // Search Room
    public Room searchRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        return null;
    }

    // Book Room
    public void bookRoom(int roomNumber, String name, String phone) {

        Room room = searchRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Room is already booked.");
            return;
        }

        Customer customer = new Customer(name, phone);

        Booking booking = new Booking(room, customer);

        bookings.add(booking);

        room.setAvailable(false);

        System.out.println("Room booked successfully.");
    }

    // Cancel Booking
    public void cancelBooking(int roomNumber) {

        for (int i = 0; i < bookings.size(); i++) {

            Booking booking = bookings.get(i);

            if (booking.getRoom().getRoomNumber() == roomNumber) {

                booking.getRoom().setAvailable(true);

                bookings.remove(i);

                System.out.println("Booking cancelled successfully.");

                return;
            }
        }

        System.out.println("No booking found.");
    }

    // View Bookings
    public void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\n--------- Bookings ---------");

        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    // Getters
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public void setBookings(ArrayList<Booking> bookings) {
    this.bookings = bookings;
}
}