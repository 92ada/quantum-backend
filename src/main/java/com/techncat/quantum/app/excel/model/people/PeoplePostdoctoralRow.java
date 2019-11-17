package com.techncat.quantum.app.excel.model.people;

import lombok.Data;

@Data
public class PeoplePostdoctoralRow {
    // detail
    private String edu_system;
    private String category;
    //    @ValueType(value = "people", option_url = "/api/people/options")
//    private Object advisorJson;
//    @ValueType(value = "people", option_url = "/api/people/options")
//    private Object viceAdvisorJson;
    private String advisorName;
    private String viceAdvisorName;

    private String midterm_assessment_status;
    private String opening_assessment_status;
}
