package forum.hub.api.domain.topic.validations.update;

import forum.hub.api.domain.DataValidationException;
import forum.hub.api.domain.topic.TopicRepository;
import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicExistenceValidator implements TopicUpdateValidator {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(TopicRegistrationDTO data, Long id) {
        var topicExists = topicRepository.existsById(id);

        if(!topicExists){
            throw new EntityNotFoundException("Tópico não encontrado. Informe um Id válido.");
        }
    }
}
