package jonst.Dao;

import jonst.Interfaces.StudentDao;
import jonst.Models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> students;


    @Override
    public Student saveStudent(Student student) {

        students.add(student);

        return student;
    }

    @Override
    public Student findByEmail(String email) {

        for (Student student : students) {
            if(student.getEmail().equalsIgnoreCase(email))
                return student;
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {

        List<Student> returnList = new ArrayList();

        for (Student student : students) {
            if(student.getName().equalsIgnoreCase(name))
                returnList.add(student);
        }
        return returnList;

    }

    @Override
    public Student findById(int id) {

        for (Student student : students) {
            if(student.getId() == id)
                return student;
        }
        return null;
    }

    @Override
    public List<Student> findAll() {

        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {

        if(students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }
}
