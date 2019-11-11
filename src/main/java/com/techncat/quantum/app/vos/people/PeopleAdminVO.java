package com.techncat.quantum.app.vos.people;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PeopleAdminVO {
    // detail
    private Boolean is_union_member;
    private String salary_card_no;
    private String bank;
    private String contract_no;
    private Date contract_start_date;
    private Date contract_end_date;
    private BigDecimal annual_salary;
    private BigDecimal monthly_salary;
    private BigDecimal housing_subsidy;
}
