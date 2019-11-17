package com.techncat.quantum.app.excel.model.research;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.research.Patent;
import lombok.Data;

import java.util.Date;

@Data
public class PatentRow {
    private Long id;

    private String applicantName;
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
