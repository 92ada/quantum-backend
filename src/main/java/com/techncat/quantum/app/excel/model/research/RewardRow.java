package com.techncat.quantum.app.excel.model.research;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.research.Reward;
import lombok.Data;

import java.util.Date;

@Data
public class RewardRow {
    private Long id;

    private String rewardedName;

    private String title;
    private String issue_institution;
    @ValueType("enumerated")
    private Reward.Level level;
    @ValueType("enumerated")
    private Reward.Grade grade;
    private Date date;
    private String remark;
}
