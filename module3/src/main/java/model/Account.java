package model;

public class Account {
    private int id;
    private String email;
    private String pass;
    private String firstName;
    private String LastName;
    private String phoneNumber;
    private String address;
    private int role;
    private int user_status;

    public Account() {
    }

    public Account(int id, String email, String pass, String firstName, String lastName, String phoneNumber, String address, int role, int user_status) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.firstName = firstName;
        this.LastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.user_status = user_status;
    }

    public Account(String email, String pass, String firstName, String lastName, String phoneNumber, String address) {
        this.email = email;
        this.pass = pass;
        this.firstName = firstName;
        this.LastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }
}
