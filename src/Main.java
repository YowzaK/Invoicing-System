import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;



public class Main {

    public static void addProducts(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        int productID = input.nextInt();
        System.out.print("\nEnter Product Name");
        String productName = input.next();
        System.out.print(("\nEnter Product Description"));
        String desription = input.next();
        System.out.print(("\nEnter Product Purchase Price"));
        int purchasePrice = input.nextInt();
        System.out.print(("\nEnter Product Selling Price"));
        int sellingPrice = input.nextInt();
        System.out.print(("\nEnter Product Quantity"));
        int quantity = input.nextInt();
        Product np = new Product(productID,productName,desription,purchasePrice,sellingPrice,quantity);
        try{
            ProductController.addProduct(np);
            System.out.println("Data Succesfully Inserted Into Database");
        }catch (ClassNotFoundException ex){
            System.out.println("Error connecting to SQL server");
        }catch (SQLException ex){
            System.out.println("SQl error");
        }

    }


    public static void updateProducts() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product ID to update: ");
        int id = input.nextInt();
        Product updateProduct = new Product();
        updateProduct.setProductId(id);
        ProductController.searchProduct(updateProduct);
        boolean z = false;
        while(!z) {
            System.out.println("\n\t1: Update ProductName\n\t2: Update Description\n\t3: Update Selling Price\n\t4: Update Purchase Price\n\t5: Update Quantity\n\t6: Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter new Product Name: ");
                    String pName = input.next();
                    updateProduct.setProductName(pName);
                    break;
                case 2:
                    System.out.print("Enter new Description: ");
                    String desc = input.next();
                    updateProduct.setDescription(desc);
                    break;
                case 3:
                    System.out.println("Enter new Selling price: ");
                    int sPrice = input.nextInt();
                    updateProduct.setSellingPrice(sPrice);
                    break;
                case 4:
                    System.out.println("Enter new Purchasing Price: ");
                    int pPrice = input.nextInt();
                    updateProduct.setPurchasePrice(pPrice);
                    break;
                case 5:
                    System.out.print("Enter new Quantity: ");
                    int quan = input.nextInt();
                    updateProduct.setQuantity(quan);
                    break;
                case 6:
                    manageProducts();
                    break;
                default:
                    System.out.println("Please enter either (1/2/3/4)");

            }
            ProductController.updateProduct(updateProduct);
        }

    }



    public static void deleteProducts() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product ID to delete: ");
        int id = input.nextInt();
        ProductController.deleteProduct(id);
    }

    public static void searchProducts() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        int id = input.nextInt();
        Product searchProduct = new Product();
        searchProduct.setProductId(id);
        ProductController.searchProduct(searchProduct);
        System.out.println("| Product ID | Product Name | Product Description | Selling Price | Purchasing Price | Quantity |");
        searchProduct.display();
    }
    //function used to manage products
    public static void manageProducts() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t1: Add Product\n\t2: Update Product\n\t3: Remove Product\n\t4: Search for product\n\t5: Display all products \n\t");
        int menuSelection = 0;
        Boolean menu = false;
        while (!menu) {
            menuSelection = input.nextInt();
            if (menuSelection == 1){
                addProducts();
                System.out.print("Do you wish to add more Products or press E to exit (Y/N/E): ");
                String choice = input.next();
                switch(choice){
                    case "Y":
                        addProducts();
                        break;
                    case "N":
                        manageProducts();
                        menu =true;
                    case "E":
                        menu =true;
                    default:
                        manageProducts();
                }

            }else if (menuSelection == 2){
               updateProducts();
                System.out.print("Do you wish to update more products or press E to exit (Y/N/E): ");
                String choice = input.next();
                switch(choice){
                    case "Y":
                        updateProducts();
                        break;
                    case "N":
                        manageProducts();
                        menu =true;
                    case "E":
                        menu =true;
                    default:
                        manageProducts();
                }

            }else if (menuSelection==3){
                deleteProducts();
                System.out.print("Do you wish to delete more products or press E to exit (Y/N/E): ");
                String choice = input.next();
                switch(choice){
                    case "Y":
                        deleteProducts();
                        break;
                    case "N":
                        manageProducts();
                        menu =true;
                    case "E":
                        menu =true;
                    default:
                        manageProducts();
                }


            }else if (menuSelection==4){//searching product
               searchProducts();
                System.out.print("Do you wish to search for more products or press E to exit (Y/N/E): ");
                String choice = input.next();
                switch(choice){
                    case "Y":
                        searchProducts();
                        break;
                    case "N":
                        manageProducts();
                        menu =true;
                    case "E":
                        menu =true;
                    default:
                        manageProducts();
                }

            }else if(menuSelection == 5) {
                Product display = new Product();
                System.out.println("| Product ID | Product Name | Product Description | Selling Price | Purchasing Price | Quantity |");
                ProductController.displayProducts(display);
            }else {
                System.out.println("Please enter either (1/2/3/4)");
            }

        }

    }






    public static void main(String[] args) {
        System.out.println("\t\tWelcome to Invoice System");
        System.out.println("\t1: Manage Products\n\t2: Manage Customers\n\t3: Invoice Generation\n\t4: Admin tasks\n\t");
        Scanner input = new Scanner(System.in);
        int menuSelection =0;
        Boolean menu = false;
        while(!menu){
            try {
                System.out.print("Enter selection: ");
                menuSelection = input.nextInt();
                if (menuSelection == 1) {
                    manageProducts();
                    menu = true;
                } else if (menuSelection == 2) {
                    System.out.println("2");
                    menu = true;
                } else if (menuSelection == 3) {
                    System.out.println("3");
                    menu = true;
                } else if (menuSelection == 4) {
                    System.out.println("4");
                    menu = true;
                } else {
                    System.out.println("Please enter either (1/2/3/4)");
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }



}