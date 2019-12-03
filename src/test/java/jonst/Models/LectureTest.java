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
        assertEquals("Squaredancing", testLecture.getSubject());
        assertEquals(LocalDate.parse("1999-09-09"), testLecture.getDate());
        assertEquals(1, testLecture.getId());

    }

    @Test
    public void setAssignedToTest() {

        boolean beforecheck = testLecture.isAssignedToCourse();   //This should be false because it's not assigned to a course


        boolean success = testLecture.assign(testCourse);
        boolean aftercheck = testLecture.isAssignedToCourse();


        assertFalse(beforecheck);
        assertTrue(success);
        assertTrue(aftercheck);
        assertNotNull(testLecture.getAssignedTo());





        testLecture.assign(null);                   //We now unassign the lecture, i.e. sets it to a null course
        boolean theEnd = testLecture.isAssignedToCourse();

        assertNull(testLecture.getAssignedTo());
        assertFalse(theEnd);


    }


    @Test
    public void registerTeacherTest() {

        int before = testLecture.getTeachers().size();
        boolean success = testLecture.registerTeacher(testTeacher);
        int after = testLecture.getTeachers().size();

        assertTrue(success);
        assertTrue(after == before +1 );

        success = testLecture.unregisterTeacher(testTeacher);
        int theEnd = testLecture.getTeachers().size();

        assertTrue(success);
        assertTrue(theEnd == after -1 );
    }


    @Test
    public void lectureInfoTest() {

        String desc = testLecture.lectureInfo();
                assertNotEquals("", desc);
    }

}
