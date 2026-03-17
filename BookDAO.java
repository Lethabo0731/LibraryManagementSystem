import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

    public void addBook(String title, String author) {

        String query = "INSERT INTO Books(title, author) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, title);
            ps.setString(2, author);

            ps.executeUpdate();
            System.out.println("Book added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {

        String query = "SELECT * FROM Books";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getBoolean("available")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {

        String query = "DELETE FROM Books WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Book deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}