class TicketBooking {

    int tickets = 5;

    synchronized void bookTicket(String name, int count) {

        try {
            if (tickets >= count) {

                System.out.println(name + " is booking " + count + " ticket(s)");

                Thread.sleep(500);

                tickets = tickets - count;

                System.out.println(name + " booked successfully");
                System.out.println("Remaining tickets = " + tickets);
                System.out.println();

            } else {
                System.out.println(name + " - Not enough tickets");
            }

        } catch (InterruptedException e) {
            System.out.println("Booking interrupted");
        }
    }
}

class Q5 {
    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        Thread t1 = new Thread(() -> {
            booking.bookTicket("Customer 1", 2);
        });

        Thread t2 = new Thread(() -> {
            booking.bookTicket("Customer 2", 2);
        });

        Thread t3 = new Thread(() -> {
            booking.bookTicket("Customer 3", 2);
        });

        try {
            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}