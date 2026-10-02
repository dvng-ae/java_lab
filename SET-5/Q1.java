class MyThread extends Thread {

    public void run() {

        System.out.println("Thread is running");

        try {
            System.out.println("Thread is sleeping");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Thread completed");
    }
}

class Q1 {
    public static void main(String[] args) throws InterruptedException {

        MyThread t = new MyThread();

        System.out.println("Thread state: " + t.getState());

        t.start();

        System.out.println("Thread state: " + t.getState());

        Thread.sleep(500);

        System.out.println("Thread state: " + t.getState());

        t.join();

        System.out.println("Thread state: " + t.getState());
    }
}