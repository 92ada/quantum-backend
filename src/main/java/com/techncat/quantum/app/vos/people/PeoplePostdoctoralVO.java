package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeoplePostdoctoral;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class PeoplePostdoctoralVO {
    // detail
    private String edu_system;
    private String category;
    @ValueType(value = "object", option_url = "/api/people/options")
    private String advisorJson;
    @ValueType(value = "object", option_url = "/api/people/options")
    private String viceAdvisorJson;
    private String midterm_assessment_status;
    private String opening_assessment_status;
}
