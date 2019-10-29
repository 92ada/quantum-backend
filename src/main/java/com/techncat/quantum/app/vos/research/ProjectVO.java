package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Project;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class ProjectVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String type; // 可能是枚举，不清楚选项
    @ValueType("enumerated")
    private Project.Category category;

    @ValueType(value = "object", option_url = "/api/people/options") // TODO
    private People leader;

    private Date start_date;
    private Date end_date;
    @ValueType("enumerated")
    private Project.WayOfTaking way_of_taking;
    private BigDecimal approved_funds;

    private Set<People> member; // TODO
}
