package forum.hub.api.controller;

import forum.hub.api.domain.course.CourseService;
import forum.hub.api.domain.course.dto.CourseRegistrationDTO;
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
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid CourseRegistrationDTO data, UriComponentsBuilder uriBuilder){
        var courseDetails = service.register(data);
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(courseDetails.id()).toUri();

        return ResponseEntity.created(uri).body(courseDetails);
    }
}
