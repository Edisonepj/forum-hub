package forum.hub.api.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import forum.hub.api.domain.user.User;

@JsonPropertyOrder({"id", "name", "email"})
public record UserDetailsDTO(
        Long id,
        @JsonProperty("nome")
        String name,
        String email)
{
    public UserDetailsDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
