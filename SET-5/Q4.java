class BankAccount {

    int balance = 1000;

    synchronized void withdraw(int amount) {

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " is withdrawing " + amount);

            balance = balance - amount;

            System.out.println("Remaining Balance = " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class Q4 {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            account.withdraw(500);
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            account.withdraw(500);
        }, "Thread 2");

        t1.start();
        t2.start();
    }
}