package jonst.Models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class LectureTest {

    Lecture testLecture;
    Course testCourse;
    Teacher testTeacher;

    @Before
    public void setUp() throws Exception {

        testLecture = new Lecture("Squaredancing", LocalDate.parse("1999-09-09"));
        testCourse = new Course("Dancing 201", LocalDate.parse("1999-09-02"), 5);
        testTeacher = new Teacher("Onizuka", "GTO478@tokyo.jp", "Yaburo");
    }

    @Test
    public void constructorTest() {

        assertNotNull(testLecture);
    }

    @Test
    public void gettersSettersTest() {
        int id = testLecture.getId();
        assertNotEquals(0, id);

        boolean success = testLecture.setSubject("Ring around the Rosie");
        String subject = testLecture.getSubject();
        assertTrue(success);
        assertEquals("Ring around the Rosie", subject);

        success = testLecture.setDate(LocalDate.parse("1129-09-09"));
        LocalDate date = testLecture.getDate();
        assertTrue(success);
        assertEquals(LocalDate.parse("1129-09-09"), date);

        boolean check = testLecture.isAssignedToCourse();   //This should be false because it's not assigned to a course
        assertFalse(check);
        success = testLecture.setAssignedTo(testCourse);
        assertTrue(success);
        check = testLecture.isAssignedToCourse();   //This shuld now be true
        assertTrue(check);

        assertNotNull(testLecture.getAssignedTo());

        success = testLecture.setAssignedToCourse(false);
        check = testLecture.isAssignedToCourse();
        assertTrue(success);
        assertFalse(check);


        testLecture.setAssignedTo(null);
        assertNull(testLecture.getAssignedTo());
    }


    @Test
    public void registerTeacherTest() {

        int before = testLecture.getTeachers().size();
        boolean success = testLecture.registerTeacher(testTeacher);
        int after = testLecture.getTeachers().size();

        assertTrue(success);
        assertTrue(after == before +1 );

        success = testLecture.unregisterTeacher(testTeacher);
        int end = testLecture.getTeachers().size();

        assertTrue(success);
        assertTrue(end == after -1 );
    }


    @Test
    public void lectureInfoTest() {

        String desc = testLecture.lectureInfo();
        String expected = "(1) Squaredancing; on date " + LocalDate.parse("1999-09-09") + ".";
        assertEquals(expected, desc);
    }

}
