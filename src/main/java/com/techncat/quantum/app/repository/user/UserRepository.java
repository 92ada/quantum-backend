package com.techncat.quantum.app.repository.user;

import com.techncat.quantum.app.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    User findFirstBySid(@Param("sid") String sid);
}
