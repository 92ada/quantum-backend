package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SocialFundVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private People people;

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
