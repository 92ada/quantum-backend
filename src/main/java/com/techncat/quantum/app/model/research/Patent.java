package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "applicant_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People applicant;
    private String title;
    @Enumerated
    private Type type;
    @Enumerated
    private Status status;
    private Date apply_date;
    private Date approve_date;
    private String apply_no;
    private String patent_no;
    private boolean is_pct;
    private int inventor_rank;
}
