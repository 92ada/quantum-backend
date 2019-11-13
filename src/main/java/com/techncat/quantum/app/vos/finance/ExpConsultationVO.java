package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

@Data
public class ExpConsultationVO {
    private String subject;
    private String matter;
    private String department;

    @ValueType(value = "people", option_url = "/api/people/options")
    private Object handlerJson;
    @ValueType(value = "people", option_url = "/api/people/options")
    private Object payeeJson;
}
