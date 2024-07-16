package forum.hub.api.domain.user;

import forum.hub.api.domain.profile.ProfileRepository;
import forum.hub.api.domain.user.dto.UserDetailsDTO;
import forum.hub.api.domain.user.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String DEFAULT_PROFILE_NAME = "membro";

    public UserDetailsDTO register(UserRegistrationDTO data) {
        var profile = profileRepository.findDefaultProfile(DEFAULT_PROFILE_NAME);
        var hashedPassword = passwordEncoder.encode(data.password());
        var user = new User(data, profile);
        user.setPassword(hashedPassword);

        userRepository.save(user);

        return new UserDetailsDTO(user);
    }
}
