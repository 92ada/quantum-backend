package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.SocialFund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinSocialFundRepository extends JpaRepository<SocialFund, Long> {
}
