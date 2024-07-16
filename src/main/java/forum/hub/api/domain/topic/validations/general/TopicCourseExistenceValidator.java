package forum.hub.api.domain.topic.validations.general;

import forum.hub.api.domain.DataValidationException;
import forum.hub.api.domain.course.CourseRepository;
import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicCourseExistenceValidator implements TopicCommonValidator {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(TopicRegistrationDTO data) {
        var courseExists = courseRepository.existsById(data.courseId());

        if(!courseExists){
            throw new EntityNotFoundException("Curso não encontrado. Informe um id válido.");
        }
    }
}
