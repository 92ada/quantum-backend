package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.SocialInsurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FinSocialInsuranceRepository extends JpaRepository<SocialInsurance, Long> {
    SocialInsurance findFirstById(@Param("id") Long id);

    Page<SocialInsurance> findAllByDateBetween(Date start, Date end, Pageable pageable);

    List<SocialInsurance> findAllByDateBetween(Date start, Date end);
}
