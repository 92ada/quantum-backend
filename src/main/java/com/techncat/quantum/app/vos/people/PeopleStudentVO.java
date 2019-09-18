package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.user.People;
import com.techncat.quantum.app.model.user.PeopleAdmin;
import com.techncat.quantum.app.model.user.PeopleStudent;
import org.springframework.beans.BeanUtils;

import javax.persistence.ConstraintMode;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;

public class PeopleStudentVO extends PeopleVO {
    // detail
    private String edu_system;
    private String category;
    private People advisor;
    private People vice_advisor;
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
