package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people_postdoctoral")
public class PeoplePostdoctoral {
    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String edu_system;
    private String category;

    @ManyToOne
    @JoinColumn(name = "advisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People advisor;
    @Column(columnDefinition="text")
    private String advisorJson;
    @ManyToOne
    @JoinColumn(name = "vice_advisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People vice_advisor;
    @Column(columnDefinition="text")
    private String viceAdvisorJson;

    private String midterm_assessment_status;
    private String opening_assessment_status;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getEdu_system() {
        return edu_system;
    }

    public void setEdu_system(String edu_system) {
        this.edu_system = edu_system;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public People getAdvisor() {
        return advisor;
    }

    public void setAdvisor(People advisor) {
        this.advisor = advisor;
    }

    public String getAdvisorJson() {
        return advisorJson;
    }

    public void setAdvisorJson(String advisorJson) {
        this.advisorJson = advisorJson;
    }

    public People getVice_advisor() {
        return vice_advisor;
    }

    public void setVice_advisor(People vice_advisor) {
        this.vice_advisor = vice_advisor;
    }

    public String getViceAdvisorJson() {
        return viceAdvisorJson;
    }

    public void setViceAdvisorJson(String viceAdvisorJson) {
        this.viceAdvisorJson = viceAdvisorJson;
    }

    public String getMidterm_assessment_status() {
        return midterm_assessment_status;
    }

    public void setMidterm_assessment_status(String midterm_assessment_status) {
        this.midterm_assessment_status = midterm_assessment_status;
    }

    public String getOpening_assessment_status() {
        return opening_assessment_status;
    }

    public void setOpening_assessment_status(String opening_assessment_status) {
        this.opening_assessment_status = opening_assessment_status;
    }
}
