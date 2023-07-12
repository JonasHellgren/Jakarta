package pluralsight.cli.service;

import pluralsight.cli.domain.PluralsightCourse;
import pluralsight.repository.domain.Course;
import pluralsight.repository.interfaces.CourseRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class CourseStorageService {
    private static final String PS_BASE_URL = "https://app.pluralsight.com";

    private final CourseRepositoryInterface courseRepository;

    public CourseStorageService(CourseRepositoryInterface courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void storePluralsightCourses(List<PluralsightCourse> psCourses) {
        for (PluralsightCourse psCourse : psCourses) {
            Course course = new Course(psCourse.id(),
                    psCourse.title(), psCourse.durationInMinutes(),
                    PS_BASE_URL + psCourse.contentUrl(), Optional.empty());
            courseRepository.saveCourse(course);
        }
    }
}
