package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleAdmin;
import com.techncat.quantum.app.model.user.PeoplePostdoctoral;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class PeoplePostdoctoralVO extends PeopleVO {
    // detail
    private String edu_system;
    private String category;
    private People advisor;
    private People vice_advisor;
    private String midtermAssessmentStatus;
    private String openingAssessmentStatus;

    public PeoplePostdoctoralVO(People people, PeoplePostdoctoral peoplePostdoctoral) {
        super(people);
        copyProperties(peoplePostdoctoral);
    }

    private void copyProperties(PeoplePostdoctoral peoplePostdoctoral) {
        Long id = this.getId();
        Date createdAt = this.getCreatedAt();
        Date updatedAt = this.getUpdateAt();
        BeanUtils.copyProperties(peoplePostdoctoral, this);
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setUpdateAt(updatedAt);
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

    public People getVice_advisor() {
        return vice_advisor;
    }

    public void setVice_advisor(People vice_advisor) {
        this.vice_advisor = vice_advisor;
    }

    public String getMidtermAssessmentStatus() {
        return midtermAssessmentStatus;
    }

    public void setMidtermAssessmentStatus(String midtermAssessmentStatus) {
        this.midtermAssessmentStatus = midtermAssessmentStatus;
    }

    public String getOpeningAssessmentStatus() {
        return openingAssessmentStatus;
    }

    public void setOpeningAssessmentStatus(String openingAssessmentStatus) {
        this.openingAssessmentStatus = openingAssessmentStatus;
    }
}
