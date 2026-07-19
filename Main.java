import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        // Load previous bookings
        hotel.setBookings(FileHandler.loadBookings(hotel.getRooms()));

        int choice;

        do {

            System.out.println("\n========== HOTEL RESERVATION SYSTEM ==========");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Save Bookings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hotel.displayRooms();
                    break;

                case 2:

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    hotel.bookRoom(roomNo, name, phone);
                    break;

                case 3:

                    System.out.print("Enter Room Number: ");
                    roomNo = sc.nextInt();

                    hotel.cancelBooking(roomNo);
                    break;

                case 4:

                    hotel.viewBookings();
                    break;

                case 5:

                    FileHandler.saveBookings(hotel.getBookings());
                    break;

                case 6:

                    FileHandler.saveBookings(hotel.getBookings());
                    System.out.println("Thank you for using Hotel Reservation System.");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}