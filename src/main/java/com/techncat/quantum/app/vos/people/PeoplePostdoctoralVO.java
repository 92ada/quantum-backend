package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.PeoplePostdoctoral;
import lombok.Data;

@Data
public class PeoplePostdoctoralVO {
    // detail
    @ValueType("enumerated")
    private PeoplePostdoctoral.Category category;
    @ValueType(value = "person", option_url = "/api/people/options")
    private Object supervisorJson;
    @ValueType(value = "person", option_url = "/api/people/options")
    private Object coSupervisorJson;
    private String midterm_assessment_status;
    private String opening_assessment_status;
}
