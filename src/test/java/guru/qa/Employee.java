package guru.qa;

import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private boolean permanent;
    private Address address;

     private ArrayList<String> phoneNumbers;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Employee(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Employee () {
        super();
    }
    public Employee(int id, String name, boolean permanent, Address address,
                    ArrayList<String> phoneNumbers, String role) {
   this ();
        this.id = id;
        this.name = name;
        this.permanent = permanent;
        this.role = role;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }



}
