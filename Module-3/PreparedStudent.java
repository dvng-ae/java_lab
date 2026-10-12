
import java.sql.*;
import java.util.Scanner;

public class PreparedStudent {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            // Get student details
            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter mark: ");
            int mark = sc.nextInt();

            // Insert student using PreparedStatement
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO student VALUES (?, ?, ?)"
            );

            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setInt(3, mark);

            ps.executeUpdate();
            System.out.println("Student registered successfully!");

            ps.close();

            // Search student by roll number
            System.out.print("Enter roll number to search: ");
            int searchRoll = sc.nextInt();

            PreparedStatement search = con.prepareStatement(
                "SELECT * FROM student WHERE rollno = ?"
            );

            search.setInt(1, searchRoll);

            ResultSet rs = search.executeQuery();

            if (rs.next()) {
                System.out.println("\nStudent Details");
                System.out.println("Roll Number: " + rs.getInt("rollno"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Mark: " + rs.getInt("mark"));
            } else {
                System.out.println("Student not found");
            }

            rs.close();
            search.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
