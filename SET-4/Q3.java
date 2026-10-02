abstract class Vehicle {

    abstract void start();

    void display() {
        System.out.println("This is a vehicle");
    }
}

class Car extends Vehicle {

    void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike extends Vehicle {

    void start() {
        System.out.println("Bike starts with a button");
    }
}

class Q3 {
    public static void main(String[] args) {

        Car c = new Car();
        c.display();
        c.start();

        Bike b = new Bike();
        b.display();
        b.start();
    }
}