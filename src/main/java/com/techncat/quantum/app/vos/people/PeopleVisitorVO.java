package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleVisitor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PeopleVisitorVO {
    // detail
    @ValueType("enumerated")
    private PeopleVisitor.Position position_title;
    private String salary_card_no;
    private String bank;
    private String citizenship;
    private String institution;
    private String research_direction;
//    private BigDecimal salary;
    private String remark;
}
