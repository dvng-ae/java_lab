
import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) {
        Connection con = null;

        try {
            // Connect to MySQL
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            // Disable automatic commit
            con.setAutoCommit(false);

            // Transfer amount
            int fromAccount = 1;
            int toAccount = 2;
            double amount = 1000.00;

            // Check sender's balance
            PreparedStatement check = con.prepareStatement(
                "SELECT balance FROM account WHERE id = ?"
            );
            check.setInt(1, fromAccount);

            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Sender account not found");
            }

            double balance = rs.getDouble("balance");
            rs.close();
            check.close();

            if (balance < amount) {
                throw new SQLException("Insufficient balance");
            }

            // Deduct money from sender
            PreparedStatement debit = con.prepareStatement(
                "UPDATE account SET balance = balance - ? WHERE id = ?"
            );
            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);

            if (debit.executeUpdate() != 1) {
                throw new SQLException("Debit failed");
            }
            debit.close();

            // Add money to receiver
            PreparedStatement credit = con.prepareStatement(
                "UPDATE account SET balance = balance + ? WHERE id = ?"
            );
            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);

            if (credit.executeUpdate() != 1) {
                throw new SQLException("Receiver account not found");
            }
            credit.close();

            // Save both changes
            con.commit();

            System.out.println("Transfer successful!");
            System.out.println("Amount transferred: Rs. " + amount);

        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());

            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction rolled back");
                }
            } catch (SQLException ex) {
                System.out.println("Rollback failed: " + ex.getMessage());
            }

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
