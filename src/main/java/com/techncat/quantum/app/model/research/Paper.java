package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "papers")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String journal_conference_title;
    @Temporal(TemporalType.DATE)
    private Date publication_date;
    private String volume_no;
    private String document_no;
    private Boolean is_under_sustech;
    private Integer sustech_institution_rank;

    @ManyToMany
    @JoinColumn(name = "author_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<People> sustech_people;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object authorJson; // [{institution: xxx, people: []}, {}]

    private Integer author_rank;
    private Boolean is_international;
    private Boolean is_nature_index;
    private Boolean is_conference_paper;
    private String journal_acceptance_type;
    private String jcr_partition;
    private Float impact_factor;
    @Column(columnDefinition = "text")
    private String article_thanks;
}
