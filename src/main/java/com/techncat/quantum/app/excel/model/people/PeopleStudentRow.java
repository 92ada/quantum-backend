package com.techncat.quantum.app.excel.model.people;

import com.techncat.quantum.app.model.people.PeopleStudent;
import lombok.Data;

@Data
public class PeopleStudentRow extends PeopleRow {
    // detail
    private String edu_system;
    private String category;

//    private Object advisorJson; // TODO
//    private Object viceAdvisorJson;

    private String midterm_assessment_status;
    private String opening_assessment_status;

    public static PeopleStudentRow render(PeopleStudent detail) {
        PeopleStudentRow row = new PeopleStudentRow();
        if (detail == null) return row;

        row.edu_system = detail.getEdu_system();
        row.category = detail.getCategory();
        row.midterm_assessment_status = detail.getMidterm_assessment_status();
        row.opening_assessment_status = detail.getOpening_assessment_status();

        return row;
    }

    public static PeopleStudent loadDetail(PeopleStudentRow row) {
        PeopleStudent detail = new PeopleStudent();

        detail.setEdu_system(row.edu_system);
        detail.setCategory(row.category);
        detail.setOpening_assessment_status(row.opening_assessment_status);
        detail.setMidterm_assessment_status(row.midterm_assessment_status);

        return detail;
    }
}
