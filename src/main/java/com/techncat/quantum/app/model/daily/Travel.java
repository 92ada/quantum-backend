package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "travels")
public class Travel {
    public enum Type {
        conference, cooperation
    }

    public enum identity_type {
        id_card, passport
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;


    @ManyToOne
    @JoinColumn(name = "traveler_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People traveler;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object travelerJson;
    @Enumerated
    private Type type;
    @Column(precision = 10, scale = 2)
    private BigDecimal budget;
    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;

    private identity_type identity_type;
    private String identity_no;
}
