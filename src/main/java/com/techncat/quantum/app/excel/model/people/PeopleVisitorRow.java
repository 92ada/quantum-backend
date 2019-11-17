package com.techncat.quantum.app.excel.model.people;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PeopleVisitorRow {
    // detail
    private String position_title;
    private String salary_card_no;
    private String bank;
    private String citizenship;
    private String institution;
    private String research_direction;
    private BigDecimal salary;
    private String remark;
}
