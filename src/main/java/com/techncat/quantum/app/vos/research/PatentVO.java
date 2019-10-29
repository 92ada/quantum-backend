package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Patent;

import java.util.Date;

public class PatentVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private People applicant;
    private String title;
    @ValueType("enumerated")
    private Patent.Type type;
    @ValueType("enumerated")
    private Patent.Status status;
    private Date apply_date;
    private Date approve_date;
    private String apply_no;
    private String patent_no;
    private Boolean is_pct;
    private Integer inventor_rank;
}
