package forum.hub.api.domain.topic.validations.update;

import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;

public interface TopicUpdateValidator {
    void validate(TopicRegistrationDTO data, Long id);
}
