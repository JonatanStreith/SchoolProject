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
        System.out.println("Done");
        assertEquals(1, testStudent.getId());
    }


    @Test
    public void studentInfoTest() {


        String info = testStudent.studentInfo();

         assertNotEquals("", info);

    }
}
