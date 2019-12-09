package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface People_Repository extends JpaRepository<People, Long> {
    Page<People> findAllByNameLikeAndIdInOrSidLikeAndIdInOrEmailLikeAndIdIn(
            @Param("name") String name,
            List<Long> ids1,
            @Param("sid") String sid,
            List<Long> ids2,
            @Param("email") String email,
            List<Long> ids3,
            Pageable pageable);

    Page<People> findAllByNameLikeOrSidLikeOrEmailLike(
            @Param("name") String name,
            @Param("sid") String sid,
            @Param("email") String email,
            Pageable pageable);

    Page<People> findAllByTypeAndNameLikeAndIdInOrTypeAndSidLikeAndIdInOrTypeAndEmailLikeAndIdIn(
            @Param("type") People.Type type1,
            @Param("name") String name,
            List<Long> ids1,
            @Param("type") People.Type type2,
            @Param("sid") String sid,
            List<Long> ids2,
            @Param("type") People.Type type3,
            @Param("email") String email,
            List<Long> ids3,
            Pageable pageable);

    Page<People> findAllByTypeAndNameLikeOrTypeAndSidLikeOrTypeAndEmailLike(
            @Param("type") People.Type type1,
            @Param("name") String name,
            @Param("type") People.Type type2,
            @Param("sid") String sid,
            @Param("type") People.Type type3,
            @Param("email") String email,
            Pageable pageable);

    Page<People> findAllByTypeAndIdIn(@Param("type") People.Type type, List<Long> ids, Pageable pageable);

    Page<People> findAllByType(@Param("type") People.Type type, Pageable pageable);

    Page<People> findAllByIdIn(List<Long> ids, Pageable pageable);

    List<People> findAllByNameLike(@Param("name") String name);

    People findFirstBySid(@Param("sid") String sid);
}
