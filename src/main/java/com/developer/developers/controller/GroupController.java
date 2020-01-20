package com.developer.developers.controller;

import com.developer.developers.modal.Group;
import com.developer.developers.repos.GroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class GroupController {

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);
    private final GroupRepository repository;

    public GroupController(GroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/groups")
    Collection<Group> groups() {
        return repository.findAll();
    }

    @GetMapping("/group/{id}")
    ResponseEntity<?> getGroupById(@PathVariable Long id) {
        Optional<Group> group = repository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/group")
    ResponseEntity<Group> createGroup(@Valid @RequestBody Group group) throws URISyntaxException {
        logger.info("Request to update group: {}", group);
        Group result = repository.save(group);
        return ResponseEntity.created(new URI("/api/group/" + result.getId)).body(result);
    }

    @PutMapping("/group/{id}")
    ResponseEntity<Group> editGroup(@Valid @RequestBody Group group) {
        logger.info("Request to update group: {}", group);
        Group result = repository.save(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        logger.info("Request to delete group: {}", id);
        repository.deleteById(id);
        return ResponseEntity.ok().body();
    }
}