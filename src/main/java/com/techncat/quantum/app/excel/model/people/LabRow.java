package com.techncat.quantum.app.excel.model.people;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.Lab;
import lombok.Data;

@Data
public class LabRow {
    @ExcelField(headName = "PI名称")
    private String piName;
    @ExcelField(headName = "介绍")
    private String description;
    @ExcelField(headName = "上级实验室")
    private String fatherLabName;
    @ExcelField(headName = "层级")
    private String level;

    public static LabRow render(Lab lab) {
        LabRow row = new LabRow();

        if (lab.getPi() != null)
            row.piName = lab.getPi().getName();
        row.description = lab.getDescription();
        if (lab.getFatherLab() != null)
            row.fatherLabName = lab.getFatherLab().getName();
        row.level = FormatUtil.format(lab.getLevel());
        return row;
    }
}
