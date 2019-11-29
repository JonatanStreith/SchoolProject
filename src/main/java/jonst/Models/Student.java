package jonst.Models;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private static int idCounter = 0;

    private int id;
    private String name;
    private String email;
    private String address;
    private List<Course> courseList;

    public Student(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
        id = ++idCounter;
        courseList = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String studentInfo(){

        return ("(" + getId() + ") " + getName() + "; e-mail: " + getEmail() + ", address: " + getAddress() + ".");
    }
}
