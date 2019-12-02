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
    private Teacher supervisor;
    private List<Lecture> lectures;

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        id = ++idCounter;
        students = new ArrayList();
        lectures = new ArrayList();
    }

    public boolean register(Student student){
        students.add(student);
        student.register(this);          //When a course registers a student, the student also registers the course.
        return true;                             //Important to not call the methods improperly. But this should fulfill the "only calling one method" requirement.
    }

    public boolean unregister(Student student){
        students.remove(student);
        student.unregister(this);
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

    public Teacher getSupervisor() {
        return supervisor;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public boolean assignSupervisor(Teacher supervisor){
        this.supervisor = supervisor;
        return true;
    }

    public boolean unassignSupervisor(){
        supervisor = null;
        return true;
    }

    public boolean addLecture(Lecture lecture){
        lectures.add(lecture);
        lecture.setAssignedTo(this);
        return true;
    }

    public boolean removeLecture(Lecture lecture){
        if(lectures.contains(lecture)) {
            lectures.remove(lecture);
            lecture.setAssignedTo(null);
            return true;
        }
        else {
            System.out.println("That lecture has already been removed or is assigned to a different course.");
            return false;
        }

    }



    public String courseInfo(){
        return ("(" + getId() + ") " + getCourseName() + "; starts " + getStartDate() + ", duration: " + getWeekDuration() + " weeks.");
    }
}
