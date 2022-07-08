import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerController {
    public CustomerController(){};

    public static void addCustomer(Customer y) throws SQLException, ClassNotFoundException {
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();
        stmt.executeUpdate("INSERT INTO customers (CustomerID,CustomerName,Email,Address,ContactNumber,DateOfBirth,Gender) VALUES ("+y.getCustomerId()+",'"+y.getCustomerName()+"','"+y.getEmail()+"','"+y.getAddress()+"',"+y.getContactNumber()+",'"+y.getDateOfBirth()+"','"+y.getGender()+"')");
    }//add new customer to SQL server

    public static void deleteCustomer(int id) throws SQLException, ClassNotFoundException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM Customers WHERE CustomerID ="+id+"");
    }//delete record from SQL server

    public static void searchCustomer(Customer y) throws SQLException, ClassNotFoundException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt = con.createStatement();
        ResultSet foundCustomer = stmt.executeQuery("SELECT * FROM customers WHERE CustomerID = "+y.getCustomerId()+"");
        foundCustomer.next();
        y.setCustomerId(foundCustomer.getInt("CustomerID"));
        y.setCustomerName(foundCustomer.getString("CustomerName"));
        y.setEmail(foundCustomer.getString("Email"));
        y.setAddress(foundCustomer.getString("Address"));
        y.setContactNumber(foundCustomer.getInt("ContactNumber"));
        y.setDateOfBirth(foundCustomer.getString("DateOfBirth"));
        y.setGender(foundCustomer.getString("Gender"));
    }//search for record in SQL server

    public static void displayAllCustomers(Customer y) throws SQLException,ClassNotFoundException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt = con.createStatement();
        ResultSet foundCustomer = stmt.executeQuery("SELECT * FROM customers");
        while(foundCustomer.next()) {
            y.setCustomerId(foundCustomer.getInt("CustomerID"));
            y.setCustomerName(foundCustomer.getString("CustomerName"));
            y.setEmail(foundCustomer.getString("Email"));
            y.setAddress(foundCustomer.getString("Address"));
            y.setContactNumber(foundCustomer.getInt("ContactNumber"));
            y.setDateOfBirth(foundCustomer.getString("DateOfBirth"));
            y.setGender(foundCustomer.getString("Gender"));
            y.display();
        }



    }//displays all records in SQL server

    public static void updateCustomer(Customer y)throws SQLException,ClassNotFoundException{
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();
        stmt.executeUpdate("UPDATE customers SET  CustomerName ='"+y.getCustomerName()+"', Email = '"+y.getEmail()+"', Address = '"+y.getAddress()+"', DateOfBirth = '"+y.getDateOfBirth()+"', ContactNumber = "+y.getContactNumber()+", Gender = '"+y.getGender()+"' WHERE CustomerID = "+y.getCustomerId()+"");
    }//update information of a record in SQL server
}
