package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.Editable;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.finance.*;
import com.techncat.quantum.app.model.people.Lab;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpVO {
    private Long id;

    @ValueType(value = "lab", option_url = "/api/labs/options")
    private Lab lab;

    @Editable(false)
    private Exp.Type type;
    private Date date;
    private String expenditure_no;
    private String reservation_no;
    private BigDecimal amount;
    private Integer document_month;
    private String document_no;
    private String remark;
}
