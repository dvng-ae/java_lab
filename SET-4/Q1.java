class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    void sound() {
        System.out.println("Dog says: Bow Bow");
    }
}

class Cat extends Animal {

    void sound() {
        System.out.println("Cat says: Meow Meow");
    }
}

class Q1 {
    public static void main(String[] args) {

        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}