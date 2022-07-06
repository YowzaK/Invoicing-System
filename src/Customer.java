public class Customer {
    private int customerId;
    private String customerName;
    private String email;
    private String address;
    private int contactNumber;
    private String dateOfBirth;
    private String gender;

    public Customer(){}// default constructor

    public Customer(int cId, String cName,String email, String address, int cNumber, String dob, String gender){// overloaded constructor
        customerId = cId;
        customerName =  cName;
        this.email = email;
        this.address = address;
        contactNumber = cNumber;
        dateOfBirth = dob;
        this.gender = gender;
    }

    public void display(){
        System.out.println("| "+customerId+" | "+customerName+" | "+email+" | "+address+" | "+contactNumber+" | "+dateOfBirth+" | "+gender+" |");
    }

    //getters and setters for customer
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
