
import java.sql.*;
import java.io.*;

public class BlobClobExample {
    public static void main(String[] args) {
        try {
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/college",
                "root",
                ""
            );

            // Read image and text document
            FileInputStream image =
                new FileInputStream("photo.jpg");

            String document =
                "This is a student document. " +
                "It contains information about the student.";

            // Store image and text
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO files_data VALUES (?, ?, ?)"
            );

            ps.setInt(1, 1);
            ps.setBinaryStream(2, image);
            ps.setString(3, document);

            ps.executeUpdate();
            image.close();

            System.out.println("Image and document stored successfully!");

            ps.close();

            // Retrieve image and text
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT * FROM files_data WHERE id = 1"
            );

            if (rs.next()) {
                // Save retrieved image
                InputStream input = rs.getBinaryStream("photo");
                FileOutputStream output =
                    new FileOutputStream("retrieved.jpg");

                byte[] buffer = new byte[1024];
                int bytes;

                while ((bytes = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytes);
                }

                input.close();
                output.close();

                System.out.println("Image retrieved as retrieved.jpg");

                // Display retrieved text
                System.out.println("Document content:");
                System.out.println(rs.getString("document"));
            } else {
                System.out.println("No record found");
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
