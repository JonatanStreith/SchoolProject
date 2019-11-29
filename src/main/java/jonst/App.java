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
        System.out.println(line);
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

        String name = getReply("Course name? ");
        LocalDate date = LocalDate.parse(getReply("Starting date? (YYYY-MM-DD) "));
        int weeks = Integer.parseInt(getReply("Number of weeks? "));

        Course newCourse = new Course(name, date, weeks);

        courseAccess.saveCourse(newCourse);

        System.out.println("Course by the name of \"" + name + "\" has been created in the system under Id " + newCourse.getId() + ".");

    }

    //--------------------------------------------------
    private static void registerStudent() {
        System.out.println("You have chosen to register a student.\n");

        Student student = retrieveStudent();
        Course course = retrieveCourse();

        if(student == null || course == null){
            System.out.println("Sorry, the student and/or course you have specified does not exist.");
        } else {
            course.register(student);
            System.out.println("Registration complete.");
        }

    }


    private static void unregisterStudent() {

        System.out.println("You have chosen to unregister a student.\n");

        Student student = retrieveStudent();
        Course course = retrieveCourse();

        if(student == null || course == null){
            System.out.println("Sorry, the student and/or course you have specified does not exist.");
        } else {
            course.unregister(student);
            System.out.println("Unregistration complete.");
        }
    }




    //--------------------------------------------------
    private static void findStudentByEmail() {
    }

    private static void findStudentById() {
    }

    private static void findStudentsByName() {
    }

    private static void findAllStudents() {
    }

    private static void findCourseById() {
    }

    private static void findCoursesByName() {
    }

    private static void findAllCourses() {
    }

    //--------------------------------------------------
    private static void changeStudentName() {
    }

    private static void changeStudentEmail() {
    }

    private static void changeStudentaddress() {
    }

    private static void changeCourseName() {
    }

    private static void changeCourseLength() {
    }

    private static void changeCourseDate() {
    }


}
