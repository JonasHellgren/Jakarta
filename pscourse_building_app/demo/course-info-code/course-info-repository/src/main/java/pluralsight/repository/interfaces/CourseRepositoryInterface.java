package pluralsight.repository.interfaces;

import pluralsight.repository.domain.Course;
import pluralsight.repository.repository.CourseJdbcRepository;

import java.util.List;

public interface CourseRepositoryInterface {

    void saveCourse(Course course);

    List<Course> getAllCourses();

    void addNotes(String id, String notes);

    static CourseRepositoryInterface openCourseRepository(String databaseFile) {
        return new CourseJdbcRepository(databaseFile);
    }
}
