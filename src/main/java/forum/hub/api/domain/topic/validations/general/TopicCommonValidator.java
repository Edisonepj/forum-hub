package forum.hub.api.domain.topic.validations.general;

import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;

public interface TopicCommonValidator {
    void validate(TopicRegistrationDTO data);
}
