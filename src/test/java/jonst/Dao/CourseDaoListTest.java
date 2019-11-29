package jonst.Dao;

import jonst.Models.Course;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseDaoListTest {

    CourseDaoList testDao;

    @Before
    public void setUp() throws Exception {

        testDao = new CourseDaoList();

        List<Course> experimentalCourses = new ArrayList() {{
            add(new Course("Quantum mechanics", LocalDate.parse("2020-03-01"), 5));
            add(new Course("Economics: Shop 'til you Drop", LocalDate.parse("2019-12-13"), 5));
            add(new Course("Socratic Philosophy", LocalDate.parse("2020-02-17"), 5));
            add(new Course("Blowing stuff up", LocalDate.parse("2020-05-21"), 5));
            add(new Course("The ethics of genetic engineering", LocalDate.parse("2019-12-07"), 5));
            add(new Course("The Fundamentals of Time Travel", LocalDate.parse("1138-09-15"), 5));
            add(new Course("Lunch", LocalDate.parse("2020-01-14"), 5));
        }};

        for (Course course : experimentalCourses) {            //Filling our courselist a little, just to have something to play with
            testDao.saveCourse(course);
        }



    }

    @Test
    public void constructorTest() {

        assertNotNull(testDao);
    }

    @Test
    public void saveCourseTest() {

        Course testCourse = new Course("Underwater basket weaving", LocalDate.parse("2020-04-11"), 4);

        int before = testDao.getNumberOfCourses();  //Count number of classes before, and after adding a course to the list.
        testDao.saveCourse(testCourse);
        int after = testDao.getNumberOfCourses();

        assertTrue(after == before + 1);         //Check that "after" is one higher than "before".

    }

    @Test
    public void findAllTest() {

        List<Course> buffer = testDao.findAll();

        for (Course course : buffer) {
            System.out.println("(" + course.getId() + ") " + course.getCourseName() + "; starts " + course.getStartDate() + ", duration: " + course.getWeekDuration() + " weeks.");
        }

        assertEquals(testDao.getNumberOfCourses(), buffer.size());      //Since the tests may add and remove courses, we can't assume too much about the contents.
        //We can, however, expect the established course count to match the number of courses in the "find all" list.
        //I.e. if we know there are five courses, we should get a list of five courses.
    }

    @Test
    public void findByIdTest() {

        Course retrieve = testDao.findById(1);
        Course failed = testDao.findById(999);

        assertEquals("Quantum mechanics", retrieve.getCourseName());
        assertNull(failed);
    }

    @Test
    public void findByNameTest() {

        List<Course> retrieve = testDao.findByName("Quantum Mechanics");    //For the sake of the argument, we expect at least one course by this name to exist.
        List<Course> failed = testDao.findByName("Nonexistent Course");     //This should give us an empty, zero-size list.


        assertEquals("Quantum mechanics", retrieve.get(0).getCourseName());
        assertEquals(0, failed.size());

    }

    @Test
    public void findByDateTest() {

        LocalDate searchDate = LocalDate.parse("1138-09-15");
        LocalDate failDate = LocalDate.parse("2138-09-15");

        List<Course> retrieve = testDao.findByDate(searchDate);
        List<Course> failed = testDao.findByDate(failDate);

        assertEquals("The Fundamentals of Time Travel", retrieve.get(0).getCourseName());
        assertEquals(0, failed.size());
    }


    @Test
    public void removeCourseTest() {

        Course retrieve = testDao.findById(4);

        boolean attemptOne = testDao.removeCourse(retrieve);    //We try to remove something that exists; should succeed.
        boolean attemptTwo = testDao.removeCourse(retrieve);    //We try to remove something that doesn't exist anymore; should fail.

        assertTrue(attemptOne);
        assertFalse(attemptTwo);

        Course failed = testDao.findById(4);    //Can we find the removed course? We should get a null object back.

        assertNull(failed);


    }


}
