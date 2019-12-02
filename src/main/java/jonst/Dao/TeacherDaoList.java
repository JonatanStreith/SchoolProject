package jonst.Dao;

import jonst.Interfaces.StudentDao;
import jonst.Interfaces.TeacherDao;
import jonst.Models.Student;
import jonst.Models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoList implements TeacherDao {

    private static List<Teacher> teachers = new ArrayList<>();

    public TeacherDaoList() {
    }


    @Override
    public Teacher saveTeacher(Teacher teacher) {

        teachers.add(teacher);

        return teacher;
    }


    @Override
    public Teacher findByEmail(String email) {

        for (Teacher teacher : teachers) {
            if(teacher.getEmail().equalsIgnoreCase(email))
                return teacher;
        }
        return null;
    }


    @Override
    public List<Teacher> findByName(String name) {

        List<Teacher> returnList = new ArrayList();

        for (Teacher teacher : teachers) {
            if(teacher.getName().equalsIgnoreCase(name))
                returnList.add(teacher);
        }
        return returnList;

    }


    @Override
    public Teacher findById(int id) {

        for (Teacher teacher : teachers) {
            if(teacher.getId() == id)
                return teacher;
        }
        return null;
    }


    @Override
    public List<Teacher> findAll() {

        return teachers;
    }


    @Override
    public boolean deleteTeacher(Teacher teacher) {

        if(teachers.contains(teacher)){
            teachers.remove(teacher);
            return true;
        }
        return false;
    }

    public int getNumberOfTeachers(){
        return teachers.size();
    }
}
