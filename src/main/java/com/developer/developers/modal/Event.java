package com.developer.developers.modal;

import lombok.*;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Instant date;
    private String descriptoin;
    @ManyToMany
    private Set<User> users;

}
