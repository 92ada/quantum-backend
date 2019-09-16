package com.techncat.quantum.app.repository;

import com.techncat.quantum.app.model.user.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<People, Long> {
    List<People> findAll();

    List<People> findAllByStatusAndType(@Param("status") String status, @Param("type") String type);

    Page<People> findAll(Pageable pageable);
}
