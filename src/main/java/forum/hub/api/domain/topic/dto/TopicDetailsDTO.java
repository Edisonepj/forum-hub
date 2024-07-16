package forum.hub.api.domain.topic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import forum.hub.api.domain.topic.Status;
import forum.hub.api.domain.topic.Topic;

import java.time.LocalDateTime;

@JsonPropertyOrder({"id", "title", "message", "createdAt", "status", "authorId", "courseId"})
public record TopicDetailsDTO(
        Long id,
        @JsonProperty("titulo")
        String title,
        @JsonProperty("mensagem")
        String message,
        @JsonProperty("criado_em")
        LocalDateTime createdAt,
        Status status,
        @JsonProperty("autorId")
        Long authorId,
        @JsonProperty("cursoId")
        Long courseId
) {
    public TopicDetailsDTO(Topic topic) {
        this(topic.getId(),
            topic.getTitle(),
            topic.getMessage(),
            topic.getCreatedAt(),
            topic.getStatus(),
            topic.getAuthor().getId(),
            topic.getCourse().getId());
    }
}
