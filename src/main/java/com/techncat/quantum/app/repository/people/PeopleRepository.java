package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {
    Page<People> findAllByNameLikeOrSidLikeOrEmailLike(
            @Param("name") String name,
            @Param("sid") String sid,
            @Param("email") String email,
            Pageable pageable);

    Page<People> findAllByTypeAndNameLikeOrSidLikeOrEmailLike(
            @Param("type") People.Type type,
            @Param("name") String name,
            @Param("sid") String sid,
            @Param("email") String email,
            Pageable pageable);

    Page<People> findAllByType(@Param("type") People.Type type, Pageable pageable);

    List<People> findAllByNameLike(@Param("name") String name);
}
