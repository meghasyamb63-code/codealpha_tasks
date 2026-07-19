import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "bookings.txt";

    // Save Bookings
    public static void saveBookings(ArrayList<Booking> bookings) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Booking booking : bookings) {

                writer.write(
                        booking.getRoom().getRoomNumber() + "," +
                        booking.getRoom().getCategory() + "," +
                        booking.getCustomer().getName() + "," +
                        booking.getCustomer().getPhone());

                writer.newLine();
            }

            System.out.println("Bookings saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving bookings.");
        }
    }

    // Load Bookings
    public static ArrayList<Booking> loadBookings(ArrayList<Room> rooms) {

        ArrayList<Booking> bookings = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return bookings;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int roomNumber = Integer.parseInt(data[0]);
                String customerName = data[2];
                String phone = data[3];

                for (Room room : rooms) {

                    if (room.getRoomNumber() == roomNumber) {

                        room.setAvailable(false);

                        Customer customer = new Customer(customerName, phone);

                        bookings.add(new Booking(room, customer));

                        break;
                    }
                }
            }

        } catch (IOException e) {

            System.out.println("Error loading bookings.");
        }

        return bookings;
    }
}