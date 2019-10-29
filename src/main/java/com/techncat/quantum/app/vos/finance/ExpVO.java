package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.finance.*;
import com.techncat.quantum.app.model.people.Lab;

import java.math.BigDecimal;
import java.util.Date;

public class ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/labs/options")
    private Lab lab;

    private Exp.Type type;
    private Date date;
    private String reservation_no;
    private BigDecimal amount;
    private Integer document_month;
    private String document_no;
    private String remark;

    // TODO
    private ExpConference expConference;
    private ExpConsultation expConsultation;
    private ExpEquipment expEquipment;
    private ExpIndirective expIndirective;
    private ExpInternational expInternational;
    private ExpLabor expLabor;
    private ExpMaterial expMaterial;
    private ExpOther expOther;
    private ExpProcessing expProcessing;
    private ExpPublication expPublication;
    private ExpTravel expTravel;
}
