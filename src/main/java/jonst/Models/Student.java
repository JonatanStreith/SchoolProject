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

    public String studentInfo(){

        return ("(" + getId() + ") " + getName() + "; e-mail: " + getEmail() + ", address: " + getAddress() + ".");
    }

    public boolean register(Course course){
        courseList.add((course));
        return true;
    }

    public boolean unregister(Course course){
        courseList.remove(course);
        return true;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}
