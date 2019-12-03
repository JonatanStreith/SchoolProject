package jonst;

import jonst.Dao.CourseDaoList;
import jonst.Dao.LectureDaoList;
import jonst.Dao.StudentDaoList;
import jonst.Dao.TeacherDaoList;
import jonst.Models.Course;
import jonst.Models.Lecture;
import jonst.Models.Student;
import jonst.Models.Teacher;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner inputReader = new Scanner(System.in);

    public static StudentDaoList studentAccess = new StudentDaoList();
    public static CourseDaoList courseAccess = new CourseDaoList();
    public static TeacherDaoList teacherAccess = new TeacherDaoList();
    public static LectureDaoList lectureAccess = new LectureDaoList();

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
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1: Create entities.");
            System.out.println("2: Registering.");
            System.out.println("3: Find information.");
            System.out.println("4: Edit records.");
            System.out.println("\nX: Exit program.\n");

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
                case "X":
                    System.out.println("Thank you for your patronage. Please come again!");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.\n");
                    break;
            }
        }
    }


    private static void createMenu() {
        //This is the create objects menu. You can create students and courses from here.

        boolean loop = true;

        while (loop) {
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1: Create new student.");
            System.out.println("2: Create new teacher.");
            System.out.println("3: Create new course.");
            System.out.println("4: Create new lecture.");
            System.out.println("\nX: Return to previous menu.\n");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    newStudent();
                    break;
                case "2":
                    newTeacher();
                    break;
                case "3":
                    newCourse();
                    break;
                case "4":
                    newLecture();
                    break;
                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.\n");
                    break;

            }


        }
    }


    private static void registerMenu() {

        //This is the registering menu. You can register and unregister students here.

        boolean loop = true;

        while (loop) {
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1: Register a student to a course.");
            System.out.println("2: Unregister a student from a course.");
            System.out.println("3: Assign a teacher as a course supervisor.");
            System.out.println("4: Unassign a course supervisor.");
            System.out.println("5: Register a teacher to a specific lecture.");
            System.out.println("6: Unregister a teacher from a specific lecture.");
            System.out.println("7: Assign a lecture to a specific course.");
            System.out.println("8: Unassign a lecture from a specific course.");


            System.out.println("\nX: Return to previous menu.\n");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    registerStudent();
                    break;
                case "2":
                    unregisterStudent();
                    break;
                case "3":
                    assignSupervisor();
                    break;
                case "4":
                    unassignSupervisor();
                    break;
                case "5":
                    registerLectureTeacher();
                    break;
                case "6":
                    unregisterLectureTeacher();
                    break;
                case "7":
                    registerLectureCourse();
                    break;
                case "8":
                    unregisterLectureCourse();
                    break;

                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.\n");
                    break;

            }


        }
    }


    private static void infomenu() {

        //This is the information menu. You can get info on students and courses here.

        boolean loop = true;

        while (loop) {
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1: Find a student through their e-mail.");
            System.out.println("2: Find a student through their Id.");
            System.out.println("3: Find all students by a given name. (Will return a list.)");
            System.out.println("4: List all students. (Will return a list. WARNING: May be long.)");
            System.out.println("");
            System.out.println("5: Find a teacher through their e-mail.");
            System.out.println("6: Find a teacher through their Id.");
            System.out.println("7: Find all teachers by a given name. (Will return a list.)");
            System.out.println("8: List all teachers. (Will return a list. WARNING: May be long.)");
            System.out.println("");
            System.out.println("9: Find a course through its Id.");
            System.out.println("10: Find all courses by a given name. (Will return a list.)");
            System.out.println("11: Find all courses by a given date. (Will return a list.)");
            System.out.println("12: List all courses. (Will return a list. WARNING: May be long.)");
            System.out.println("");
            System.out.println("13: Find a lecture through its Id.");
            System.out.println("14: Find all lectures by a given subject. (Will return a list.)");
            System.out.println("15: Find all lecture by a given date. (Will return a list.)");
            System.out.println("16: List all lectures. (Will return a list. WARNING: May be long.)");

            System.out.println("\nX: Return to previous menu.\n");

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
                    findTeacherByEmail();
                    break;
                case "6":
                    findTeacherById();

                    break;
                case "7":
                    findTeachersByName();
                    break;
                case "8":
                    findAllTeachers();
                    break;

                case "9":
                    findCourseById();
                    break;
                case "10":
                    findCoursesByName();
                    break;
                case "11":
                    findCoursesByDate();
                    break;
                case "12":
                    findAllCourses();
                    break;

                case "13":
                    findLectureById();
                    break;
                case "14":
                    findLecturesBySubject();
                    break;
                case "15":
                    findLecturesByDate();
                    break;
                case "16":
                    findAllLectures();
                    break;


                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.\n");
                    break;
            }
        }
    }

    private static void editMenu() {

        //This is the edit menu. You can edit the information in students and courses here.

        boolean loop = true;

        while (loop) {
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("(Ids cannot be changed for security reasons.)\n");

            System.out.println("1: Change student name.");
            System.out.println("2: Change student e-mail.");
            System.out.println("3: Change student address.");
            System.out.println("");
            System.out.println("4: Change teacher name.");
            System.out.println("5: Change teacher e-mail.");
            System.out.println("6: Change teacher address.");
            System.out.println("");
            System.out.println("7: Change course name.");
            System.out.println("8: Change course length (by weeks).");
            System.out.println("9: Change course starting date.");
            System.out.println("");
            System.out.println("10: Change lecture subject.");
            System.out.println("11: Change lecture date.");


            System.out.println("\nX: Return to previous menu.\n");

            String input = inputReader.nextLine().toUpperCase();

            switch (input) {
                case "1":
                    changeStudentName();
                    break;
                case "2":
                    changeStudentEmail();
                    break;
                case "3":
                    changeStudentAddress();
                    break;

                case "4":
                    changeTeacherName();
                    break;
                case "5":
                    changeTeacherEmail();
                    break;
                case "6":
                    changeTeacherAddress();
                    break;

                case "7":
                    changeCourseName();
                    break;
                case "8":
                    changeCourseLength();
                    break;
                case "9":
                    changeCourseDate();
                    break;

                case "10":
                    changeLectureSubject();
                    break;
                case "11":
                    changeLectureDate();
                    break;


                case "X":
                    System.out.println("Returning to previous menu.");
                    loop = false;
                    break;
                default:
                    System.out.println("That's not an option.\n");
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
            String reply = getReply("Student? ").toLowerCase();
            String[] replyArray;
            String method = "";
            String input = "";
            try {
                replyArray = reply.split(": ");
                method = replyArray[0];
                input = replyArray[1];
            } catch (Exception e) {
                System.out.println("I'm sorry, that's not correct syntax.");
                continue;
            }


            switch (method) {
                case "id":
                    return studentAccess.findById(Integer.parseInt(input));

                case "name":
                    List<Student> resultList = studentAccess.findByName(input);
                    if (resultList.size() > 0)
                        return resultList.get(0);                       //It will automatically return the first student found. Don't like it?
                    else                                                //Has multiple students by the same name and want to get someone else?
                        return null;                                    //Tough! Use Id like a grownup.

                case "e-mail":
                    return studentAccess.findByEmail(input);

                default:
                    System.out.println("I'm sorry, that's not an acceptable method of retrieval.");
                    break;
            }
        }
    }


    private static Teacher retrieveTeacher() {
        System.out.println("Please specify teacher, and prefix by method of finding them. (Example: Id: 1; Name: Bob Dylan; E-mail: bob@bob.com.");

        while (true) {
            String reply = getReply("Teacher? ").toLowerCase();
            String[] replyArray;
            String method = "";
            String input = "";
            try {
                replyArray = reply.split(": ");
                method = replyArray[0];
                input = replyArray[1];
            } catch (Exception e) {
                System.out.println("I'm sorry, that's not correct syntax.");
                continue;
            }


            switch (method) {
                case "id":
                    return teacherAccess.findById(Integer.parseInt(input));

                case "name":
                    List<Teacher> resultList = teacherAccess.findByName(input);
                    if (resultList.size() > 0)
                        return resultList.get(0);                       //It will automatically return the first teacher found. Don't like it?
                    else                                                //Has multiple teachers by the same name and want to get someone else?
                        return null;                                    //Tough! Use Id like a grownup.

                case "e-mail":
                    return teacherAccess.findByEmail(input);

                default:
                    System.out.println("I'm sorry, that's not an acceptable method of retrieval.");
                    break;
            }
        }
    }


    private static Course retrieveCourse() {
        System.out.println("Please specify course, and prefix by method of finding it. (Example: Id: 1; Name: Math 101; Date: 2020-01-01");

        while (true) {
            String reply = getReply("Course? ").toLowerCase();

            String[] replyArray;
            String method = "";
            String input = "";
            List<Course> resultList;

            try {
                replyArray = reply.split(": ");
                method = replyArray[0];
                input = replyArray[1];
            } catch (Exception e) {
                System.out.println("I'm sorry, that's not correct syntax.");
                continue;
            }

            switch (method) {
                case "id":
                    return courseAccess.findById(Integer.parseInt(input));

                case "name":
                    resultList = courseAccess.findByName(input);
                    if (resultList.size() > 0)
                        return resultList.get(0);
                    else
                        return null;

                case "date":
                    LocalDate date = null;

                    try {
                        date = LocalDate.parse(input);
                    } catch (Exception e) {
                        System.out.println("I'm sorry, that date was not typed correctly.");
                        break;
                    }
                    resultList = courseAccess.findByDate(date);
                    if (resultList.size() > 0)
                        return resultList.get(0);
                    else
                        return null;


                default:
                    System.out.println("I'm sorry, that's not an acceptable method of retrieval.");
                    break;
            }
        }
    }

    private static Lecture retrieveLecture() {
        System.out.println("Please specify lecture, and prefix by method of finding it. (Example: Id: 1; Subject: Exceptions; Date: 2020-01-01");

        while (true) {
            String reply = getReply("Lecture? ").toLowerCase();

            String[] replyArray;
            String method = "";
            String input = "";
            List<Lecture> resultList;

            try {
                replyArray = reply.split(": ");
                method = replyArray[0];
                input = replyArray[1];
            } catch (Exception e) {
                System.out.println("I'm sorry, that's not correct syntax.");
                continue;
            }

            switch (method) {
                case "id":
                    return lectureAccess.findById(Integer.parseInt(input));

                case "subject":
                    resultList = lectureAccess.findBySubject(input);
                    if (resultList.size() > 0)
                        return resultList.get(0);
                    else
                        return null;

                case "date":
                    LocalDate date = null;

                    try {
                        date = LocalDate.parse(input);
                    } catch (Exception e) {
                        System.out.println("I'm sorry, that date was not typed correctly.");
                        break;
                    }
                    resultList = lectureAccess.findByDate(date);
                    if (resultList.size() > 0)
                        return resultList.get(0);
                    else
                        return null;


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

    private static void newTeacher() {

        String name = getReply("Teacher's name? ");
        String email = getReply("Teacher's e-mail address? ");
        String address = getReply("Teacher's physical address? ");

        Teacher newTeacher = new Teacher(name, email, address);

        teacherAccess.saveTeacher(newTeacher);

        System.out.println("Teacher by the name of \"" + name + "\" has been created in the system under Id " + newTeacher.getId() + ".");

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
        } catch (Exception e) {
            legitDate = false;
            System.out.println("Starting date not accepted. Please follow specified standard.");
        }

        if (legitDate) {
            Course newCourse = new Course(name, date, weeks);

            courseAccess.saveCourse(newCourse);

            System.out.println("Course by the name of \"" + name + "\" has been created in the system under Id " + newCourse.getId() + ".");
        }
    }

    private static void newLecture() {

        boolean legitDate = true;
        String subject = "";
        LocalDate date = null;

        try {
            subject = getReply("Lecture subject? ");
            date = LocalDate.parse(getReply("Date? (YYYY-MM-DD) "));

        } catch (Exception e) {
            legitDate = false;
            System.out.println("Starting date not accepted. Please follow specified standard.");
        }

        if (legitDate) {
            Lecture newLecture = new Lecture(subject, date);

            lectureAccess.saveLecture(newLecture);

            System.out.println("Lecture by the subject of \"" + subject + "\" has been created in the system under Id " + newLecture.getId() + ".");
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
            System.out.println("Registration of student '"+student.getName()+"' to course '"+course.getCourseName()+"' complete.");
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
            System.out.println("Unregistration of student '"+student.getName()+"' from course '"+course.getCourseName()+"' complete.");
        }
    }


    private static void assignSupervisor() {

        System.out.println("You have chosen to assign a supervisor.\n");

        Teacher supervisor = retrieveTeacher();
        Course course = retrieveCourse();

        if (supervisor == null || course == null) {
            System.out.println("I'm sorry, the teacher and/or course you have specified does not exist.");
        } else {
            course.assignSupervisor(supervisor);
            System.out.println("Supervisor '"+supervisor.getName()+"' assigned to course '"+course.getCourseName()+"'.");
        }

    }


    private static void unassignSupervisor() {

        System.out.println("You have chosen to unassign a supervisor.\n");

        Course course = retrieveCourse();

        if (course == null) {
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else {
            course.unassignSupervisor();
            System.out.println("Supervisor unassigned from course '" + course.getCourseName() + "'. The course is now unsupervised; please assign a new supervisor as soon as possible.");
        }

    }

    private static void registerLectureTeacher() {

        System.out.println("You have chosen to register a teacher to a lecture.\n");

        Lecture lecture = retrieveLecture();
        Teacher teacher = retrieveTeacher();

        if (lecture == null || teacher == null) {
            System.out.println("I'm sorry, the lecture and/or teacher you have specified does not exist.");
        } else {
            lecture.registerTeacher(teacher);
            System.out.println("Teacher '" +teacher.getName() + "' registered to lecture '"+lecture.getSubject() + "'.");
        }

    }


    private static void unregisterLectureTeacher() {

        System.out.println("You have chosen to unregister a teacher to a lecture.\n");

        Lecture lecture = retrieveLecture();
        Teacher teacher = retrieveTeacher();

        if (lecture == null || teacher == null) {
            System.out.println("I'm sorry, the lecture and/or teacher you have specified does not exist.");
        } else {
            lecture.unregisterTeacher(teacher);
            System.out.println("Teacher '" +teacher.getName() + "' unregistered from lecture '"+lecture.getSubject() + "'.");
        }

    }

    private static void registerLectureCourse() {

        System.out.println("You have chosen to register a lecture to a course.\n");

        Lecture lecture = retrieveLecture();
        Course course = retrieveCourse();

        if (lecture == null || course == null) {
            System.out.println("I'm sorry, the lecture and/or teacher you have specified does not exist.");
        } else if (lecture.isAssignedToCourse()) {
            System.out.println("I'm sorry, the lecture you have chosen is already assigned to a course.");
        } else {
            course.addLecture(lecture);
            System.out.println("Lecture '" + lecture.getSubject() + "' registered to course '" + course.getCourseName() + "'.");
        }
    }

    private static void unregisterLectureCourse() {

        System.out.println("You have chosen to unregister a lecture from a course.\n");

        Lecture lecture = retrieveLecture();
        Course course = retrieveCourse();

        if (lecture == null || course == null) {
            System.out.println("I'm sorry, the lecture and/or teacher you have specified does not exist.");
        } else if (!lecture.isAssignedToCourse()) {
            System.out.println("I'm sorry, the lecture you have chosen is already unregistered.");
        } else if (lecture.getAssignedTo() != course) {
            System.out.println("I'm sorry, the lecture you have chosen isn't registered to the course you have chosen.");
        } else {
            course.removeLecture(lecture);
            System.out.println("Lecture '" + lecture.getSubject() + "' unregistered from course '" + course.getCourseName() + "'.");
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


    private static void findTeacherByEmail() {

        System.out.println("You have chosen to find a teacher by e-mail.\n");

        String reply = getReply("Please input e-mail address: ");
        Teacher teacher = teacherAccess.findByEmail(reply);
        if (teacher == null) {
            System.out.println("I'm sorry, the teacher you have specified does not exist.");
        } else {
            System.out.println(teacher.teacherInfo());
        }


    }

    private static void findTeacherById() {
        System.out.println("You have chosen to find a teacher by Id.\n");

        String reply = getReply("Please input Id: ");
        Teacher teacher = teacherAccess.findById(Integer.parseInt(reply));
        if (teacher == null) {
            System.out.println("I'm sorry, the teacher you have specified does not exist.");
        } else {
            System.out.println(teacher.teacherInfo());
        }

    }

    private static void findTeachersByName() {
        System.out.println("You have chosen to find one or more teachers by name.\n");

        String reply = getReply("Please input name: ");
        List<Teacher> teachers = teacherAccess.findByName(reply);
        if (teachers.size() <= 0) {
            System.out.println("I'm sorry, the teacher you have specified does not exist.");
        } else {
            for (Teacher teacher : teachers) {
                System.out.println(teacher.teacherInfo());
            }

        }
    }

    private static void findAllTeachers() {
        System.out.println("You have chosen to list all teachers.\n");

        List<Teacher> teachers = teacherAccess.findAll();
        if (teachers.size() <= 0) {
            System.out.println("There are no teachers in the system currently.");
        } else {
            for (Teacher teacher : teachers) {
                System.out.println(teacher.teacherInfo());
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

    private static void findCoursesByDate() {
        System.out.println("You have chosen to find one or more courses by date.\n");

        String reply = getReply("Please input date(YYYY-MM-DD): ");
        LocalDate date = null;
        boolean legitDate = true;

        try {
            date = LocalDate.parse(reply);
        } catch (Exception e) {
            System.out.println("I'm sorry, that date was not typed correctly.");
            legitDate = false;
        }

        if (legitDate) {
            List<Course> courses = courseAccess.findByDate(date);
            if (courses.size() <= 0) {
                System.out.println("I'm sorry, the course you have specified does not exist.");
            } else {
                for (Course course : courses) {
                    System.out.println(course.courseInfo());
                }
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




    private static void findLectureById() {
        System.out.println("You have chosen to find a lecture by Id.\n");

        String reply = getReply("Please input Id: ");
        Lecture lecture = lectureAccess.findById(Integer.parseInt(reply));
        if (lecture == null) {
            System.out.println("I'm sorry, the lecture you have specified does not exist.");
        } else {
            System.out.println(lecture.lectureInfo());
        }
    }

    private static void findLecturesBySubject() {
        System.out.println("You have chosen to find one or more courses by subject.\n");

        String reply = getReply("Please input name: ");
        List<Lecture> lectures = lectureAccess.findBySubject(reply);
        if (lectures.size() <= 0) {
            System.out.println("I'm sorry, the lecture you have specified does not exist.");
        } else {
            for (Lecture lecture : lectures) {
                System.out.println(lecture.lectureInfo());
            }

        }
    }

    private static void findLecturesByDate() {
        System.out.println("You have chosen to find one or more lectures by date.\n");

        String reply = getReply("Please input date(YYYY-MM-DD): ");
        LocalDate date = null;
        boolean legitDate = true;

        try {
            date = LocalDate.parse(reply);
        } catch (Exception e) {
            System.out.println("I'm sorry, that date was not typed correctly.");
            legitDate = false;
        }

        if (legitDate) {
            List<Lecture> lectures = lectureAccess.findByDate(date);
            if (lectures.size() <= 0) {
                System.out.println("I'm sorry, the lecture you have specified does not exist.");
            } else {
                for (Lecture lecture : lectures) {
                    System.out.println(lecture.lectureInfo());
                }
            }
        }
    }

    private static void findAllLectures() {
        System.out.println("You have chosen to list all lectures.\n");

        List<Lecture> lectures = lectureAccess.findAll();
        if (lectures.size() <= 0) {
            System.out.println("There are no lectures in the system currently.");
        } else {
            for (Lecture lecture : lectures) {
                System.out.println(lecture.lectureInfo());
            }

        }
    }


    //--------------------------------------------------
    private static void changeStudentName() {
        System.out.println("You have chosen to change a student's name.\n");
        Student student = retrieveStudent();

        if (student == null) {
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else {
            String currentName = student.getName();
            System.out.println("The student's current name is " + currentName + ".");
            String newName = getReply("Please input a new name. ");

            student.setName(newName);
            System.out.println("New name set.");
        }
    }

    private static void changeStudentEmail() {
        System.out.println("You have chosen to change a student's e-mail address.\n");
        Student student = retrieveStudent();

        if (student == null) {
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else {
            String currentEmail = student.getEmail();
            System.out.println("The student's current e-mail address is " + currentEmail + ".");
            String newEmail = getReply("Please input a new e-mail address. ");

            student.setEmail(newEmail);
            System.out.println("New e-mail address set.");
        }
    }

    private static void changeStudentAddress() {
        System.out.println("You have chosen to change a student's address.\n");

        Student student = retrieveStudent();

        if (student == null) {
            System.out.println("I'm sorry, the student you have specified does not exist.");
        } else {
            String currentAddress = student.getAddress();
            System.out.println("The student's current address is " + currentAddress + ".");
            String newAddress = getReply("Please input a new address. ");

            student.setAddress(newAddress);
            System.out.println("New address set.");
        }
    }


    private static void changeTeacherName() {
        System.out.println("You have chosen to change a teacher's name.\n");
        Teacher teacher = retrieveTeacher();

        if (teacher == null) {
            System.out.println("I'm sorry, the teacher you have specified does not exist.");
        } else {
            String currentName = teacher.getName();
            System.out.println("The teacher's current name is " + currentName + ".");
            String newName = getReply("Please input a new name. ");

            teacher.setName(newName);
            System.out.println("New name set.");
        }
    }

    private static void changeTeacherEmail() {
        System.out.println("You have chosen to change a teacher's e-mail address.\n");
        Teacher teacher = retrieveTeacher();

        if (teacher == null) {
            System.out.println("I'm sorry, the teacher you have specified does not exist.");
        } else {
            String currentEmail = teacher.getEmail();
            System.out.println("The teacher's current e-mail address is " + currentEmail + ".");
            String newEmail = getReply("Please input a new e-mail address. ");

            teacher.setEmail(newEmail);
            System.out.println("New e-mail address set.");
        }
    }

    private static void changeTeacherAddress() {
        System.out.println("You have chosen to change a teacher's address.\n");

        Teacher teacher = retrieveTeacher();

        if (teacher == null) {
            System.out.println("I'm sorry, the teacher you have specified does not exist.");
        } else {
            String currentAddress = teacher.getAddress();
            System.out.println("The teacher's current address is " + currentAddress + ".");
            String newAddress = getReply("Please input a new address. ");

            teacher.setAddress(newAddress);
            System.out.println("New address set.");
        }
    }




    private static void changeCourseName() {
        System.out.println("You have chosen to change a course's name.\n");
        Course course = retrieveCourse();

        if (course == null) {
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else {
            String currentName = course.getCourseName();
            System.out.println("The course's current name is " + currentName + ".");
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

        if (course == null) {
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else {
            int currentLength = course.getWeekDuration();
            System.out.println("The course's current duration is " + currentLength + " weeks.");

            try {
                newLength = Integer.parseInt(getReply("Please input a new duration in weeks. (Numbers only.) "));
            } catch (Exception e) {
                legitValue = false;
                System.out.println("I'm sorry, course duration needs to be a number.");
            }

            if (legitValue) {
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

        if (course == null) {
            System.out.println("I'm sorry, the course you have specified does not exist.");
        } else {
            LocalDate currentDate = course.getStartDate();
            System.out.println("The course's current starting date is " + currentDate + ".");

            try {
                newDate = LocalDate.parse(getReply("Please input a new starting date (YYYY-MM-DD). "));
            } catch (Exception e) {
                legitValue = false;
                System.out.println("New starting date not accepted. Please follow specified standard.");
            }

            if (legitValue) {
                course.setStartDate(newDate);
                System.out.println("New starting date set.");
            }
        }
    }

    private static void changeLectureSubject() {
        System.out.println("You have chosen to change a lecture's subject.\n");
        Lecture lecture = retrieveLecture();

        if (lecture == null) {
            System.out.println("I'm sorry, the lecture you have specified does not exist.");
        } else {
            String currentSubject = lecture.getSubject();
            System.out.println("The lecture's current subject is " + currentSubject + ".");
            String newSubject = getReply("Please input a new subject. ");

            lecture.setSubject(newSubject);
            System.out.println("New subject set.");
        }
    }

    private static void changeLectureDate() {
        System.out.println("You have chosen to set a different  date for a lecture.\n");
        Lecture lecture = retrieveLecture();

        LocalDate newDate = null;
        boolean legitValue = true;

        if (lecture == null) {
            System.out.println("I'm sorry, the lecture you have specified does not exist.");
        } else {
            LocalDate currentDate = lecture.getDate();
            System.out.println("The lecture's current  date is " + currentDate + ".");

            try {
                newDate = LocalDate.parse(getReply("Please input a new date (YYYY-MM-DD). "));
            } catch (Exception e) {
                legitValue = false;
                System.out.println("New date not accepted. Please follow specified standard.");
            }

            if (legitValue) {
                lecture.setDate(newDate);
                System.out.println("New date set.");
            }
        }
    }
}
