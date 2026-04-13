import java.util.*;
class Bus {
    int busNo;
    String route;
    int seats;
    int bookedSeats;

    Bus(int busNo, String route, int seats) {
        this.busNo = busNo;
        this.route = route;
        this.seats = seats;
        this.bookedSeats = 0;
    }
    void display() {
        System.out.println("Bus No: " + busNo +
                ", Route: " + route +
                ", Total Seats: " + seats +
                ", Available: " + (seats - bookedSeats));
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Bus> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Add Bus 2.View 3.Book 4.Cancel 5.Search 6.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Bus No: ");
                    int no = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Route: ");
                    String route = sc.nextLine();

                    System.out.print("Enter Total Seats: ");
                    int seats = sc.nextInt();

                    list.add(new Bus(no, route, seats));
                    System.out.println("Bus Added!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No buses available!");
                    } else {
                        for (Bus b : list) {
                            b.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Bus No to Book: ");
                    int bno = sc.nextInt();
                    boolean booked = false;

                    for (Bus b : list) {
                        if (b.busNo == bno) {
                            if (b.bookedSeats < b.seats) {
                                b.bookedSeats++;
                                System.out.println("Ticket Booked!");
                            } else {
                                System.out.println("No seats available!");
                            }
                            booked = true;
                        }
                    }
                    if (!booked)
                        System.out.println("Bus not found!");
                    break;

                case 4:
                    System.out.print("Enter Bus No to Cancel: ");
                    int cno = sc.nextInt();
                    boolean cancelled = false;

                    for (Bus b : list) {
                        if (b.busNo == cno && b.bookedSeats > 0) {
                            b.bookedSeats--;
                            System.out.println("Ticket Cancelled!");
                            cancelled = true;
                        }
                    }
                    if (!cancelled)
                        System.out.println("Invalid cancel request!");
                    break;

                case 5:
                    System.out.print("Enter Bus No to Search: ");
                    int sno = sc.nextInt();
                    boolean found = false;

                    for (Bus b : list) {
                        if (b.busNo == sno) {
                            b.display();
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("Bus not found!");
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
