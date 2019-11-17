package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "visits")
public class Visit {
    public enum Status {
        unsubmitted, in_progress, approved
    }

    public enum identity_type {
        id_card, passport
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object receptionistJson; // {name: xxx, sid: xxx, id: xxx}
    private identity_type identity_type;
    private String identity_no;
    private String phone_no;
    private String email;
    private String accommodation;
    private Boolean needs_pick_up;

    private Date time;

    @Column(precision = 10, scale = 2)
    private BigDecimal expenditure;
    @Column(precision = 10, scale = 2)
    private BigDecimal budget;
}
