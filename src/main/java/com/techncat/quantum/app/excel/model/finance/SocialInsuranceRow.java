package com.techncat.quantum.app.excel.model.finance;

import lombok.Data;

@Data
public class SocialInsuranceRow {
    
    private String personSid;
    private String personName;

    private String date;

    private String receivable_total;
    private String receivable_by_individual;
    private String receivable_by_institution;
    private String pension_base_amount;
    private String pension_by_individual;
    private String pension_by_institution;
    private String medical_base_amount;
    private String medical_by_individual;
    private String medical_by_institution;
    private String work_injury_base_amount;
    private String work_injury_by_institution;
    private String unemployment_base_amount;
    private String unemployment_by_individual;
    private String unemployment_by_institution;
    private String fertility_base_amount;
    private String fertility_by_institution;
}
