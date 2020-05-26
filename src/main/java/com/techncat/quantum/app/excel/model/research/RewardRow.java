package com.techncat.quantum.app.excel.model.research;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.service.utils.JsonLoader;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
public class RewardRow {
    @ExcelField(headName = "获奖人工号")
    private String rewardedSid;
    @ExcelField(headName = "获奖人姓名")
    private String rewardedName;
    @ExcelField(headName = "奖励名称")
    private String title;
    @ExcelField(headName = "发证单位")
    private String issue_institution;
    @ExcelField(headName = "获奖级别")
    private String level;
    @ExcelField(headName = "获奖等级")
    private String grade;
    @ExcelField(headName = "获奖日期")
    private String date;
    @ExcelField(headName = "备注")
    private String remark;

    public static RewardRow render(Reward reward) {
        RewardRow row = new RewardRow();
        if (reward.getRewarded() != null) {
            row.rewardedName = reward.getRewarded().getName();
            row.rewardedSid = reward.getRewarded().getSid();
        }

        row.title = reward.getTitle();
        row.issue_institution = reward.getIssue_institution();

        if (reward.getLevel() != null)
            row.level = reward.getLevel().toString();
        if (reward.getGrade() != null)
            row.grade = reward.getGrade().toString();

        row.date = FormatUtil.formatDate(reward.getDate());
        row.remark = reward.getRemark();
        return row;
    }

    public static Reward load(RewardRow row) {
        if (row.title == null || row.title.trim().length() == 0) return null;
        Reward p = new Reward();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setRewarded(RowUtil.loadPeopleFromSid(row.rewardedSid));
        p.setRewardedJson(RowUtil.toJson(p.getRewarded()));
        p.setTitle(row.title);
        p.setIssue_institution(row.issue_institution);
        p.setLevel(FormatUtil.formatEnum(Reward.Level.class, row.level));
        p.setGrade(FormatUtil.formatEnum(Reward.Grade.class, row.grade));
        p.setDate(FormatUtil.formatDate(row.date));
        p.setRemark(row.remark);
        return p;
    }
}
