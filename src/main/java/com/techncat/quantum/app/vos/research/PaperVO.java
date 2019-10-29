package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;

import java.util.Date;

public class PaperVO {
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

    @ValueType(value = "object", option_url = "/api/people/options")
    private String peopleJson;

    private Integer authorRank;
    private Boolean isInternational;
    private Boolean isNatureIndex;
    private Boolean isConferencePaper;
    private String journalAcceptanceType;
    private String jcrPartition;
    private float impactFactor;
    @ValueType("text")
    private String articleThanks;
}
