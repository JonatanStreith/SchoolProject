package jonst.Dao;

import jonst.Models.Student;
import jonst.Models.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeacherDaoListTest {

    TeacherDaoList testDao;

    @Before
    public void setUp() throws Exception {

        testDao = new TeacherDaoList();


        List<Teacher> experimentalTeachers = new ArrayList() {{
            add(new Teacher("Donna Noble", "donna.noble@chiswick.gov", "The TARDIS"));
            add(new Teacher("Amy Pond", "raggedygirl127@hotmail.com", "The TARDIS"));
            add(new Teacher("Clara Oswald", "XximpossiblegirlxX@tardis.net", "The TARDIS"));
            add(new Teacher("Rose Tyler", "firstgirl@ccorp.gov", "The TARDIS"));
            add(new Teacher("Martha Jones", "MadMartha@UBT.edu", "The TARDIS"));

        }};

        for (Teacher teacher : experimentalTeachers) {            //Filling our courselist a little, just to have something to play with
            testDao.saveTeacher(teacher);
        }




    }

    @Test
    public void constructorTest() {

        assertNotNull(testDao);
    }

    @Test
    public void saveTeacherTest() {

        Teacher test = new Teacher("Barbara Wright", "b.wright@coalhill.edu", "Coal Hill");

        int before = testDao.getNumberOfTeachers();
        testDao.saveTeacher(test);
        int after = testDao.getNumberOfTeachers();


        assertEquals(after, before +1);
    }

    @Test
    public void findAllTest() {

        List<Teacher> buffer = testDao.findAll();

        for (Teacher teacher : buffer) {
            System.out.println("(" + teacher.getId() + ") " + teacher.getName() + "; e-mail: " + teacher.getEmail() + ", address: " + teacher.getAddress() + ".");
        }

        assertEquals(testDao.getNumberOfTeachers(), buffer.size());
    }

    @Test
    public void findByEmailTest() {

        Teacher retrieve = testDao.findByEmail("XximpossiblegirlxX@tardis.net");
        Teacher failed = testDao.findByEmail("SJSReporter@weeklynews.net");


        assertEquals("Clara Oswald", retrieve.getName());
        assertNull(failed);
    }

    @Test
    public void findByNameTest() {

        List<Teacher> retrieve = testDao.findByName("Donna Noble");    //For the sake of the argument, we expect at least one student by this name to exist.
        List<Teacher> failed = testDao.findByName("Sarah Jane Smith");     //This should give us an empty, zero-size list.


        assertEquals("Donna Noble", retrieve.get(0).getName());
        assertEquals(0, failed.size());
    }

    @Test
    public void findByIdTest() {

        Teacher retrieve = testDao.findById(3);
        Teacher failed = testDao.findById(999);


        assertEquals("Clara Oswald", retrieve.getName());
        assertNull(failed);
    }


    @Test
    public void deleteTeacherTest() {


        Teacher retrieve = testDao.findById(2);

        boolean attemptOne = testDao.deleteTeacher(retrieve);    //We try to remove something that exists; should succeed.
        boolean attemptTwo = testDao.deleteTeacher(retrieve);    //We try to remove something that doesn't exist anymore; should fail.

        assertTrue(attemptOne);
        assertFalse(attemptTwo);

        Teacher failed = testDao.findById(2);    //Can we find the removed course? We should get a null object back.

        assertNull(failed);
    }




}
