package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "papers")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String journalConferenceTitle;
    private Date publicationDate;
    private String volumeNo;
    private String documentNo;
    private Boolean isUnderSustech;
    private Integer sustechInstitutionRank;

    @ManyToMany
    @JoinColumn(name = "author_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<People> sustechPeople;
    @Column(columnDefinition="text")
    private String peopleJson; // [{institution: xxx, people: []}, {}]

    private Integer authorRank;
    private Boolean isInternational;
    private Boolean isNatureIndex;
    private Boolean isConferencePaper;
    private String journalAcceptanceType;
    private String jcrPartition;
    private float impactFactor;
    @Column(columnDefinition="text")
    private String articleThanks;
}
