package jonst.Dao;

import jonst.Models.Course;
import jonst.Models.Lecture;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LectureDaoListTest {

    LectureDaoList testDao;

    @Before
    public void setUp() throws Exception {

        testDao = new LectureDaoList();

        List<Lecture> experimentalLectures = new ArrayList() {{
            add(new Lecture("New Math", LocalDate.parse("2020-03-01")));
            add(new Lecture("Arbitrage", LocalDate.parse("2019-12-13")));
            add(new Lecture("The conscious of self", LocalDate.parse("2020-02-17")));
            add(new Lecture("Dynamite handling", LocalDate.parse("2020-05-21")));
            add(new Lecture("Test tube hygiene", LocalDate.parse("2019-12-07")));
            add(new Lecture("Avoiding the Grandfather Paradox", LocalDate.parse("1138-09-15")));
            add(new Lecture("Napkin etiquette", LocalDate.parse("2020-01-14")));
        }};

        for (Lecture lecture : experimentalLectures) {            //Filling our courselist a little, just to have something to play with
            testDao.saveLecture(lecture);
        }



    }

    @Test
    public void constructorTest() {

        assertNotNull(testDao);
    }

    @Test
    public void saveLectureTest() {

        Lecture testLecture = new Lecture("Twiddling", LocalDate.parse("2020-04-11"));

        int before = testDao.getNumberOfLectures();  //Count number of lecture before, and after adding a lecture to the list.
        testDao.saveLecture(testLecture);
        int after = testDao.getNumberOfLectures();

        assertTrue(after == before + 1);         //Check that "after" is one higher than "before".

    }

    @Test
    public void findAllTest() {

        List<Lecture> buffer = testDao.findAll();

        for (Lecture lecture : buffer) {
            System.out.println("(" + lecture.getId() + ") " + lecture.getSubject() + "; starts " + lecture.getDate() + ".");
        }

        assertEquals(testDao.getNumberOfLectures(), buffer.size());      //Since the tests may add and remove lectures, we can't assume too much about the contents.
        //We can, however, expect the established lecture count to match the number of courses in the "find all" list.
        //I.e. if we know there are five courses, we should get a list of five courses.
    }

    @Test
    public void findByIdTest() {

        Lecture retrieve = testDao.findById(1);
        Lecture failed = testDao.findById(999);

        assertEquals("New Math", retrieve.getSubject());
        assertNull(failed);
    }

    @Test
    public void findBySubjectTest() {

        List<Lecture> retrieve = testDao.findBySubject("Test tube hygiene");    //For the sake of the argument, we expect at least one lecture by this name to exist.
        List<Lecture> failed = testDao.findBySubject("Nonexistent Subject");     //This should give us an empty, zero-size list.


        assertEquals("Test tube hygiene", retrieve.get(0).getSubject());
        assertEquals(0, failed.size());

    }

    @Test
    public void findByDateTest() {

        LocalDate searchDate = LocalDate.parse("1138-09-15");
        LocalDate failDate = LocalDate.parse("2138-09-15");

        List<Lecture> retrieve = testDao.findByDate(searchDate);
        List<Lecture> failed = testDao.findByDate(failDate);

        assertEquals("Avoiding the Grandfather Paradox", retrieve.get(0).getSubject());
        assertEquals(0, failed.size());
    }


    @Test
    public void removeLectureTest() {

        Lecture retrieve = testDao.findById(4);

        boolean attemptOne = testDao.removeLecture(retrieve);    //We try to remove something that exists; should succeed.
        boolean attemptTwo = testDao.removeLecture(retrieve);    //We try to remove something that doesn't exist anymore; should fail.

        assertTrue(attemptOne);
        assertFalse(attemptTwo);

        Lecture failed = testDao.findById(4);    //Can we find the removed course? We should get a null object back.

        assertNull(failed);


    }


}
