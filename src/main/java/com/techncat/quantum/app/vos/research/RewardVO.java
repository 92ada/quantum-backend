package com.techncat.quantum.app.vos.research;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Reward;
import lombok.Data;

import java.util.Date;

@Data
public class RewardVO {
    private Long id;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String rewardedJson;

    private String title;
    private String issue_institution;
    @ValueType("enumerated")
    private Reward.Level level;
    @ValueType("enumerated")
    private Reward.Grade grade;
    private Date date;
    private String remark;
}
