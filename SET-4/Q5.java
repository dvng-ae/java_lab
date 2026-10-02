import java.util.Scanner;

interface Sports {
    void sportsInfo();
}

interface Academics {
    void academicInfo();
}

class Student implements Sports, Academics {

    String name;
    String sport;
    double mark;

    Student(String name, String sport, double mark) {
        this.name = name;
        this.sport = sport;
        this.mark = mark;
    }

    public void sportsInfo() {
        System.out.println("Sports: " + sport);
    }

    public void academicInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Mark: " + mark);
    }
}

class Q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter mark: ");
        double mark = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter sport: ");
        String sport = sc.nextLine();

        Student s = new Student(name, sport, mark);

        System.out.println("\nStudent Details:");
        s.academicInfo();
        s.sportsInfo();
    }
}