package com.techncat.quantum.app.excel.model.finance;

import com.techncat.quantum.app.common.voenhance.annotation.Editable;
import com.techncat.quantum.app.model.finance.Exp;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpRow {
    private Long id;

    //    @ValueType(value = "lab", option_url = "/api/labs/options")
//    private Lab lab;
    private String labName;

    @Editable(false)
    private Exp.Type type;
    private Date date;
    private String reservation_no;
    private BigDecimal amount;
    private Integer document_month;
    private String document_no;
    private String remark;
}
