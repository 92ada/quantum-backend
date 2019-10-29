package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "travels")
public class Travel {
    public enum Type {
        conference, cooperation
    }
    public enum IdentityType {
        id_card, passport
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;


    @ManyToOne
    @JoinColumn(name = "traveler_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People traveler;
    @Column(columnDefinition="text")
    private String travelerJson;
    @Enumerated
    private Type type;
    private BigDecimal budget;
    private Date start_date;
    private Date end_date;

    private IdentityType identity_type;
    private String identity_no;
}
