import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void addUser(String name, String email) {

        String query = "INSERT INTO Users(name, email) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setString(2, email);

            ps.executeUpdate();
            System.out.println("User added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}