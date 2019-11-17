package com.techncat.quantum.app.excel.model.research;

import lombok.Data;

import java.util.Date;

@Data
public class PaperRow {
    private Long id;

    private String title;
    private String journal_conference_title;
    private Date publication_date;
    private String volume_no;
    private String document_no;
    private Boolean is_under_sustech;
    private Integer sustech_institution_rank;

    private String authorName;

    private Integer author_rank;
    private Boolean is_international;
    private Boolean is_nature_index;
    private Boolean is_conference_paper;
    private String journal_acceptance_type;
    private String jcr_partition;
    private Float impact_factor;
    private String article_thanks;
}
