import javax.crypto.CipherInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.SimpleDateFormat;



public class Main {

    public static void addProducts(){// function which handles updating products
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

    } //Function used to add products

    public static void updateProducts() throws SQLException, ClassNotFoundException {//function which handles updating products
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

    } // Function used to update products

    public static void deleteProducts() throws SQLException, ClassNotFoundException {//Functions which handles deleting products
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product ID to delete: ");
        int id = input.nextInt();
        ProductController.deleteProduct(id);
    } //Function used to delete products

    public static void searchProducts() throws SQLException, ClassNotFoundException {// Function which handles searching for products
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        int id = input.nextInt();
        Product searchProduct = new Product();
        searchProduct.setProductId(id);
        ProductController.searchProduct(searchProduct);
        System.out.println("| Product ID | Product Name | Product Description | Selling Price | Purchasing Price | Quantity |");
        searchProduct.display();
    } //Function used to search for products

    public static void manageProducts() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t1: Add Product\n\t2: Update Product\n\t3: Remove Product\n\t4: Search for product\n\t5: Display all products \n\t");
        int menuSelection = 0;
        Boolean menu = false;
        while (!menu) {
            menuSelection = input.nextInt();
            switch (menuSelection){
                case 1:
                    addProducts();
                    System.out.print("Do you wish to add more Products or press E to exit (Y/N/E): ");
                    String choice1 = input.next();
                    switch(choice1){
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
                    break;
                case 2:
                    updateProducts();
                    System.out.print("Do you wish to update more products or press E to exit (Y/N/E): ");
                    String choice2 = input.next();
                    switch(choice2){
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
                    break;
                case 3:
                    deleteProducts();
                    System.out.print("Do you wish to delete more products or press E to exit (Y/N/E): ");
                    String choice3 = input.next();
                    switch(choice3){
                        case "Y":
                            deleteProducts();
                            break;
                        case "N":
                            manageProducts();
                            menu =true;
                        case "E":
                            menu =true;
                        default:
                            deleteProducts();
                    }
                case 4:
                    searchProducts();
                    System.out.print("Do you wish to search for more products or press E to exit (Y/N/E): ");
                    String choice4 = input.next();
                    switch(choice4){
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
                    break;
                case 5:
                    Product display = new Product();
                    System.out.println("| Product ID | Product Name | Product Description | Selling Price | Purchasing Price | Quantity |");
                    ProductController.displayProducts(display);
                    break;
                case 6:
                    System.out.println("Please enter either (1/2/3/4/5)");
                    break;
            }
        }

    }   //Function which manages the products

    public static void addCustomer(){// function which handles updating products
        Scanner input = new Scanner(System.in);
        System.out.print("Enter CustomerID: ");
        int customerID = input.nextInt();
        System.out.print("\nEnter Customer Name: ");
        String customerName = input.next();
        System.out.print(("\nEnter Customer Email: "));
        String email = input.next();
        System.out.print(("\nEnter Customer Address: "));
        String address = input.next();
        System.out.print(("\nEnter Customer Contact Number: "));
        int contactNumber = input.nextInt();
        System.out.print(("\nEnter Customer Date of birth: "));
        String dateOfBirth = input.next();
        System.out.print(("\nEnter Customer Gender: "));
        String gender = input.next();
        Customer nC = new Customer(customerID,customerName,email,address,contactNumber,dateOfBirth,gender);
        try{
            CustomerController.addCustomer(nC);
            System.out.println("Data Succesfully Inserted Into Database");
        }catch (ClassNotFoundException ex){
            System.out.println("Error connecting to SQL server");
        }catch (SQLException ex){
            System.out.println("SQl error");
        }

    } //Function used to add Customer

    public static void deleteCustomer() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer ID to delete: ");
        int id = input.nextInt();
        CustomerController.deleteCustomer(id);
        System.out.println("Customer deleted");
    }//Function used to delete customers

    public static void searchCustomer() throws SQLException,ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int id = input.nextInt();
        Customer searchCustomer = new Customer();
        searchCustomer.setCustomerId(id);
        CustomerController.searchCustomer(searchCustomer);
        System.out.println("| Product ID | Product Name | Product Description | Selling Price | Purchasing Price | Quantity |");
        searchCustomer.display();
    }//fucntion used to search customer

    public static void updateCustomer() throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer ID to update: ");
        int id = input.nextInt();
        Customer updateCustomer = new Customer();
        updateCustomer.setCustomerId(id);
        CustomerController.searchCustomer(updateCustomer);
        boolean z = false;
        while(!z) {
            System.out.println("\n\t1: CustomerName\n\t2: Update Email\n\t3: Update Address\n\t4: Update Contact number\n\t5: Update Date of birth\n\t6: Update gender\n\t7: Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter new Customer Name: ");
                    String cName = input.next();
                    updateCustomer.setCustomerName(cName);
                    break;
                case 2:
                    System.out.print("Enter new Email: ");
                    String email = input.next();
                    updateCustomer.setEmail(email);
                    break;
                case 3:
                    System.out.println("Enter new Address: ");
                    String address = input.next();
                    updateCustomer.setAddress(address);
                    break;
                case 4:
                    System.out.println("Enter new Contact Number: ");
                    int cNumber = input.nextInt();
                    updateCustomer.setContactNumber(cNumber);
                    break;
                case 5:
                    System.out.print("Enter new Date of birth: ");
                    String dob = input.next();
                    updateCustomer.setDateOfBirth(dob);
                    break;
                case 6:
                    System.out.print("Enter new Gender: ");
                    String gender = input.next();
                    updateCustomer.setGender(gender);

                case 7:
                    manageProducts();
                    break;

                default:
                    System.out.println("Please enter either (1/2/3/4)");

            }
            CustomerController.updateCustomer(updateCustomer);
        }


    }//fucntion used to update customer information

    public static void manageCustomer() throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.println("\t1: Add Customer\n\t2: Update Customer\n\t3: Remove Customer\n\t4: Search for Customer\n\t5: Display all Customers \n\t");
        int menuSelection = 0;
        Boolean menu = false;
        while(!menu){
            menuSelection = input.nextInt();
            switch (menuSelection){
                case 1:
                    addCustomer();
                    System.out.print("Do you wish to add more Customers or press E to exit (Y/N/E): ");
                    String cChoice = input.next();
                    switch(cChoice){
                        case "Y":
                            addCustomer();
                            break;
                        case "N":
                            manageCustomer();
                            menu =true;
                        case "E":
                            menu =true;
                        default:
                            manageCustomer();
                    }
                    break;
                case 2:
                    updateCustomer();
                    System.out.print("Do you wish to delete more customers or press E to exit (Y/N/E): ");
                    String cChoice6 = input.next();
                    switch(cChoice6){
                        case "Y":
                            updateCustomer();
                            break;
                        case "N":
                            manageCustomer();
                            menu =true;
                        case "E":
                            menu =true;
                        default:
                            manageCustomer();
                    }

                case 3:
                    deleteCustomer();
                    System.out.print("Do you wish to delete more customers or press E to exit (Y/N/E): ");
                    String cChoice1 = input.next();
                    switch(cChoice1){
                        case "Y":
                            deleteCustomer();

                        case "N":
                            manageCustomer();
                            menu =true;
                        case "E":
                            menu =true;
                        default:
                            manageCustomer();
                    }


                    break;

                case 4:
                    searchCustomer();
                    System.out.print("Do you wish to search more customers or press E to exit (Y/N/E): ");
                    String cChoice2 = input.next();
                    switch(cChoice2){
                        case "Y":
                            searchCustomer();
                            break;
                        case "N":
                            manageCustomer();
                            menu =true;
                        case "E":
                            menu =true;
                        default:
                            manageCustomer();
                    }

                case 5:
                    Customer cDisplay = new Customer();
                    System.out.println("| Product ID | Product Name | Product Description | Selling Price | Purchasing Price | Quantity |");
                    CustomerController.displayAllCustomers(cDisplay);
                    manageCustomer();
                    break;




            }






        }

    }//function that manages all the controlling functions of manageCustomer

    public static void invoiceManager() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        Invoice newInvoice = new Invoice();
        Product product = new Product();
        ArrayList<Integer> productsBought= new ArrayList<>();
        ArrayList<Integer> quantity= new ArrayList<>();
        ArrayList<Double> discounts= new ArrayList<>();
        ArrayList<Double> discountPerProduct= new ArrayList<>();
        ArrayList<Double> totalPricePerProduct= new ArrayList<>();
        ArrayList<String> productNames= new ArrayList<>();
        System.out.print("\nEnter Invoice ID: ");
        int invoiceID = input.nextInt();
        System.out.print("\nEnter Customer ID: ");
        int customerID = input.nextInt();
        Customer customer = new Customer();
        customer.setCustomerId(customerID);
        CustomerController.searchCustomer(customer);
        boolean menu = false;
        double pricePerUnit=0;

        double total =0;
        double discount =0;
        int x =0;
        while(!menu){
            System.out.print("\nEnter Product ID of item bought: ");
            int pId = input.nextInt();
            System.out.print(" Quantity: ");
            int qt =input.nextInt();

            System.out.print(" Discount %: ");
            double ds =input.nextDouble();

            product.setProductId(pId);
            ProductController.searchProduct(product);

            if (qt > product.getQuantity()){
                System.out.println("Stock not available on " + product.getProductName());
            }else {
                System.out.println("Stocks available");
                discounts.add(ds);
                productNames.add(product.getProductName());
                quantity.add(qt);
                productsBought.add(pId);
                total = total + (product.getSellingPrice() * quantity.get(x));
                product.setQuantity((product.getQuantity()-quantity.get(x)));
                discount = (product.getSellingPrice() * quantity.get(x)) *(discounts.get(x) /100);
                discountPerProduct.add(discount);
                pricePerUnit = product.getSellingPrice() - discount;
                totalPricePerProduct.add(pricePerUnit);
                total = total -discount;
                x++;
            }

            newInvoice.setCustomerID(customerID);
            newInvoice.setCustomer(customer.getCustomerName());
            newInvoice.setProductNames(productNames);
            newInvoice.setQuantity(quantity);
            newInvoice.setTotal(total);
            newInvoice.setUnitPrice(totalPricePerProduct);
            newInvoice.setDiscountedProductValue(discountPerProduct);
            ProductController.updateProduct(product);

            System.out.print("Any more Products? (1/0): ");
            int choice = input.nextInt();

            if(choice == 0){
                menu =true;
            }
        }

        newInvoice.setInvoiceNumber(invoiceID);
        Date newDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
        String date = dateFormat.format(newDate);
        newInvoice.setDate(date);

        InvoiceController.storeInvoice(newInvoice);
    } //handles the invoice management

    public static void adminTasks() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t1: View all invoices\n\t2: Search for invoice\n\t3: Search invoice from date\n\t4: Search a customers invoices ");
        int m = input.nextInt();
        switch(m){
            case 1:
                System.out.println("| InvoiceID | Date | CustomerID | CustomerName | Products | UnitsPerProducts | TotalPricePerProduct | DiscountPerProduct | TotalAmount |");
                Invoice invoice = new Invoice();
                InvoiceController.viewAllInvoices(invoice);
                break;
            case 2:
                System.out.print("Enter Invoice number: ");
                int invoiceNum = input.nextInt();
                Invoice newInvoice = new Invoice();
                newInvoice.setInvoiceNumber(invoiceNum);
                InvoiceController.searchInvoice(newInvoice);
                System.out.println("| InvoiceID | Date | CustomerID | CustomerName | Products | UnitsPerProducts | TotalPricePerProduct | DiscountPerProduct | TotalAmount |");
                newInvoice.display();
                break;
            case 3:
                System.out.print("Enter Date (MM/DD/YY): ");
                String date = input.next();
                Invoice invoiceNew = new Invoice();
                invoiceNew.setDate(date);
                System.out.println("| InvoiceID | Date | CustomerID | CustomerName | Products | UnitsPerProducts | TotalPricePerProduct | DiscountPerProduct | TotalAmount |");
                InvoiceController.searchInvoiceFromDate(invoiceNew);
            case 4:
                System.out.print("Enter Customer ID: ");
                int id = input.nextInt();
                Invoice inv = new Invoice();
                inv.setCustomerID(id);
                System.out.println("| InvoiceID | Date | CustomerID | CustomerName | Products | UnitsPerProducts | TotalPricePerProduct | DiscountPerProduct | TotalAmount |");
                InvoiceController.searchFromCustomerID(inv);


        }




    }//handles the admin tasks

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
                    manageCustomer();
                    menu = true;
                } else if (menuSelection == 3) {
                    invoiceManager();
                    menu = true;
                } else if (menuSelection == 4) {
                    adminTasks();
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