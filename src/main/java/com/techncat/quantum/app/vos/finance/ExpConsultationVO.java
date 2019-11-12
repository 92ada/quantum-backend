package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import lombok.Data;

@Data
public class ExpConsultationVO extends ExpVO {
    private String subject;
    private String matter;
    private String department;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;
    @ValueType(value = "object", option_url = "/api/people/options")
    private String payeeJson;
}
