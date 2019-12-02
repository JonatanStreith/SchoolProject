package jonst.Interfaces;

import jonst.Models.Course;
import jonst.Models.Lecture;

import java.time.LocalDate;
import java.util.List;

public interface LectureDao {
    Lecture saveLecture(Lecture lecture);
    Lecture findById(int id);
    List<Lecture> findBySubject(String subject);
    List<Lecture> findByDate(LocalDate date);
    List<Lecture> findAll();
    boolean removeLecture(Lecture lecture);
}
