public class TestMain {
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        testUserCreation();
        testCourseCreation();
        testRegistration();
        testDropRegistration();
        testCourseCapacity();
        testRegistrationSystem();

        System.out.println("\n=== Test Results ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        if (failed > 0) System.exit(1);
    }

    static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            passed++;
        } else {
            System.out.println("[FAIL] " + testName);
            failed++;
        }
    }

    static void testUserCreation() {
        User user = new User(1, "Alice", "alice@example.com");
        assertTrue("User ID set correctly", user.getUserId() == 1);
        assertTrue("User name set correctly", user.getName().equals("Alice"));
        assertTrue("User email set correctly", user.getEmail().equals("alice@example.com"));
    }

    static void testCourseCreation() {
        Course course = new Course(101, "Data Structures", "Prof. Smith", 30);
        assertTrue("Course ID set correctly", course.getCourseId() == 101);
        assertTrue("Course name set correctly", course.getCourseName().equals("Data Structures"));
        assertTrue("Course instructor set correctly", course.getInstructor().equals("Prof. Smith"));
        assertTrue("Course max capacity set correctly", course.getMaxCapacity() == 30);
        assertTrue("Course initially not full", !course.isFull());
    }

    static void testRegistration() {
        User user = new User(2, "Bob", "bob@example.com");
        Course course = new Course(102, "Algorithms", "Prof. Jones", 25);
        Registration reg = new Registration(user, course);
        assertTrue("Registration user correct", reg.getUser().getName().equals("Bob"));
        assertTrue("Registration course correct", reg.getCourse().getCourseName().equals("Algorithms"));
        assertTrue("Registration status is ACTIVE", reg.getStatus().equals("ACTIVE"));
    }

    static void testDropRegistration() {
        RegistrationSystem system = new RegistrationSystem();
        User user = new User(3, "Carol", "carol@example.com");
        Course course = new Course(103, "OS", "Prof. Lee", 20);
        system.addUser(user);
        system.addCourse(course);
        Registration reg = system.registerUserForCourse(user, course);
        assertTrue("Registration added", system.getRegistrations().size() == 1);
        boolean dropped = system.dropRegistration(reg);
        assertTrue("Registration dropped successfully", dropped);
        assertTrue("Registrations list empty after drop", system.getRegistrations().size() == 0);
    }

    static void testCourseCapacity() {
        Course course = new Course(104, "Networks", "Prof. Brown", 2);
        course.setEnrolledCount(2);
        assertTrue("Course is full when at capacity", course.isFull());
        course.setEnrolledCount(1);
        assertTrue("Course not full when below capacity", !course.isFull());
    }

    static void testRegistrationSystem() {
        RegistrationSystem system = new RegistrationSystem();
        User u1 = new User(4, "Dave", "dave@example.com");
        User u2 = new User(5, "Eve", "eve@example.com");
        Course c1 = new Course(105, "Math", "Prof. White", 10);
        system.addUser(u1);
        system.addUser(u2);
        system.addCourse(c1);
        system.registerUserForCourse(u1, c1);
        system.registerUserForCourse(u2, c1);
        assertTrue("System has 2 users", system.getUsers().size() == 2);
        assertTrue("System has 1 course", system.getCourses().size() == 1);
        assertTrue("System has 2 registrations", system.getRegistrations().size() == 2);
    }
}
