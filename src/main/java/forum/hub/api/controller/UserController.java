package forum.hub.api.controller;

import forum.hub.api.domain.user.UserService;
import forum.hub.api.domain.user.dto.UserRegistrationDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserRegistrationDTO data, UriComponentsBuilder uriBuilder){
        var userDetails = service.register(data);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(userDetails.id()).toUri();
        return ResponseEntity.created(uri).body(userDetails);
    }
}
