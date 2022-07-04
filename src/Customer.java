public class Customer {
    private int customerId;
    private String customerName;
    private String email;
    private String address;
    private int contactNumber;
    private int dateOfBirth;
    private String gender;

    public Customer(){}// default constructor

    public Customer(int cId, String cName,String email, String address, int cNumber, int dob, String gender){// overloaded constructor
        customerId = cId;
        customerName =  cName;
        this.email = email;
        this.address = address;
        dateOfBirth = dob;
        this.gender = gender;
    }

}
