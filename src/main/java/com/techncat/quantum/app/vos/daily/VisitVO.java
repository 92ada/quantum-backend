package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.daily.Visit;
import com.techncat.quantum.app.model.people.People;

import java.math.BigDecimal;
import java.util.Date;

public class VisitVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String name;
    @ValueType("enumerated")
    private Visit.Status approval_status;
    private String remark;
    private String visitor_institution;
    private String job_title;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String receptionistJson;
    @ValueType("enumerated")
    private Visit.IdentityType identity_type;
    private String identity_no;
    private String phone_no;
    private String email;
    private String accommodation;
    private Boolean needs_pick_up;
    private BigDecimal expenditure;
    private BigDecimal budget;

    public VisitVO(String receptionistJson) {
        // let id = receptionJson.id
//        this.receptionist = new People();
//        this.receptionist.setId(id);
    }
}
