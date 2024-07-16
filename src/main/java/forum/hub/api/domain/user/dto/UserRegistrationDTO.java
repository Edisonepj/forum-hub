package forum.hub.api.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegistrationDTO(@JsonAlias("nome")
                                  @NotBlank(message = "{name.required")
                                  String name,
                                  @NotBlank(message = "{email.required}")
                                  @Email(message = "{email.invalid}")
                                  String email,
                                  @JsonAlias("senha")
                                  @NotBlank(message = "{password.required}")
                                  String password) {
}
