import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    private static final String USER = "root";   // your MySQL username
    private static final String PASSWORD = "mj@1499"; // your MySQL password

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
