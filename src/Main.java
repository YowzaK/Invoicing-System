import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {


        Product apple = new Product(1,"apple","fresh",10,15,20);
        ProductController products = new ProductController();
       int x = products.addProduct(apple);
       if (x!= 0){
            System.out.println("Added");
        }else{
           System.out.println("sql error");
       }


    }
}