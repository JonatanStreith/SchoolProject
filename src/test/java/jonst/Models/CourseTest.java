package jonst.Models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class CourseTest {


    Course testCourse;
    Student testStudent;
    Lecture testLecture;
    Teacher testTeacher;

    @Before
    public void setUp() throws Exception {

        testCourse = new Course("Underwater basket weaving", LocalDate.parse("2020-04-11"), 4);
        testStudent = new Student("Bosse", "bosse@hotmail.com", "Almgatan 4");
        testLecture = new Lecture("Squaredancing", LocalDate.parse("1999-09-09"));
        testTeacher = new Teacher("Clara Oswald", "XximpossiblegirlxX@tardis.net", "The TARDIS");

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



        assertTrue(testCourse.getStudents().size() == 0);   //Ensure that the student list is empty at the beginning.

        testCourse.register(testStudent);


        assertTrue(testCourse.getStudents().size() == 1);           //List size should now be 1.
        assertEquals("Bosse", testCourse.getStudents().get(0).getName());     //First entry should be "Bosse".

        assertTrue(testStudent.getCourseList().contains(testCourse));   //Check that the student now has the course in their list

        testCourse.unregister(testStudent);

        assertTrue(testCourse.getStudents().size() == 0);   //Ensure that the student list is empty again.
        assertFalse(testStudent.getCourseList().contains(testCourse));

    }

    @Test
    public void supervisorTest() {
        boolean success = testCourse.assignSupervisor(testTeacher);

        assertTrue(success);
        assertNotNull(testCourse.getSupervisor());
        assertEquals("Clara Oswald", testCourse.getSupervisor().getName());

        success = testCourse.unassignSupervisor();
        assertTrue(success);
        assertNull(testCourse.getSupervisor());

    }

    @Test
    public void addLectureTest() {
        int before = testCourse.getLectures().size();
        boolean success = testCourse.addLecture(testLecture);
        int after = testCourse.getLectures().size();

        assertTrue(success);
        assertTrue(after == before +1);

        success = testCourse.removeLecture(testLecture);
        int end = testCourse.getLectures().size();

        assertTrue(success);
        assertTrue(end == after -1);

        success = testCourse.removeLecture(testLecture);
        assertFalse(success);

    }

    @Test
    public void getterSetterTest() {
        boolean success;
        int id = testCourse.getId();
        assertNotNull(id);

        String courseName = testCourse.getCourseName();
        assertNotNull(courseName);

        LocalDate startDate = testCourse.getStartDate();
        assertNotNull(startDate);

        int weekDuration = testCourse.getWeekDuration();
        assertNotNull(weekDuration);

        testCourse.register(testStudent);
        List<Student> students = testCourse.getStudents();
        assertNotNull(students);
        assertEquals(1, students.size());

        String output = testCourse.courseInfo();
        assertNotEquals("", output);



        success = testCourse.setCourseName("Falling with style");
        assertTrue(success);

        success = testCourse.setStartDate(LocalDate.parse("2020-10-10"));
        assertTrue(success);

        success = testCourse.setWeekDuration(Integer.parseInt("20"));
        assertTrue(success);


    }
}
