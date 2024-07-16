package forum.hub.api.domain.topic.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRegistrationDTO(
        @NotBlank(message = "{title.required}")
        @JsonAlias({"titulo"})
        String title,
        @NotBlank(message = "{message.required}")
        @JsonAlias({"mensagem"})
        String message,
        @NotNull(message = "{authorId.required}")
        @JsonAlias({"autorId"})
        Long authorId,
        @NotNull(message = "{courseId.required}")
        @JsonAlias({"cursoId"})
        Long courseId
) {
}
