public class Course {
    private int courseId;
    private String courseName;
    private String instructor;
    private int maxCapacity;
    private int enrolledCount;

    public Course(int courseId, String courseName, String instructor, int maxCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.enrolledCount = 0;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    public void setEnrolledCount(int enrolledCount) {
        this.enrolledCount = enrolledCount;
    }

    public boolean isFull() {
        return enrolledCount >= maxCapacity;
    }

    @Override
    public String toString() {
        return "Course{courseId=" + courseId + ", courseName='" + courseName + "', instructor='" + instructor + "', capacity=" + maxCapacity + "}";
    }
}
