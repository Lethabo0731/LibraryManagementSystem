import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "NewStrongPassword123";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}