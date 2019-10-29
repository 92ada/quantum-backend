package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "exp_internationals")
public class ExpInternational {
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

    @ManyToMany
    @JoinColumn(name = "exp_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<People> people;
    @Column(columnDefinition="text")
    private String peopleJson;

    private String matter;
    private String location;
    private Integer number_of_people;
}
