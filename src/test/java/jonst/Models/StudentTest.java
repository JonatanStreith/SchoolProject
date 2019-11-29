package jonst.Models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StudentTest {

    Student testStudent;


    @Before
    public void setUp() throws Exception {
        testStudent = new Student("Bosse", "bosse@hotmail.com", "Almgatan 4");
    }






    @Test
    public void constructorTest() {



        assertNotNull(testStudent);
        assertEquals("Bosse", testStudent.getName());
        assertEquals("bosse@hotmail.com", testStudent.getEmail());
        assertEquals("Almgatan 4", testStudent.getAddress());

    }


    @Test
    public void setterGetterTest() {
        boolean success;

        int id = testStudent.getId();
        assertNotNull(id);

        String name = testStudent.getName();
        assertNotNull(name);

        String email = testStudent.getEmail();
        assertNotNull(email);

        String address = testStudent.getAddress();
        assertNotNull(email);

        success = testStudent.setName("George");
        assertTrue(success);

        success = testStudent.setEmail("dmz43@lunarstorm.net");
        assertTrue(success);

        success = testStudent.setAddress("Dark Fortress");
        assertTrue(success);

        String info = testStudent.studentInfo();
        assertNotEquals("", info);

    }
}
