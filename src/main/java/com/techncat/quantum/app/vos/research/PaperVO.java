package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.util.Date;

@Data
public class PaperVO {
    private Long id;

    private String title;
    private String journal_conference_title;
    private Date publication_date;
    private String volume_no;
    private String document_no;
    private Boolean is_under_sustech;
    private Integer sustech_institution_rank;

    @ValueType(value = "people", option_url = "/api/people/options")
    private Object authorJson;

    private Integer author_rank;
    private Boolean is_international;
    private Boolean is_nature_index;
    private Boolean is_conference_paper;
    private String journal_acceptance_type;
    private String jcr_partition;
    private Float impact_factor;
    @ValueType("text")
    private String article_thanks;
}
