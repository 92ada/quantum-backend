package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit {
    public enum Status {
        unsubmitted, in_progress, approved
    }
    public enum IdentityType {
        id_card, passport
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String name;
    private Status approval_status;
    private String remark;
    private String visitor_institution;
    private String job_title;
    @ManyToOne
    @JoinColumn(name = "receptionist_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People receptionist;
    @Column(columnDefinition="text")
    private String receptionistJson; // {name: xxx, sid: xxx, id: xxx}
    private IdentityType identity_type;
    private String identity_no;
    private String phone_no;
    private String email;
    private String accommodation;
    private Boolean needs_pick_up;
    private BigDecimal expenditure;
    private BigDecimal budget;
}
