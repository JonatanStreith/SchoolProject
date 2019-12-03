package jonst.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherTest {

    Teacher testTeacher;

    @Before
    public void setUp() throws Exception {
        testTeacher = new Teacher("Bosse", "bosse@hotmail.com", "Almgatan 4");
    }

    @Test
    public void constructorTest() {



        assertNotNull(testTeacher);
        assertEquals("Bosse", testTeacher.getName());
        assertEquals("bosse@hotmail.com", testTeacher.getEmail());
        assertEquals("Almgatan 4", testTeacher.getAddress());
        assertEquals(1, testTeacher.getId());
    }

    @Test
    public void getterSetterTest() {


        String info = testTeacher.teacherInfo();


        assertNotEquals("", info);
    }
}
