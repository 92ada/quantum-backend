package com.techncat.quantum.app.excel.model.people;

import com.techncat.quantum.app.model.people.PeoplePostdoctoral;
import lombok.Data;

@Data
public class PeoplePostdoctoralRow extends PeopleRow {
    // detail
    private String edu_system;
    private String category;

//    private Object advisorJson; // TODO
//    private Object viceAdvisorJson;

    private String midterm_assessment_status;
    private String opening_assessment_status;

    public static PeoplePostdoctoralRow render(PeoplePostdoctoral detail) {
        PeoplePostdoctoralRow row = new PeoplePostdoctoralRow();
        if (detail == null) return row;

        row.edu_system = detail.getEdu_system();
        row.category = detail.getCategory();
        row.midterm_assessment_status = detail.getMidterm_assessment_status();
        row.opening_assessment_status = detail.getOpening_assessment_status();

        return row;
    }

    public static PeoplePostdoctoral loadDetail(PeoplePostdoctoralRow row) {
        PeoplePostdoctoral detail = new PeoplePostdoctoral();

        detail.setEdu_system(row.edu_system);
        detail.setCategory(row.category);
        detail.setOpening_assessment_status(row.opening_assessment_status);
        detail.setMidterm_assessment_status(row.midterm_assessment_status);

        return detail;
    }
}
