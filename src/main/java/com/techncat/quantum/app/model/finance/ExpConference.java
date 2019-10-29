package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "exp_conferences")
public class ExpConference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    private Date start_date;
    private Date end_date;
    private String place_of_participation;
    private Integer planned_attendance;
    private Integer actual_attendance;
    private BigDecimal budget;
    private BigDecimal actual_total_cost;
    private BigDecimal meeting_expenses;
    private BigDecimal transportation_expenses;
    private BigDecimal labor_expenses;

    @ManyToMany
    @JoinColumn(name = "officer_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<People> officer;
}
