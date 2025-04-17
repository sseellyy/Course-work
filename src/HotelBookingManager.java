import java.io.*;
import java.util.*;
import java.util.regex.*;

public class HotelBookingManager {
    private static final String FILE_NAME = "bookings.csv";
    private static List<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadBookings();
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\nHotel Booking Manager");
            System.out.println("1. Create Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": createBooking(); break;
                case "2": viewBookings(); break;
                case "3": updateBooking(); break;
                case "4": deleteBooking(); break;
                case "5": generateReport(); break;
                case "6": return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createBooking() {
        System.out.print("Enter guest name: ");
        String name = scanner.nextLine().trim();

        //Checking if email is valid
        String email;
        do {
            System.out.print("Enter guest email: ");
            email = scanner.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please try again.");
            }
        } while (!isValidEmail(email));

        String room;
        do {
            System.out.print("Enter room type (Single/Double/Suite): ");
            room = scanner.nextLine().trim();
            if (!isValidRoomType(room)) {
                System.out.println("Invalid room type. Please enter Single, Double, or Suite.");
            }
        } while (!isValidRoomType(room));

        room = capitalizeRoomType(room);

        //getting id
        int id = bookings.isEmpty() ? 1 : bookings.get(bookings.size() - 1).getId() + 1;

        bookings.add(new Booking(id, name, email, room));
        saveBookings();
        System.out.println("Booking created successfully.");
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        bookings.forEach(System.out::println);
    }

    private static void updateBooking() {
        System.out.print("Enter booking ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Booking booking = findBookingById(id);
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        System.out.print("Enter new guest name (leave blank to keep current): ");
        String name = scanner.nextLine().trim();

        String email;
        do {
            System.out.print("Enter new email (leave blank to keep current): ");
            email = scanner.nextLine().trim();
            if (email.isEmpty() || isValidEmail(email)) break;
            System.out.println("Invalid email format. Please try again.");
        } while (true);

        String room;
        do {
            System.out.print("Enter new room type (leave blank to keep current): ");
            room = scanner.nextLine().trim();
            if (room.isEmpty() || isValidRoomType(room)) break;
            System.out.println("Invalid room type. Please enter Single, Double, or Suite.");
        } while (true);

        //Update values if new ones are entered
        if (!name.isEmpty()) booking.setGuestName(name);
        if (!email.isEmpty()) booking.setEmail(email);
        if (!room.isEmpty()) booking.setRoomType(capitalizeRoomType(room));

        saveBookings();
        System.out.println("Booking updated successfully.");
    }

    private static void deleteBooking() {
        System.out.print("Enter booking ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        Booking booking = findBookingById(id);
        if (booking != null) {
            bookings.remove(booking);
            saveBookings();
            System.out.println("Booking deleted.");
        } else {
            System.out.println("Booking not found.");
        }
    }

    private static void generateReport() {
        System.out.println("\nTotal Bookings: " + bookings.size());
        Map<String, Long> roomCount = new HashMap<>();

        for (Booking b : bookings) {
            roomCount.put(b.getRoomType(), roomCount.getOrDefault(b.getRoomType(), 0L) + 1);
        }

        roomCount.forEach((room, count) -> System.out.println(room + ": " + count));
    }

    private static boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$", email);
    }

    private static boolean isValidRoomType(String room) {
        return room.equalsIgnoreCase("Single") ||
                room.equalsIgnoreCase("Double") ||
                room.equalsIgnoreCase("Suite");
    }

    private static String capitalizeRoomType(String room) {
        if (room.equalsIgnoreCase("single")) return "Single";
        if (room.equalsIgnoreCase("double")) return "Double";
        if (room.equalsIgnoreCase("suite")) return "Suite";
        return room;
    }

    //Search booking by ID
    private static Booking findBookingById(int id) {
        return bookings.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    private static void loadBookings() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    String room = capitalizeRoomType(parts[3]);
                    bookings.add(new Booking(id, name, email, room));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing booking data found.");
        }
    }

    private static void saveBookings() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Booking b : bookings) {
                pw.println(b.getId() + "," + b.getGuestName() + "," + b.getEmail() + "," + b.getRoomType());
            }
        } catch (IOException e) {
            System.out.println("Failed to save bookings.");
        }
    }
}
