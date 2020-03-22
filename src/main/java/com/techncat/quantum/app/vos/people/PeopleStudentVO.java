package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleStudent;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class PeopleStudentVO {
    // detail
    private String edu_system;
    private String major;
    @ValueType(value = "people", option_url = "/api/people/options")
    private Object advisorJson;
    @ValueType(value = "people", option_url = "/api/people/options")
    private Object viceAdvisorJson;
    private String midterm_assessment_status;
    private String opening_assessment_status;
}
