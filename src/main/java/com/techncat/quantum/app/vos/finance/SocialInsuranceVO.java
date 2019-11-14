package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SocialInsuranceVO {
    private Long id;

    @ValueType(value = "person", option_url = "/api/people/options")
    private People people;

    private Date date;

    private BigDecimal receivable_total;
    private BigDecimal receivable_by_individual;
    private BigDecimal receivable_by_institution;
    private BigDecimal pension_base_amount;
    private BigDecimal pension_by_individual;
    private BigDecimal pension_by_institution;
    private BigDecimal medical_base_amount;
    private BigDecimal medical_by_individual;
    private BigDecimal medical_by_institution;
    private BigDecimal work_injury_base_amount;
    private BigDecimal work_injury_by_institution;
    private BigDecimal unemployment_base_amount;
    private BigDecimal unemployment_by_individual;
    private BigDecimal unemployment_by_institution;
    private BigDecimal fertility_base_amount;
    private BigDecimal fertility_by_institution;
}
