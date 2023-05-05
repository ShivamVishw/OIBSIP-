package reservation;

import java.util.Scanner;

public class OnlineReservationSystem {
	private static boolean[] seats = new boolean[10]; // initialize the list of seats intially 10

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            // display menu
            System.out.println("\nSelect operation yow want perform:");
            System.out.println("1. View Seats");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            // Take input from user
            int option = sc.nextInt();
            switch (option) {

                case 1:
                    viewSeatMap();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.out.println("Thank you, visit again!");
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid option! \nSelect from below option");
            }
        }
    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // print an "X" if the seat is reserved
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's empty
            }
        }
        System.out.println();
    }

    private static void reserveSeat() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = sc.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }

    private static void cancelReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = sc.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // unreserve the seat
            System.out.println("Reservation canceled!");
        }
    }
}
