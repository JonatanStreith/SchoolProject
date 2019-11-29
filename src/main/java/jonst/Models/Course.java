package jonst.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private static int idCounter = 0;

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        id = ++idCounter;
        students = new ArrayList();
    }

    public boolean register(Student student){
        students.add(student);
        return true;
    }

    public boolean unregister(Student student){
        students.remove(student);
        return true;
    }



    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean setCourseName(String courseName) {
        this.courseName = courseName;
        return true;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public boolean setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return true;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public boolean setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
        return true;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String courseInfo(){
        return ("(" + getId() + ") " + getCourseName() + "; starts " + getStartDate() + ", duration: " + getWeekDuration() + " weeks.");

    }
}
