package jonst;

import jonst.Dao.CourseDaoList;
import jonst.Dao.StudentDaoList;
import jonst.Models.Course;
import jonst.Models.Student;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner inputReader = new Scanner(System.in);

    public static StudentDaoList studentAccess = new StudentDaoList();
    public static CourseDaoList courseAccess = new CourseDaoList();

    public static void main(String[] args) {
        System.out.println("Welcome, school administrator!");

        mainMenu();
    }


    //----------------------- Menus are here -------------------------------

    public static void mainMenu() {

        //This is the main menu, which shows at the start. You can navigate into different menus by picking a choice.
        //Other menus follow similar design.

        boolean loop = true;

        while (loop) {

            System.out.println("What would you like to do?\n");
            System.out.println("1: Create entities.");
            System.out.println("2: Registering.");
            System.out.println("3: Find information.");
            System.out.println("4: Edit records.");
            System.out.println("X: Exit program.");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    createMenu();
                    break;
                case "2":
                    registerMenu();
                    break;
                case "3":
                    infomenu();
                    break;
                case "4":
                    editMenu();
                    break;
                case "x":
                    System.out.println("Thank you for your patronage. Please come again!");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.");
                    break;
            }
        }
    }


    private static void createMenu() {
        //This is the create objects menu. You can create students and courses from here.

        boolean loop = true;

        while (loop) {

            System.out.println("What would you like to create into the system?\n");
            System.out.println("1: Create new student.");
            System.out.println("2: Create new course.");
            System.out.println("X: Return to previous menu.");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    newStudent();
                    break;
                case "2":
                    newCourse();
                    break;
//                case "3":
//                    infomenu();
//                    break;
//                case "4":
//                    editMenu();
//                    break;
                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.");
                    break;

            }


        }
    }


    private static void registerMenu() {

        //This is the registering menu. You can register and unregister students here.

        boolean loop = true;

        while (loop) {

            System.out.println("What would you like to do?\n");
            System.out.println("1: Register a student to a course.");
            System.out.println("2: Unregister a student from a course.");
            System.out.println("X: Return to previous menu.");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    registerStudent();
                    break;
                case "2":
                    unregisterStudent();
                    break;
//                case "3":
//                    infomenu();
//                    break;
//                case "4":
//                    editMenu();
//                    break;
                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.");
                    break;

            }


        }
    }


    private static void infomenu() {

        //This is the information menu. You can get info on students and courses here.

        boolean loop = true;

        while (loop) {

            System.out.println("What would you like to do?\n");
            System.out.println("1: Find a student through their e-mail.");
            System.out.println("2: Find a student through their Id.");
            System.out.println("3: Find all students by a given name. (Will return a list.)");
            System.out.println("4: List all students. (Will return a list. WARNING: May be long.)");
            System.out.println("");
            System.out.println("5: Find a course through its Id.");
            System.out.println("6: Find all courses by a given name. (Will return a list.)");
            System.out.println("7: List all courses. (Will return a list. WARNING: May be long.)");

            System.out.println("X: Return to previous menu.");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    findStudentByEmail();
                    break;
                case "2":
                    findStudentById();
                    break;
                case "3":
                    findStudentsByName();
                    break;
                case "4":
                    findAllStudents();
                    break;
                case "5":
                    findCourseById();
                    break;
                case "6":
                    findCoursesByName();
                    break;
                case "7":
                    findAllCourses();
                    break;

                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.");
                    break;
            }
        }
    }

    private static void editMenu() {

        //This is the edit menu. You can edit the information in students and courses here.

        boolean loop = true;

        while (loop) {

            System.out.println("What would you like to do?\n");
            System.out.println("(Ids cannot be changed for security reasons.)\n");

            System.out.println("1: Change student name.");
            System.out.println("2: Change student e-mail.");
            System.out.println("3: Change student address.");
            System.out.println("");
            System.out.println("4: Change course name.");
            System.out.println("5: Change course length (by weeks).");
            System.out.println("6: Change course starting date.");


            System.out.println("X: Return to previous menu.");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    changeStudentName();
                    break;
                case "2":
                    changeStudentEmail();
                    break;
                case "3":
                    changeStudentaddress();
                    break;
                case "4":
                    changeCourseName();
                    break;
                case "5":
                    changeCourseLength();
                    break;
                case "6":
                    changeCourseDate();
                    break;

                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.");
                    break;
            }
        }
    }

    //----------- Helping methods --------------------------

    public static String getReply(String line) {
        System.out.print(line);
        String reply = inputReader.nextLine();
        return reply;
    }

    private static Student retrieveStudent() {
        System.out.println("Please specify student, and prefix by method of finding them. (Example: Id: 1; Name: Bob Dylan; E-mail: bob@bob.com.");

        while (true) {
            String reply = getReply("Student? ");

            String[] replyArray = reply.split(": ");
            String method = replyArray[0];
            String input = replyArray[1];

            switch (method) {
                case "Id":
                    return studentAccess.findById(Integer.parseInt(input));

                case "Name":
                    List<Student> resultList = studentAccess.findByName(input);
                    if (resultList.size() > 0)
                        return resultList.get(0);                       //It will automatically return the first student found. Don't like it?
                    else                                                //Has multiple students by the same name and want to get someone else?
                        return null;                                    //Tough! Use Id like a grownup.

                case "E-mail":
                    return studentAccess.findByEmail(input);

                default:
                    System.out.println("I'm sorry, that's not an acceptable method of retrieval.");
                    break;
            }
        }
    }

    private static Course retrieveCourse() {
        System.out.println("Please specify course, and prefix by method of finding it. (Example: Id: 1; Name: Math 101.");

        while (true) {
            String reply = getReply("Course? ");

            String[] replyArray = reply.split(": ");
            String method = replyArray[0];
            String input = replyArray[1];

            switch (method) {
                case "Id":
                    return courseAccess.findById(Integer.parseInt(input));

                case "Name":
                    List<Course> resultList = courseAccess.findByName(input);
                    if (resultList.size() > 0)
                        return resultList.get(0);                       //It will automatically return the first course found. Don't like it?
                    else                                                //Has multiple courses by the same name and want to get someone else?
                        return null;                                    //Tough! Use Id like a grownup.


                default:
                    System.out.println("I'm sorry, that's not an acceptable method of retrieval.");
                    break;
            }
        }
    }


    //------------------- Here are the specific methods ----------------------------

    private static void newStudent() {
        String name = getReply("Student's name? ");
        String email = getReply("Student's e-mail address? ");
        String address = getReply("Student's physical address? ");

        Student newStudent = new Student(name, email, address);

        studentAccess.saveStudent(newStudent);

        System.out.println("Student by the name of \"" + name + "\" has been created in the system under Id " + newStudent.getId() + ".");

    }

    private static void newCourse() {

        boolean legitDate = true;
        String name = "";
        LocalDate date = null;
        int weeks = 0;

        try {
            name = getReply("Course name? ");
            date = LocalDate.parse(getReply("Starting date? (YYYY-MM-DD) "));
            weeks = Integer.parseInt(getReply("Number of weeks? "));
        } catch(Exception e) {
            legitDate = false;
            System.out.println("Starting date not accepted. Please follow specified standard.");
        }

        if(legitDate) {
            Course newCourse = new Course(name, date, weeks);

            courseAccess.saveCourse(newCourse);

            System.out.println("Course by the name of \"" + name + "\" has been created in the system under Id " + newCourse.getId() + ".");
        }
    }

    //--------------------------------------------------
    private static void registerStudent() {
        System.out.println("You have chosen to register a student.\n");

        Student student = retrieveStudent();
        Course course = retrieveCourse();

        if (student == null || course == null) {
            System.out.println("I'm sorry, the student and/or course you have specified does not exist.");
        } else {
            course.register(student);
            System.out.println("Registration complete.");
        }

    }


    private static void unregisterStudent() {

        System.out.println("You have chosen to unregister a student.\n");

        Student student = retrieveStudent();
        Course course = retrieveCourse();

        if (student == null || course == null) {
            System.out.println("I'm sorry, the student and/or course you have specified does not exist.");
        } else {
            course.unregister(student);
            System.out.println("Unregistration complete.");
        }
    }


    //--------------------------------------------------
    private static void findStudentByEmail() {

        System.out.println("You have chosen to find a student by e-mail.\n");

        String reply = getReply("Please input e-mail address: ");
        Student student = studentAccess.findByEmail(reply);
        if (student == null) {
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else {
            System.out.println(student.studentInfo());
        }


    }

    private static void findStudentById() {
        System.out.println("You have chosen to find a student by Id.\n");

        String reply = getReply("Please input Id: ");
        Student student = studentAccess.findById(Integer.parseInt(reply));
        if (student == null) {
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else {
            System.out.println(student.studentInfo());
        }

    }

    private static void findStudentsByName() {
        System.out.println("You have chosen to find one or more students by name.\n");

        String reply = getReply("Please input name: ");
        List<Student> students = studentAccess.findByName(reply);
        if (students.size() <= 0) {
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else {
            for (Student student : students) {
                System.out.println(student.studentInfo());
            }

        }
    }

    private static void findAllStudents() {
        System.out.println("You have chosen to list all students.\n");

        List<Student> students = studentAccess.findAll();
        if (students.size() <= 0) {
            System.out.println("There are no students in the system currently.");
        } else {
            for (Student student : students) {
                System.out.println(student.studentInfo());
            }

        }
    }

    private static void findCourseById() {
        System.out.println("You have chosen to find a course by Id.\n");

        String reply = getReply("Please input Id: ");
        Course course = courseAccess.findById(Integer.parseInt(reply));
        if (course == null) {
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else {
            System.out.println(course.courseInfo());
        }
    }

    private static void findCoursesByName() {
        System.out.println("You have chosen to find one or more courses by name.\n");

        String reply = getReply("Please input name: ");
        List<Course> courses = courseAccess.findByName(reply);
        if (courses.size() <= 0) {
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else {
            for (Course course : courses) {
                System.out.println(course.courseInfo());
            }

        }
    }

    private static void findAllCourses() {
        System.out.println("You have chosen to list all courses.\n");

        List<Course> courses = courseAccess.findAll();
        if (courses.size() <= 0) {
            System.out.println("There are no courses in the system currently.");
        } else {
            for (Course course : courses) {
                System.out.println(course.courseInfo());
            }

        }
    }

    //--------------------------------------------------
    private static void changeStudentName() {
        System.out.println("You have chosen to change a student's name.\n");
        Student student = retrieveStudent();

        if(student==null){
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else{
            String currentName = student.getName();
            System.out.println("The student's current name is "+ currentName + ".");
            String newName = getReply("Please input a new name. ");

            student.setName(newName);
            System.out.println("New name set.");
        }
    }

    private static void changeStudentEmail() {
        System.out.println("You have chosen to change a student's e-mail address.\n");
        Student student = retrieveStudent();

        if(student==null){
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else{
            String currentEmail = student.getEmail();
            System.out.println("The student's current e-mail address is "+ currentEmail + ".");
            String newEmail = getReply("Please input a new e-mail address. ");

            student.setEmail(newEmail);
            System.out.println("New e-mail address set.");
        }
    }

    private static void changeStudentaddress() {
        System.out.println("You have chosen to change a student's address.\n");

        Student student = retrieveStudent();

        if(student==null){
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else{
            String currentAddress = student.getAddress();
            System.out.println("The student's current address is "+ currentAddress + ".");
            String newAddress = getReply("Please input a new address. ");

            student.setAddress(newAddress);
            System.out.println("New address set.");
        }
    }

    private static void changeCourseName() {
        System.out.println("You have chosen to change a course's name.\n");
        Course course = retrieveCourse();

        if(course==null){
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else{
            String currentName = course.getCourseName();
            System.out.println("The course's current name is "+ currentName + ".");
            String newName = getReply("Please input a new name. ");

            course.setCourseName(newName);
            System.out.println("New name set.");
        }
    }

    private static void changeCourseLength() {
        System.out.println("You have chosen to change a course's duration.\n");
        Course course = retrieveCourse();

        int newLength = 0;
        boolean legitValue = true;

        if(course==null){
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else{
            int currentLength = course.getWeekDuration();
            System.out.println("The course's current duration is "+ currentLength + " weeks.");

            try {
                newLength = Integer.parseInt(getReply("Please input a new duration in weeks. (Numbers only.) "));
            } catch(Exception e) {
                legitValue = false;
                System.out.println("I'm sorry, course duration needs to be a number.");
            }

            if(legitValue) {
                course.setWeekDuration(newLength);
                System.out.println("New duration set.");
            }
        }
    }

    private static void changeCourseDate() {
        System.out.println("You have chosen to set a different starting date for a course.\n");
        Course course = retrieveCourse();

        LocalDate newDate = null;
        boolean legitValue = true;

        if(course==null){
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else{
            LocalDate currentDate = course.getStartDate();
            System.out.println("The course's current starting date is "+ currentDate + ".");

            try {
                newDate = LocalDate.parse(getReply("Please input a new starting date. (YYYY-MM-DD) "));
            } catch(Exception e) {
                legitValue = false;
                System.out.println("New starting date not accepted. Please follow specified standard.");
            }

            if(legitValue) {
                course.setStartDate(newDate);
                System.out.println("New starting date set.");
            }
        }
    }


}
