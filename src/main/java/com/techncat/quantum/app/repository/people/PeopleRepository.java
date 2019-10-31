package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PeopleRepository extends JpaRepository<People, Long> {
    Page<People> findAllByNameLikeOrPhoneLikeOrSidLikeOrEmailLike(
            @Param("name") String name,
            @Param("phone") String phone,
            @Param("sid") String sid,
            @Param("email") String email,
            Pageable pageable);
}
