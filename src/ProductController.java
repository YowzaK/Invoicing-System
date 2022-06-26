import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductController {

    public ProductController(){}

    public int addProduct(Product x)throws ClassNotFoundException,SQLException{
        Connection con;
        Statement stmt;
        con = DatabaseConnector.getConnection();
        stmt = con.createStatement();
        int i = stmt.executeUpdate("INSERT INTO product (ProductID,ProductName,Description,PurchasePrice,SellingPrice,Quantity) VALUES ("+x.getProductId()+",'"+x.getProductName()+"','"+x.getDescription()+"','"+x.getPurchasePrice()+"','"+x.getSellingPrice()+"','"+x.getQuantity()+"')");
        return i;
    }

}
