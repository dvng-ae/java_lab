import java.io.*;
import java.util.Scanner;

class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        try {
            DataOutputStream out =
                new DataOutputStream(new FileOutputStream("student.dat"));

            out.writeInt(rollNo);
            out.writeUTF(name);
            out.writeDouble(marks);
            out.close();

            DataInputStream in =
                new DataInputStream(new FileInputStream("student.dat"));

            System.out.println("\nStudent Details:");
            System.out.println("Roll No: " + in.readInt());
            System.out.println("Name: " + in.readUTF());
            System.out.println("Marks: " + in.readDouble());

            in.close();

        } catch (IOException e) {
            System.out.println("File error");
        }
    }
}