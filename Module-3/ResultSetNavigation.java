
import java.sql.*;

public class ResultSetNavigation {
    public static void main(String[] args) {
        try {
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            // Create scrollable ResultSet
            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = st.executeQuery(
                "SELECT * FROM student ORDER BY rollno"
            );

            // next()
            if (rs.next()) {
                System.out.println("Next: " + rs.getString("name"));
            }

            // last()
            if (rs.last()) {
                System.out.println("Last: " + rs.getString("name"));
            }

            // previous()
            if (rs.previous()) {
                System.out.println("Previous: " + rs.getString("name"));
            }

            // first()
            if (rs.first()) {
                System.out.println("First: " + rs.getString("name"));
            }

            // absolute()
            if (rs.absolute(2)) {
                System.out.println("Second row: " +
                    rs.getString("name"));
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
