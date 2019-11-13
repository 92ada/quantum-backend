package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.SocialFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FinSocialFundRepository extends JpaRepository<SocialFund, Long> {
    SocialFund findFirstById(@Param("id") Long id);
}
