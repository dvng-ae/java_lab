import java.util.Scanner;

interface Printable {
    void print();
}

class Student implements Printable {

    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void print() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

class Teacher implements Printable {

    String name;
    String subject;

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void print() {
        System.out.println("Teacher Details:");
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
    }
}

class Q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter teacher name: ");
        String teacherName = sc.nextLine();

        System.out.print("Enter teacher subject: ");
        String subject = sc.nextLine();

        Student s = new Student(studentName, rollNo);
        Teacher t = new Teacher(teacherName, subject);

        System.out.println();

        s.print();

        System.out.println();

        t.print();
    }
}