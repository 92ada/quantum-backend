package com.techncat.quantum.app.repository.finance;

import com.techncat.quantum.app.model.finance.SocialInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinSocialInsuranceRepository extends JpaRepository<SocialInsurance, Long> {
}
