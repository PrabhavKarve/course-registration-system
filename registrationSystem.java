import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    private List<Registration> registrations;
    private List<Course> courses;
    private List<User> users;

    public RegistrationSystem() {
        this.registrations = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Registration registerUserForCourse(User user, Course course) {
        Registration registration = new Registration(user, course);
        registrations.add(registration);
        return registration;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean dropRegistration(Registration registration) {
        return registrations.remove(registration);
    }
}
