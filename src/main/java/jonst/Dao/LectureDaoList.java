package jonst.Dao;

import jonst.Interfaces.CourseDao;
import jonst.Interfaces.LectureDao;
import jonst.Models.Course;
import jonst.Models.Lecture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LectureDaoList implements LectureDao {

    private static List<Lecture> lectures = new ArrayList<>();

    public LectureDaoList() {
    }

    @Override
    public Lecture saveLecture(Lecture lecture) {

        lectures.add(lecture);

        return lecture;
    }

    @Override
    public Lecture findById(int id) {

        for (Lecture lecture : lectures) {
            if(lecture.getId() == id)
                return lecture;
        }
        return null;
    }

    @Override
    public List<Lecture> findBySubject(String subject) {
        List<Lecture> returnList = new ArrayList();

        for (Lecture lecture : lectures) {
            if(lecture.getSubject().equalsIgnoreCase(subject))
                returnList.add(lecture);
        }
        return returnList;
    }

    @Override
    public List<Lecture> findByDate(LocalDate date) {
        List<Lecture> returnList = new ArrayList();

        for (Lecture lecture : lectures) {
            if(lecture.getDate().equals(date))
                returnList.add(lecture);
        }
        return returnList;
    }

    @Override
    public List<Lecture> findAll() {
        return lectures;
    }

    @Override
    public boolean removeLecture(Lecture lecture) {
        if(lectures.contains(lecture)){
            lectures.remove(lecture);
            return true;
        }
        return false;
    }

    public int getNumberOfLectures(){
        return lectures.size();
    }
}
