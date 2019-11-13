package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.SocialInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FinSocialInsuranceRepository extends JpaRepository<SocialInsurance, Long> {
    SocialInsurance findFirstById(@Param("id") Long id);
}
