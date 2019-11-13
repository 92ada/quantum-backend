package com.techncat.quantum.app.vos.daily;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class HostingVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ValueType(value = "people", option_url = "/api/people/options")
    private Object inviterJson;
    private Date time;
    private String title;
    private String site;
    private Boolean is_reimbursement;
}
