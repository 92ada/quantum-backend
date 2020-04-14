package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "exp_internationals")
public class ExpInternational {
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

    @ManyToMany
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "exp_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<People> people;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object peopleJson;

    private String matter;
    private String location;
    private Integer number_of_people;
}
