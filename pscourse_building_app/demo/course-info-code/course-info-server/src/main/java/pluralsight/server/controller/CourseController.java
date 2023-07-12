package pluralsight.server.controller;

import pluralsight.repository.domain.Course;
import pluralsight.repository.interfaces.CourseRepositoryInterface;
import pluralsight.repository.exception.RepositoryException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static java.util.Comparator.comparing;

@Path("courses")
public class CourseController {
    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

    private CourseRepositoryInterface courseRepository;

    public CourseController(CourseRepositoryInterface courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Stream<Course> getCourses() {
        try {
            return courseRepository
                    .getAllCourses()
                    .stream()
                    .sorted(comparing(Course::id));
        } catch (RepositoryException e) {
            LOG.error("Could not retrieve courses from the database", e);
            throw new NotFoundException();
        }
    }

    @POST
    @Path("/{id}/notes")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addNotes(@PathParam("id") String id, String notes) {
        courseRepository.addNotes(id, notes);
    }
}
