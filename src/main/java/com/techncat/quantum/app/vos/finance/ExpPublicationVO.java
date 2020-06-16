package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

import java.util.Date;

@Data
public class ExpPublicationVO {
    private Long id;

    private String subject;
    private String matter;
    private String department;

    @ValueType(value = "person", option_url = "/api/people/options")
    private Object handlerJson;

    @ValueType(value = "person", option_url = "/api/people/options")
    private Object payeeJson;
}
