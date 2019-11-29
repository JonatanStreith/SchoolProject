package jonst.Dao;

import jonst.Models.Course;
import jonst.Models.Student;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoListTest {

    StudentDaoList testDao;

    @Before
    public void setUp() throws Exception {

        testDao = new StudentDaoList();


        List<Student> experimentalStudents = new ArrayList() {{
            add(new Student("Donna Noble", "donna.noble@chiswick.gov", "The TARDIS"));
            add(new Student("Amy Pond", "raggedygirl127@hotmail.com", "The TARDIS"));
            add(new Student("Clara Oswald", "XximpossiblegirlxX@tardis.net", "The TARDIS"));
            add(new Student("Rose Tyler", "firstgirl@ccorp.gov", "The TARDIS"));
            add(new Student("Martha Jones", "MadMartha@UBT.edu", "The TARDIS"));

        }};

        for (Student student : experimentalStudents) {            //Filling our courselist a little, just to have something to play with
            testDao.saveStudent(student);
        }




    }

    @Test
    public void constructorTest() {

        assertNotNull(testDao);
    }

    @Test
    public void saveStudentTest() {

        Student test = new Student("Barbara Wright", "b.wright@coalhill.edu", "Coal Hill");

        int before = testDao.getNumberOfStudents();
        testDao.saveStudent(test);
        int after = testDao.getNumberOfStudents();


        assertEquals(after, before +1);
    }

    @Test
    public void findAllTest() {

        List<Student> buffer = testDao.findAll();

        for (Student student : buffer) {
            System.out.println("(" + student.getId() + ") " + student.getName() + "; e-mail: " + student.getEmail() + ", address: " + student.getAddress() + ".");
        }

        assertEquals(testDao.getNumberOfStudents(), buffer.size());
    }

    @Test
    public void findByEmailTest() {

        Student retrieve = testDao.findByEmail("XximpossiblegirlxX@tardis.net");
        Student failed = testDao.findByEmail("SJSReporter@weeklynews.net");


        assertEquals("Clara Oswald", retrieve.getName());
        assertNull(failed);
    }

    @Test
    public void findByNameTest() {

        List<Student> retrieve = testDao.findByName("Donna Noble");    //For the sake of the argument, we expect at least one student by this name to exist.
        List<Student> failed = testDao.findByName("Sarah Jane Smith");     //This should give us an empty, zero-size list.


        assertEquals("Donna Noble", retrieve.get(0).getName());
        assertEquals(0, failed.size());
    }

    @Test
    public void findByIdTest() {

        Student retrieve = testDao.findById(3);
        Student failed = testDao.findById(999);


        assertEquals("Clara Oswald", retrieve.getName());
        assertNull(failed);
    }


    @Test
    public void deleteStudentTest() {


        Student retrieve = testDao.findById(2);

        boolean attemptOne = testDao.deleteStudent(retrieve);    //We try to remove something that exists; should succeed.
        boolean attemptTwo = testDao.deleteStudent(retrieve);    //We try to remove something that doesn't exist anymore; should fail.

        assertTrue(attemptOne);
        assertFalse(attemptTwo);

        Student failed = testDao.findById(2);    //Can we find the removed course? We should get a null object back.

        assertNull(failed);
    }




}
