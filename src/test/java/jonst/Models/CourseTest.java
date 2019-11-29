package jonst.Models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CourseTest {


    Course testCourse;

    @Before
    public void setUp() throws Exception {

        testCourse = new Course("Underwater basket weaving", LocalDate.parse("2020-04-11"), 4);
    }


    @Test
    public void constructorTest() {



        assertNotNull(testCourse);
        assertEquals("Underwater basket weaving", testCourse.getCourseName());
        assertEquals(LocalDate.parse("2020-04-11"), testCourse.getStartDate());
        assertEquals(4, testCourse.getWeekDuration());

    }


    @Test
    public void registerTest() {

        Student testStudent = new Student("Bosse", "bosse@hotmail.com", "Almgatan 4");

        assertTrue(testCourse.getStudents().size() == 0);   //Ensure that the student list is empty at the beginning.

        testCourse.register(testStudent);

        assertTrue(testCourse.getStudents().size() == 1);           //List size should now be 1.
        assertEquals("Bosse", testCourse.getStudents().get(0).getName());     //First entry should be "Bosse".

        testCourse.unregister(testStudent);

        assertTrue(testCourse.getStudents().size() == 0);   //Ensure that the student list is empty again.


    }
}
