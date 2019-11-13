package com.techncat.quantum.app.repository.people;

import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LabRepository extends JpaRepository<Lab, Long> {
    Lab findFirstById(@Param("id") Long id);

    Lab findAllByPi(People people);

    List<Lab> findAllByNameLike(@Param("name") String name);

    Page<Lab> findAllByNameLike(@Param("name") String name, Pageable pageable);
}
