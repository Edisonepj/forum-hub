package forum.hub.api.domain.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import forum.hub.api.domain.course.Category;
import forum.hub.api.domain.course.Course;

@JsonPropertyOrder({"id", "name", "category"})
public record CourseDetailsDTO(Long id,
                               @JsonProperty("nome")
                               String name,
                               @JsonProperty("categoria")
                               Category category) {
    public CourseDetailsDTO(Course course) {
        this(course.getId(),
                course.getName(),
                course.getCategory());
    }
}
