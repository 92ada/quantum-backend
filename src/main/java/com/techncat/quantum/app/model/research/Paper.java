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
    private Float impactFactor;
    @Column(columnDefinition="text")
    private String articleThanks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournalConferenceTitle() {
        return journalConferenceTitle;
    }

    public void setJournalConferenceTitle(String journalConferenceTitle) {
        this.journalConferenceTitle = journalConferenceTitle;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getVolumeNo() {
        return volumeNo;
    }

    public void setVolumeNo(String volumeNo) {
        this.volumeNo = volumeNo;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public Boolean getUnderSustech() {
        return isUnderSustech;
    }

    public void setUnderSustech(Boolean underSustech) {
        isUnderSustech = underSustech;
    }

    public Integer getSustechInstitutionRank() {
        return sustechInstitutionRank;
    }

    public void setSustechInstitutionRank(Integer sustechInstitutionRank) {
        this.sustechInstitutionRank = sustechInstitutionRank;
    }

    public List<People> getSustechPeople() {
        return sustechPeople;
    }

    public void setSustechPeople(List<People> sustechPeople) {
        this.sustechPeople = sustechPeople;
    }

    public String getPeopleJson() {
        return peopleJson;
    }

    public void setPeopleJson(String peopleJson) {
        this.peopleJson = peopleJson;
    }

    public Integer getAuthorRank() {
        return authorRank;
    }

    public void setAuthorRank(Integer authorRank) {
        this.authorRank = authorRank;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    public Boolean getNatureIndex() {
        return isNatureIndex;
    }

    public void setNatureIndex(Boolean natureIndex) {
        isNatureIndex = natureIndex;
    }

    public Boolean getConferencePaper() {
        return isConferencePaper;
    }

    public void setConferencePaper(Boolean conferencePaper) {
        isConferencePaper = conferencePaper;
    }

    public String getJournalAcceptanceType() {
        return journalAcceptanceType;
    }

    public void setJournalAcceptanceType(String journalAcceptanceType) {
        this.journalAcceptanceType = journalAcceptanceType;
    }

    public String getJcrPartition() {
        return jcrPartition;
    }

    public void setJcrPartition(String jcrPartition) {
        this.jcrPartition = jcrPartition;
    }

    public Float getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(Float impactFactor) {
        this.impactFactor = impactFactor;
    }

    public String getArticleThanks() {
        return articleThanks;
    }

    public void setArticleThanks(String articleThanks) {
        this.articleThanks = articleThanks;
    }
}
