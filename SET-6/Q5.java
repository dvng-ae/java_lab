import java.io.*;
import java.util.Scanner;

class Q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        try {
            DataOutputStream out =
                    new DataOutputStream(new FileOutputStream("employee.dat"));

            out.writeInt(id);
            out.writeUTF(name);
            out.writeDouble(salary);

            out.close();

            DataInputStream in =
                    new DataInputStream(new FileInputStream("employee.dat"));

            int empId = in.readInt();
            String empName = in.readUTF();
            double empSalary = in.readDouble();

            in.close();

            System.out.println("\nEmployee Details:");
            System.out.println("Employee ID: " + empId);
            System.out.println("Name: " + empName);
            System.out.println("Salary: " + empSalary);

        } catch (IOException e) {
            System.out.println("File error");s
        }
    }
}