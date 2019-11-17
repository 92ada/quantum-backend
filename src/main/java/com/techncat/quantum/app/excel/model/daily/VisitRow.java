package com.techncat.quantum.app.excel.model.daily;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.daily.Visit;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class VisitRow {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String name;
    @ValueType("enumerated")
    private Visit.Status approval_status;
    private String remark;
    private String visitor_institution;
    private String job_title;

    private String receptionistName;
    @ValueType("enumerated")
    private Visit.identity_type identity_type;
    private String identity_no;
    private String phone_no;
    private String email;
    private String accommodation;
    private Boolean needs_pick_up;
    private BigDecimal expenditure;
    private BigDecimal budget;
    private Date time;
}
