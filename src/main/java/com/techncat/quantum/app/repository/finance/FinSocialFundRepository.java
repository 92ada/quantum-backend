package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.SocialFund;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FinSocialFundRepository extends JpaRepository<SocialFund, Long> {
    SocialFund findFirstById(@Param("id") Long id);

    Page<SocialFund> findAllByDateBetween(Date start, Date end, Pageable pageable);

    List<SocialFund> findAllByDateBetween(Date start, Date end);
}
