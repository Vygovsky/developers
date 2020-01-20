package com.developer.developers.initializer;

import com.developer.developers.modal.Event;
import com.developer.developers.modal.Group;
import com.developer.developers.repos.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Stream.of("Kyiv GROUP", "Kharkov GROUP", "Dnepr GROUP", "Lviv GROUP")
                .forEach(name -> repository.save(new Group(name)));

        Group group = repository.findByName("Kyiv GROUP");

        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .buid();
        group.setEvents(Collections.singleton(e));
        repository.save(group);

        repository.findAll().forEach(System.out::println);
    }
}
