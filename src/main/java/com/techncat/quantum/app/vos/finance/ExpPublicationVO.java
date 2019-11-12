package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class ExpPublicationVO extends ExpVO {
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String subject;
    private String matter;
    private String department;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String payeeJson;
}
