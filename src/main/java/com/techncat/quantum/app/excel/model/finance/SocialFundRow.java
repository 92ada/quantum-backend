package com.techncat.quantum.app.excel.model.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SocialFundRow {
    private Long id;

//    @ValueType(value = "person", option_url = "/api/people/options")
//    private People people;
    private String personName;

    private String fund_account_no;
    private String fund_source;
    private String remark;

    private BigDecimal personal_payment;
    private BigDecimal institutional_payment;
    private BigDecimal base_amount;
    private BigDecimal ratio_of_institutional_payment;
    private BigDecimal amount;

    private Date date;
}
