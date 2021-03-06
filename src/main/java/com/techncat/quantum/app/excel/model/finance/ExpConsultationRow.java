package com.techncat.quantum.app.excel.model.finance;

import lombok.Data;

@Data
public class ExpConsultationRow {
    private String subject;
    private String matter;
    private String department;

    private String handlerName;
    private String payeeName;
}
