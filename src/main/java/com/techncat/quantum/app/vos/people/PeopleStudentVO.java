package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleStudent;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class PeopleStudentVO extends PeopleVO {
    // detail
    private String eduSystem;
    private String category;
    private People advisor;
    private People viceAdvisor;
    private String midtermAssessmentStatus;
    private String openingAssessmentStatus;

    public PeopleStudentVO(People people, PeopleStudent peopleStudent) {
        super(people);
        copyProperties(peopleStudent);
    }

    private void copyProperties(PeopleStudent peopleStudent) {
        Long id = this.getId();
        Date createdAt = this.getCreatedAt();
        Date updatedAt = this.getUpdateAt();
        BeanUtils.copyProperties(peopleStudent, this);
        this.setId(id);
        this.setCreatedAt(createdAt);
        this.setUpdateAt(updatedAt);
    }

    public String getEduSystem() {
        return eduSystem;
    }

    public void setEduSystem(String eduSystem) {
        this.eduSystem = eduSystem;
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

    public People getViceAdvisor() {
        return viceAdvisor;
    }

    public void setViceAdvisor(People viceAdvisor) {
        this.viceAdvisor = viceAdvisor;
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
