import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InvoiceController extends DatabaseConnector {

    public static void storeInvoice(Invoice z) throws SQLException, ClassNotFoundException {
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();


        ArrayList<Integer> quantity= z.getQuantity();
        ArrayList<Double> discounts= z.getDiscounts();
        ArrayList<String> productNames = z.getProductNames();
        ArrayList<Double> discountedProductValue = z.getDiscountedProductValue();
        ArrayList<Double> unitPrice = z.getUnitPrice();

        String products = "";//product names
        String unitPrices = "";//unit price of each product
        String discount = "";// calculates discount value of product
        String quant = "";// stores the quantities of products bought


        for (int i=1; i<productNames.size(); i++){
            products = productNames.get(i) +","+ products;
            unitPrices =  unitPrice.get(i).toString()+","+ unitPrices;
            discount = discountedProductValue.get(i).toString()+ "," + discount;
            quant = quantity.get(i).toString()+ ","+ quant;

        }
        stmt.executeUpdate("INSERT INTO invoice (InvoiceID,InvoiceDate,CustomerID,CustomerName,Products,UnitsPerProducts,TotalPricePerProduct,DiscountPerProduct,TotalAmount) VALUES("+z.getInvoiceNumber()+", '"+z.getDate()+"',"+z.getCustomerID()+",'"+z.getCustomer()+"','"+products+"','"+quant+"','"+unitPrices+"','"+discount+"',"+ z.getTotal()+")");



    }//stores an invoice in the SQL server

    public static void viewAllInvoices(Invoice z) throws SQLException, ClassNotFoundException {
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt = con.createStatement();
        ResultSet foundInvoice = stmt.executeQuery("SELECT * FROM invoice");
        while(foundInvoice.next()){
            z.setInvoiceNumber(foundInvoice.getInt("InvoiceID"));
            z.setDate(foundInvoice.getString("InvoiceDate"));
            z.setCustomerID(foundInvoice.getInt("CustomerID"));
            z.setCustomer(foundInvoice.getString("CustomerName"));
            z.setProducts(foundInvoice.getString("Products"));
            z.setUnitsperproduct(foundInvoice.getString("UnitsPerProducts"));
            z.setTotalPricePerProduct(foundInvoice.getString("TotalPricePerProduct"));
            z.setDiscountPerProduct(foundInvoice.getString("DiscountPerProduct"));
            z.setTotal(foundInvoice.getDouble("TotalAmount"));
            z.display();
        }
    }//display all invoices in the SQl server

    public static void searchInvoice(Invoice z) throws SQLException, ClassNotFoundException {
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();
        ResultSet foundInvoice = stmt.executeQuery("SELECT * FROM invoice WHERE InvoiceID = "+z.getInvoiceNumber()+"");
        foundInvoice.next();
        z.setDate(foundInvoice.getString("InvoiceDate"));
        z.setCustomerID(foundInvoice.getInt("CustomerID"));
        z.setCustomer(foundInvoice.getString("CustomerName"));
        z.setProducts(foundInvoice.getString("Products"));
        z.setUnitsperproduct(foundInvoice.getString("UnitsPerProducts"));
        z.setTotalPricePerProduct(foundInvoice.getString("TotalPricePerProduct"));
        z.setDiscountPerProduct(foundInvoice.getString("DiscountPerProduct"));
        z.setTotal(foundInvoice.getDouble("TotalAmount"));
    }//search for invoice using invoice number in SQL server

    public static void searchInvoiceFromDate(Invoice z) throws SQLException, ClassNotFoundException {
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();
        ResultSet foundInvoice = stmt.executeQuery("SELECT * FROM invoice WHERE InvoiceDate = '"+z.getDate()+"'");
        while(foundInvoice.next()) {
            z.setInvoiceNumber(foundInvoice.getInt("InvoiceID"));
            z.setCustomerID(foundInvoice.getInt("CustomerID"));
            z.setCustomer(foundInvoice.getString("CustomerName"));
            z.setProducts(foundInvoice.getString("Products"));
            z.setUnitsperproduct(foundInvoice.getString("UnitsPerProducts"));
            z.setTotalPricePerProduct(foundInvoice.getString("TotalPricePerProduct"));
            z.setDiscountPerProduct(foundInvoice.getString("DiscountPerProduct"));
            z.setTotal(foundInvoice.getDouble("TotalAmount"));
            z.display();
        }
    }//search invoice from date in SQL server

    public static void searchFromCustomerID(Invoice z) throws SQLException, ClassNotFoundException {
        Connection con;
        con = DatabaseConnector.getConnection();
        Statement stmt= con.createStatement();
        ResultSet foundInvoice = stmt.executeQuery("SELECT * FROM invoice WHERE CustomerID = "+z.getCustomerID()+"");
        while(foundInvoice.next()){
            z.setInvoiceNumber(foundInvoice.getInt("InvoiceID"));
            z.setCustomer(foundInvoice.getString("CustomerName"));
            z.setProducts(foundInvoice.getString("Products"));
            z.setUnitsperproduct(foundInvoice.getString("UnitsPerProducts"));
            z.setTotalPricePerProduct(foundInvoice.getString("TotalPricePerProduct"));
            z.setDiscountPerProduct(foundInvoice.getString("DiscountPerProduct"));
            z.setTotal(foundInvoice.getDouble("TotalAmount"));
            z.display();
        }




    }//search invoice from customer ID in SQL server

}
