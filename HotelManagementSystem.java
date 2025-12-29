import java.util.*;

class Room {
    int roomNumber;
    String roomType;
    double price;
    boolean isBooked;

    Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isBooked = false;
    }
}

class Booking {
    int roomNumber;
    String customerName;
    int days;

    Booking(int roomNumber, String customerName, int days) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
        this.days = days;
    }
}

public class HotelManagementSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        rooms.add(new Room(101, "Single", 1000));
        rooms.add(new Room(102, "Double", 2000));
        rooms.add(new Room(103, "Deluxe", 3000));

        int choice;
        do {
            System.out.println("\n==== HOTEL MANAGEMENT SYSTEM ====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Checkout Room");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> bookRoom();
                case 3 -> viewBookings();
                case 4 -> checkoutRoom();
                case 5 -> System.out.println("Thank You!");
                default -> System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }

    static void viewRooms() {
        System.out.println("\nRoom No\tType\tPrice\tStatus");
        for (Room r : rooms) {
            System.out.println(r.roomNumber + "\t" + r.roomType + "\t" +
                    r.price + "\t" + (r.isBooked ? "Booked" : "Available"));
        }
    }

    static void bookRoom() {
        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == roomNo && !r.isBooked) {
                sc.nextLine();
                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Days: ");
                int days = sc.nextInt();

                r.isBooked = true;
                bookings.add(new Booking(roomNo, name, days));
                System.out.println("Room Booked Successfully!");
                return;
            }
        }
        System.out.println("Room Not Available!");
    }

    static void viewBookings() {
        System.out.println("\nRoom\tCustomer\tDays");
        for (Booking b : bookings) {
            System.out.println(b.roomNumber + "\t" + b.customerName + "\t" + b.days);
        }
    }

    static void checkoutRoom() {
        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.roomNumber == roomNo) {
                it.remove();
                for (Room r : rooms) {
                    if (r.roomNumber == roomNo) {
                        r.isBooked = false;
                    }
                }
                System.out.println("Checkout Successful!");
                return;
            }
        }
        System.out.println("No Booking Found!");
    }
}
