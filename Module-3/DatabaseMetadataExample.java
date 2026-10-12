
import java.sql.*;

public class DatabaseMetadataExample {
    public static void main(String[] args) {
        try {
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            // Get database metadata
            DatabaseMetaData md = con.getMetaData();

            System.out.println("Database Name: " +
                md.getDatabaseProductName());

            System.out.println("Database Version: " +
                md.getDatabaseProductVersion());

            System.out.println("Driver Name: " +
                md.getDriverName());

            System.out.println("Driver Version: " +
                md.getDriverVersion());

            System.out.println("Supports Transactions: " +
                md.supportsTransactions());

            System.out.println("Supports Batch Updates: " +
                md.supportsBatchUpdates());

            // Display available tables
            System.out.println("\nAvailable Tables:");

            ResultSet rs = md.getTables(
                con.getCatalog(),
                null,
                "%",
                new String[]{"TABLE"}
            );

            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }

            rs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
