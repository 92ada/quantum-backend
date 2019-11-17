package com.techncat.quantum.app.excel.model.research;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.research.Project;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProjectRow {
    private Long id;

    private String title;
    private String type; // 可能是枚举，不清楚选项
    @ValueType("enumerated")
    private Project.Category category;

    private String leaderName;

    private Date start_date;
    private Date end_date;
    @ValueType("enumerated")
    private Project.WayOfTaking way_of_taking;
    private BigDecimal approved_funds;
}
