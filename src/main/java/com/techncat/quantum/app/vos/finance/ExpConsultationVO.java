package com.techncat.quantum.app.vos.finance;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.ExpConsultation;
import com.techncat.quantum.app.model.people.People;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class ExpConsultationVO extends ExpVO {
    private String subject;
    private String matter;
    private String department;

    @ValueType(value = "object", option_url = "/api/people/options")
    private String handlerJson;
    @ValueType(value = "object", option_url = "/api/people/options")
    private String payeeJson;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHandlerJson() {
        return handlerJson;
    }

    public void setHandlerJson(String handlerJson) {
        this.handlerJson = handlerJson;
    }

    public String getPayeeJson() {
        return payeeJson;
    }

    public void setPayeeJson(String payeeJson) {
        this.payeeJson = payeeJson;
    }
}
