package forum.hub.api.controller;

import forum.hub.api.domain.topic.TopicService;
import forum.hub.api.domain.topic.dto.TopicDetailsDTO;
import forum.hub.api.domain.topic.dto.TopicRegistrationDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid TopicRegistrationDTO data, UriComponentsBuilder uriBuilder){
        var topicDetails = service.register(data);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicDetails.id()).toUri();
        return ResponseEntity.created(uri).body(topicDetails);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetailsDTO>> list(@PageableDefault(size = 10, sort = {"createdAt"}) Pageable pagination){
        var page = service.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var topicDetails = service.detail(id);
        return ResponseEntity.ok(topicDetails);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid TopicRegistrationDTO data, @PathVariable Long id){
        var topicDetails = service.update(data, id);
        return ResponseEntity.ok(topicDetails);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
