import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionDAO {

    public void borrowBook(int bookId, int userId) {

        String borrowQuery = "INSERT INTO Transactions(book_id,user_id,borrow_date,status) VALUES(?,?,CURDATE(),'BORROWED')";
        String updateBook = "UPDATE Books SET available = false WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement ps1 = conn.prepareStatement(borrowQuery);
            ps1.setInt(1, bookId);
            ps1.setInt(2, userId);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(updateBook);
            ps2.setInt(1, bookId);
            ps2.executeUpdate();

            conn.commit();

            System.out.println("Book borrowed successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {

        String returnQuery = "UPDATE Transactions SET return_date = CURDATE(), status='RETURNED' WHERE book_id = ? AND status='BORROWED'";
        String updateBook = "UPDATE Books SET available = true WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement ps1 = conn.prepareStatement(returnQuery);
            ps1.setInt(1, bookId);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(updateBook);
            ps2.setInt(1, bookId);
            ps2.executeUpdate();

            conn.commit();

            System.out.println("Book returned successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}