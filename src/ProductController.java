import javax.xml.crypto.Data;
import java.sql.*;

public class ProductController {

    public ProductController(){}

    public static void addProduct(Product x)throws ClassNotFoundException,SQLException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();
        stmt.executeUpdate("INSERT INTO product (ProductID,ProductName,Description,PurchasePrice,SellingPrice,Quantity) VALUES ("+x.getProductId()+",'"+x.getProductName()+"','"+x.getDescription()+"','"+x.getPurchasePrice()+"','"+x.getSellingPrice()+"','"+x.getQuantity()+"')");
    }//adds product to SQL server

    public static void searchProduct(Product x)throws ClassNotFoundException,SQLException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt = con.createStatement();
        ResultSet foundProduct = stmt.executeQuery("SELECT * FROM product WHERE ProductID = "+x.getProductId()+"");
        foundProduct.next();
        x.setProductId(foundProduct.getInt("ProductID"));
        x.setProductName(foundProduct.getString("ProductName"));
        x.setDescription(foundProduct.getString("Description"));
        x.setPurchasePrice(foundProduct.getInt("PurchasePrice"));
        x.setSellingPrice(foundProduct.getInt("SellingPrice"));
        x.setQuantity(foundProduct.getInt("Quantity"));
    }//searches product and gets result from SQl server

    public static void deleteProduct(int id)throws ClassNotFoundException, SQLException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM product WHERE ProductID ="+id+"");
    }//deletes product from SQL server

    public static void updateProduct(Product x) throws SQLException, ClassNotFoundException {
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();
        stmt.executeUpdate("UPDATE Product SET SellingPrice = '"+x.getSellingPrice()+"',Description = '"+x.getDescription()+"', PurchasePrice = " +x.getPurchasePrice()+", Quantity = "+x.getQuantity()+", ProductName = '"+x.getProductName()+"'   WHERE ProductID = "+x.getProductId()+"");
    }//updates records in SQL server

    public static void displayProducts(Product x)throws ClassNotFoundException,SQLException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt = con.createStatement();
        ResultSet foundProduct = stmt.executeQuery("SELECT * FROM product");
        while(foundProduct.next()) {
            x.setProductId(foundProduct.getInt("ProductID"));
            x.setProductName(foundProduct.getString("ProductName"));
            x.setDescription(foundProduct.getString("Description"));
            x.setPurchasePrice(foundProduct.getInt("PurchasePrice"));
            x.setSellingPrice(foundProduct.getInt("SellingPrice"));
            x.setQuantity(foundProduct.getInt("Quantity"));
            x.display();
        }
    }//displays records in SQL server


}
