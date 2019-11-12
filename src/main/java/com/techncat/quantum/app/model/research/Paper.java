package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "papers")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String journal_conference_title;
    private Date publication_date;
    private String volume_no;
    private String document_no;
    private Boolean is_under_sustech;
    private Integer sustech_institution_rank;

    @ManyToMany
    @JoinColumn(name = "author_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<People> sustech_people;
    @Column(columnDefinition="text")
    private String peopleJson; // [{institution: xxx, people: []}, {}]

    private Integer author_rank;
    private Boolean is_international;
    private Boolean is_nature_index;
    private Boolean is_conference_paper;
    private String journal_acceptance_type;
    private String jcr_partition;
    private Float impact_factor;
    @Column(columnDefinition="text")
    private String article_thanks;

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

    public String getJournal_conference_title() {
        return journal_conference_title;
    }

    public void setJournal_conference_title(String journal_conference_title) {
        this.journal_conference_title = journal_conference_title;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getVolume_no() {
        return volume_no;
    }

    public void setVolume_no(String volume_no) {
        this.volume_no = volume_no;
    }

    public String getDocument_no() {
        return document_no;
    }

    public void setDocument_no(String document_no) {
        this.document_no = document_no;
    }

    public Boolean getIs_under_sustech() {
        return is_under_sustech;
    }

    public void setIs_under_sustech(Boolean is_under_sustech) {
        this.is_under_sustech = is_under_sustech;
    }

    public Integer getSustech_institution_rank() {
        return sustech_institution_rank;
    }

    public void setSustech_institution_rank(Integer sustech_institution_rank) {
        this.sustech_institution_rank = sustech_institution_rank;
    }

    public List<People> getSustech_people() {
        return sustech_people;
    }

    public void setSustech_people(List<People> sustech_people) {
        this.sustech_people = sustech_people;
    }

    public String getPeopleJson() {
        return peopleJson;
    }

    public void setPeopleJson(String peopleJson) {
        this.peopleJson = peopleJson;
    }

    public Integer getAuthor_rank() {
        return author_rank;
    }

    public void setAuthor_rank(Integer author_rank) {
        this.author_rank = author_rank;
    }

    public Boolean getIs_international() {
        return is_international;
    }

    public void setIs_international(Boolean is_international) {
        this.is_international = is_international;
    }

    public Boolean getIs_nature_index() {
        return is_nature_index;
    }

    public void setIs_nature_index(Boolean is_nature_index) {
        this.is_nature_index = is_nature_index;
    }

    public Boolean getIs_conference_paper() {
        return is_conference_paper;
    }

    public void setIs_conference_paper(Boolean is_conference_paper) {
        this.is_conference_paper = is_conference_paper;
    }

    public String getJournal_acceptance_type() {
        return journal_acceptance_type;
    }

    public void setJournal_acceptance_type(String journal_acceptance_type) {
        this.journal_acceptance_type = journal_acceptance_type;
    }

    public String getJcr_partition() {
        return jcr_partition;
    }

    public void setJcr_partition(String jcr_partition) {
        this.jcr_partition = jcr_partition;
    }

    public Float getImpact_factor() {
        return impact_factor;
    }

    public void setImpact_factor(Float impact_factor) {
        this.impact_factor = impact_factor;
    }

    public String getArticle_thanks() {
        return article_thanks;
    }

    public void setArticle_thanks(String article_thanks) {
        this.article_thanks = article_thanks;
    }
}
