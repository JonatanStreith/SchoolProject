package jonst.Models;

import java.time.LocalDate;
import java.util.List;

public class Lecture {

    private static int idCounter = 0;

    private int id;
    private String subject;
    private LocalDate date;
    private List<Teacher> teachers;
    private Course assignedTo;

    private boolean assignedToCourse;


    public Lecture(String subject, LocalDate date) {
        this.subject = subject;
        this.date = date;
        id = ++idCounter;
        assignedToCourse = false;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public boolean setSubject(String subject) {
        this.subject = subject;
        return true;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean setDate(LocalDate date) {
        this.date = date;
        return true;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public Course getAssignedTo() {
        return assignedTo;
    }

    public boolean setAssignedTo(Course assignedTo) {
        this.assignedTo = assignedTo;
        return true;
    }

    public boolean isAssignedToCourse() {
        return assignedToCourse;
    }

    public boolean setAssignedToCourse(boolean assignedToCourse) {
        this.assignedToCourse = assignedToCourse;
        return true;
    }

    public boolean registerTeacher(Teacher teacher) {
        teachers.add(teacher);
        return true;
    }

    public boolean unregisterTeacher(Teacher teacher) {
        teachers.remove(teacher);
        return true;
    }

    public String lectureInfo(){
        return ("(" + getId() + ") " + getSubject() + "; on date " + getDate() + ".");
    }
}
