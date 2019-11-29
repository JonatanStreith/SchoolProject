package jonst.Dao;

import jonst.Interfaces.CourseDao;
import jonst.Models.Course;
import jonst.Models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private static List<Course> courses = new ArrayList<>();

    public CourseDaoList() {
    }

    @Override
    public Course saveCourse(Course course) {

        courses.add(course);

        return course;
    }

    @Override
    public Course findById(int id) {

        for (Course course : courses) {
            if(course.getId() == id)
                return course;
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> returnList = new ArrayList();

        for (Course course : courses) {
            if(course.getCourseName().equalsIgnoreCase(name))
                returnList.add(course);
        }
        return returnList;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> returnList = new ArrayList();

        for (Course course : courses) {
            if(course.getStartDate().equals(date))
                returnList.add(course);
        }
        return returnList;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        if(courses.contains(course)){
            courses.remove(course);
            return true;
        }
        return false;
    }

    public int getNumberOfCourses(){
        return courses.size();
    }
}
