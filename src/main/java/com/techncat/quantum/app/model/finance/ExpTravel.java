package com.techncat.quantum.app.model.finance;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "exp_travels")
public class ExpTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

//    @OneToOne
//    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private Exp exp;

    @ManyToOne
    @JoinColumn(name = "travel_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People traveler;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object travelerJson;

    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;
    private String matter;
    private String location;
    private Integer number_of_people;
}
