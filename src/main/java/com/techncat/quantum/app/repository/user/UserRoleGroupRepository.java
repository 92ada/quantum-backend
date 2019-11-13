package com.techncat.quantum.app.repository.user;

import com.techncat.quantum.app.model.user.UserRoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleGroupRepository extends JpaRepository<UserRoleGroup, Long> {
    List<UserRoleGroup> findAll();
}
