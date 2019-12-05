package jonst.Models;

public class Teacher {

    private static int idCounter = 0;

    private int id;
    private String name;
    private String email;
    private String address;

    public Teacher(String name, String email, String address) {
        setName(name);
        setEmail(email);
        setAddress(address);
        id = ++idCounter;

    }

    public int getId() {
        return id;
    }

     public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        this.address = address;
        return true;
    }

    public String teacherInfo(){

        return ("(" + getId() + ") " + getName() + "; e-mail: " + getEmail() + ", address: " + getAddress() + ".");
    }
}
