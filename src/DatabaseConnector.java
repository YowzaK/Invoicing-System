import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    static Connection getConnection()throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice_system","root","");
        return con;
    }
}
