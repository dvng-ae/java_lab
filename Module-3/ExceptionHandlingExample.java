
import java.sql.*;
import java.util.Scanner;

public class ExceptionHandlingExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Get input from the user
            System.out.print("Enter Roll Number: ");
            int roll = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mark: ");
            int mark = Integer.parseInt(sc.nextLine());

            if (roll <= 0 || mark < 0 || mark > 100) {
                throw new IllegalArgumentException(
                    "Roll number must be positive and mark must be 0-100."
                );
            }

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            // SQL query
            String sql =
                "INSERT INTO student (rollno, name, mark) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setInt(3, mark);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted successfully!");
            }

            ps.close();
            con.close();

        } catch (NumberFormatException e) {
            System.out.println("Error: Enter numbers for roll number and mark.");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Duplicate roll number or constraint violation.");

        } catch (SQLSyntaxErrorException e) {
            System.out.println("Error: Invalid SQL query or database/table name.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
