package forum.hub.api.domain.topic.validations.registration;

import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;

public interface TopicRegistrationValidator {
    void validate(TopicRegistrationDTO data);
}
