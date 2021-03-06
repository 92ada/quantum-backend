package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "patents")
public class Patent {
    public enum Type {
        invent, practical, appearance
    }

    public enum Status {
        applying, approved
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "applicant_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People applicant;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object applicantJson;
    private String title;
    @Enumerated
    private Type type;
    @Enumerated
    private Status status;
    @Temporal(TemporalType.DATE)
    private Date apply_date;
    @Temporal(TemporalType.DATE)
    private Date approve_date;
    private String apply_no;
    private String patent_no;
    private Boolean is_pct;
    private Integer inventor_rank;
}
