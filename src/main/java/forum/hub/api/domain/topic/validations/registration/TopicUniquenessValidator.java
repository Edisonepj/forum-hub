package forum.hub.api.domain.topic.validations.registration;

import forum.hub.api.domain.DataValidationException;
import forum.hub.api.domain.topic.TopicRepository;
import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicUniquenessValidator implements TopicRegistrationValidator {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(TopicRegistrationDTO data) {
        var topicIsRegistered = topicRepository.existsByTitleAndMessage(data.title(), data.message());

        if(topicIsRegistered){
            throw new DataValidationException("Não é permitido o cadastro de tópicos duplicados.");
        }
    }
}
