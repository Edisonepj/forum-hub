package forum.hub.api.domain.topic.validations.general;

import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;
import forum.hub.api.domain.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicAuthorExistenceValidator implements TopicCommonValidator {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(TopicRegistrationDTO data) {
        var userExists = userRepository.existsById(data.authorId());

        if(!userExists){
            throw new EntityNotFoundException("Autor não encontrado. Informe um id válido.");
        }
    }
}
