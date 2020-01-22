package com.developer.developers.modal;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_group")
@Data
@NoArgsConstructor
@Getter @Setter
@RequiredArgsConstructor
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Event> events;


}
