package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleStudent;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class PeopleStudentVO extends PeopleVO {
    // detail
    private String eduSystem;
    private String category;
    @ValueType(value = "object", option_url = "/api/people/options")
    private String advisorJson;
    @ValueType(value = "object", option_url = "/api/people/options")
    private String viceAdvisorJson;
    private String midtermAssessmentStatus;
    private String openingAssessmentStatus;

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

    public String getAdvisorJson() {
        return advisorJson;
    }

    public void setAdvisorJson(String advisorJson) {
        this.advisorJson = advisorJson;
    }

    public String getViceAdvisorJson() {
        return viceAdvisorJson;
    }

    public void setViceAdvisorJson(String viceAdvisorJson) {
        this.viceAdvisorJson = viceAdvisorJson;
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
