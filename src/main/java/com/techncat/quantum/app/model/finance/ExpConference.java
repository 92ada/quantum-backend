package com.techncat.quantum.app.model.finance;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "exp_conferences")
public class ExpConference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;
    private String place_of_participation;
    private Integer planned_attendance;
    private Integer actual_attendance;
    @Column(precision = 10, scale = 2)
    private BigDecimal budget;
    @Column(precision = 10, scale = 2)
    private BigDecimal actual_total_cost;
    @Column(precision = 10, scale = 2)
    private BigDecimal meeting_expenses;
    @Column(precision = 10, scale = 2)
    private BigDecimal transportation_expenses;
    @Column(precision = 10, scale = 2)
    private BigDecimal labor_expenses;

    @ManyToMany
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "officer_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<People> officer;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object officersJson;

}
