import java.util.ArrayList;

public class Invoice extends InvoiceController {
    private int invoiceNumber;
    private String date;
    private double total;
    private String customer;
    private int customerID;
    private ArrayList<Integer> productsBought;
    private ArrayList<Integer> quantity;
    private ArrayList<Double> discounts;
    private ArrayList<String> productNames;
    private ArrayList<Double> discountedProductValue;
    private ArrayList<Double> unitPrice;

    //variables used to return values when asked from admin tasks
    private String products;
    private String unitsperproduct;
    private String totalPricePerProduct;
    private String discountPerProduct;

    public  void display(){
        System.out.println("| "+invoiceNumber+" | "+date+" | "+customerID+" | "+customer+" | "+products+" | "+unitsperproduct+" | "+totalPricePerProduct+" | "+discountPerProduct+" | "+total+" | ");
    }

    public void setDiscountPerProduct(String discountPerPRoduct) {
        this.discountPerProduct = discountPerPRoduct;
    }

    public String getDiscountPerProduct() {
        return discountPerProduct;
    }

    public String getTotalPricePerProduct() {
        return totalPricePerProduct;
    }

    public void setTotalPricePerProduct(String totalPricePerProduct) {
        this.totalPricePerProduct = totalPricePerProduct;
    }

    public void setUnitsperproduct(String unitsperproduct) {
        this.unitsperproduct = unitsperproduct;
    }

    public String getUnitsperproduct() {
        return unitsperproduct;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getProducts() {
        return products;
    }

    public void setUnitPrice(ArrayList<Double> unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ArrayList<Double> getUnitPrice() {
        return unitPrice;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setDiscountedProductValue(ArrayList<Double> discountedProductValue) {
        this.discountedProductValue = discountedProductValue;
    }

    public ArrayList<Double> getDiscountedProductValue() {
        return discountedProductValue;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setDiscounts(ArrayList<Double> discounts) {
        this.discounts = discounts;
    }

    public ArrayList<Integer> getProductsBought() {
        return productsBought;
    }

    public void setProductsBought(ArrayList<Integer> productsBought) {
        this.productsBought = productsBought;
    }

    public ArrayList<Double> getDiscounts() {
        return discounts;
    }

    public ArrayList<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(ArrayList<String> productNames) {
        this.productNames = productNames;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }




}
