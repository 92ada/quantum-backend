package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.util.Date;

@Data
public class ReportVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String inviterJson;

    private Date time;
    private String title;
    private String invitee_name;
    private Integer people_count;
    private String location;
}
