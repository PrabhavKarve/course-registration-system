public class Registration {
    private User user;
    private Course course;
    private String status;

    public Registration(User user, Course course) {
        this.user = user;
        this.course = course;
        this.status = "ACTIVE";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Registration{user=" + user.getName() + ", course=" + course.getCourseName() + ", status='" + status + "'}";
    }
}
