
import java.sql.*;

public class StudentCrud {
    public static void main(String[] args) {
        try {
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            Statement st = con.createStatement();

            // INSERT
            st.executeUpdate(
                "INSERT INTO student VALUES (1, 'Arun', 85)"
            );
            System.out.println("Record inserted successfully");

            // UPDATE
            st.executeUpdate(
                "UPDATE student SET mark = 90 WHERE rollno = 1"
            );
            System.out.println("Record updated successfully");

            // SELECT
            ResultSet rs = st.executeQuery(
                "SELECT * FROM student"
            );

            System.out.println("Student Details:");

            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rollno"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Mark: " + rs.getInt("mark"));
            }

            rs.close();

            // DELETE
            st.executeUpdate(
                "DELETE FROM student WHERE rollno = 1"
            );
            System.out.println("Record deleted successfully");

            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
