package com.techncat.quantum.app.excel.model.people;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.model.people.PeoplePostdoctoral;
import lombok.Data;

@Data
public class PeoplePostdoctoralRow extends PeopleRow {
    // detail
    @ExcelField(headName = "学生分类")
    private String category;

//    private Object supervisorJson; // TODO
//    private Object coSupervisorJson;

    @ExcelField(headName = "中期考核进程")
    private String midterm_assessment_status;
    @ExcelField(headName = "开题考核进程")
    private String opening_assessment_status;

    public static PeoplePostdoctoralRow render(PeoplePostdoctoral detail) {
        PeoplePostdoctoralRow row = new PeoplePostdoctoralRow();
        if (detail == null) return row;

        row.category = detail.getCategory();
        row.midterm_assessment_status = detail.getMidterm_assessment_status();
        row.opening_assessment_status = detail.getOpening_assessment_status();

        return row;
    }

    public static PeoplePostdoctoral loadDetail(PeoplePostdoctoralRow row) {
        PeoplePostdoctoral detail = new PeoplePostdoctoral();

        detail.setCategory(row.category);
        detail.setOpening_assessment_status(row.opening_assessment_status);
        detail.setMidterm_assessment_status(row.midterm_assessment_status);

        return detail;
    }
}
