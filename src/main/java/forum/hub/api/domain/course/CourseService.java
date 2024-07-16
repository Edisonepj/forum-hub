package forum.hub.api.domain.course;

import forum.hub.api.domain.course.dto.CourseDetailsDTO;
import forum.hub.api.domain.course.dto.CourseRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDetailsDTO register(CourseRegistrationDTO data) {
        var course = new Course(null, data.name(), data.category());
        courseRepository.save(course);

        return new CourseDetailsDTO(course);
    }
}
