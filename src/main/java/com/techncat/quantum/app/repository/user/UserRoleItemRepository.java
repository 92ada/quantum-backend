package com.techncat.quantum.app.repository.user;

import com.techncat.quantum.app.model.user.UserRoleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleItemRepository extends JpaRepository<UserRoleItem, Long> {
    List<UserRoleItem> findAll();

    UserRoleItem findFirstByKey(@Param("key") String key);
}
