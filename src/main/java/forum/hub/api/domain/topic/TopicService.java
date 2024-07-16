package forum.hub.api.domain.topic;

import forum.hub.api.domain.DataValidationException;
import forum.hub.api.domain.course.CourseRepository;
import forum.hub.api.domain.topic.dto.TopicDetailsDTO;
import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;
import forum.hub.api.domain.topic.validations.general.TopicCommonValidator;
import forum.hub.api.domain.topic.validations.registration.TopicRegistrationValidator;
import forum.hub.api.domain.topic.validations.update.TopicUpdateValidator;
import forum.hub.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private List<TopicCommonValidator> topicCommonValidators;
    @Autowired
    private List<TopicRegistrationValidator> topicRegistrationValidators;
    @Autowired
    private List<TopicUpdateValidator> topicUpdateValidators;

    public TopicDetailsDTO register(TopicRegistrationDTO data) {
        topicCommonValidators.forEach(v -> v.validate(data));
        topicRegistrationValidators.forEach(v -> v.validate(data));

        var author = userRepository.getReferenceById(data.authorId());
        var course = courseRepository.getReferenceById(data.courseId());
        var topic = new Topic(null, data.title(), data.message(), LocalDateTime.now(), Status.ABERTO, author, course);

        topicRepository.save(topic);

        return new TopicDetailsDTO(topic);
    }

    public Page<TopicDetailsDTO> list(Pageable pagination) {
        var page = topicRepository.findAll(pagination).map(TopicDetailsDTO::new);
        return page;
    }

    public TopicDetailsDTO detail(Long id) {
        var topicDetails = topicRepository.getReferenceById(id);
        return new TopicDetailsDTO(topicDetails);
    }

    public TopicDetailsDTO update(TopicRegistrationDTO data, Long id) {
        topicCommonValidators.forEach(v -> v.validate(data));
        topicUpdateValidators.forEach(v -> v.validate(data, id));

        var topic = topicRepository.getReferenceById(id);
        var user = userRepository.getReferenceById(data.authorId());
        var course = courseRepository.getReferenceById(data.courseId());
        topic.updateData(data, user, course);

        return new TopicDetailsDTO(topic);
    }

    public void delete(Long id) {

        var topicExists = topicRepository.existsById(id);

        if (!topicExists){
            throw new DataValidationException("Tópico não encontrado");
        }
        topicRepository.deleteById(id);
    }
}