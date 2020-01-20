package com.developer.developers.repos;

import com.developer.developers.modal.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
