package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;

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
    private int sustechInstitutionRank;

    @ManyToOne
    @JoinColumn(name = "author_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private int authorRank;
    private boolean isInternational;
    private boolean isNatureIndex;
    private boolean isConferencePaper;
    private String journalAcceptanceType;
    private String jcrPartition;
    private float impactFactor;
    @Column(columnDefinition="text")
    private String articleThanks;

}
