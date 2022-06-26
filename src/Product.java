public class Product {
    private int productId;
    private String productName;
    private String description;
    private int purchasePrice,sellingPrice,quantity;

    public Product(){} //default constructor

    public Product(int pID,String pName, String desc,int pPrice,int sPrice,int quantity){ // overloaded constructor
        productId = pID;
        productName =  pName;
        description = desc;
        this.quantity = quantity;
        purchasePrice = pPrice;
        sellingPrice =sPrice;
    }

    //setter and getters for the private variables
    public void setProductId(int x){
        productId = x;
    }

    public int getProductId(){
        return productId;
    }

    public void setProductName(String x){
        productName = x;
    }

    public String getProductName(){
        return productName;
    }

    public void setDescription(String x){
        description = x;
    }

    public String getDescription(){
        return description;
    }

    public void setPurchasePrice(int x){
        purchasePrice = x;
    }

    public int getPurchasePrice(){
        return purchasePrice;
    }

    public void setSellingPrice(int x){
        sellingPrice =x;
    }

    public int getSellingPrice(){
        return sellingPrice;
    }

    public void setQuantity(int x){
        quantity =x;
    }

    public int getQuantity(){
        return quantity;
    }


}
