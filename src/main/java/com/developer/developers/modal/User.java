package com.developer.developers.modal;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    private String id;
    private String email;
    private String name;

}
