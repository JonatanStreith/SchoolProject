package jonst.Interfaces;

import jonst.Models.Student;
import jonst.Models.Teacher;

import java.util.List;

public interface TeacherDao {
    Teacher saveTeacher(Teacher teacher);
    Teacher findByEmail(String email);
    List<Teacher> findByName(String name);
    Teacher findById(int id);
    List<Teacher> findAll();
    boolean deleteTeacher(Teacher teacher);
}
