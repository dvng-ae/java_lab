
import java.sql.*;

public class ResultSetMetadataExample {
    public static void main(String[] args) {
        try {
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            // Execute query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            // Get ResultSet metadata
            ResultSetMetaData md = rs.getMetaData();

            int count = md.getColumnCount();

            System.out.println("Number of Columns: " + count);
            System.out.println("\nColumn Details:");

            // Display information about each column
            for (int i = 1; i <= count; i++) {
                System.out.println("\nColumn Number: " + i);
                System.out.println("Column Name: " +
                    md.getColumnName(i));
                System.out.println("Data Type: " +
                    md.getColumnTypeName(i));
                System.out.println("Column Size: " +
                    md.getColumnDisplaySize(i));
                System.out.println("Is Nullable: " +
                    md.isNullable(i));
                System.out.println("Is Auto Increment: " +
                    md.isAutoIncrement(i));
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
