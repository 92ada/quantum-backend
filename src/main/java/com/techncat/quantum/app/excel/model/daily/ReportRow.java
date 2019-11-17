package com.techncat.quantum.app.excel.model.daily;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class ReportRow {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String inviterName;

    private Date time;
    private String title;
    private String invitee_name;
    private Integer people_count;
    private String location;
}
