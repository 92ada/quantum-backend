package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleTeacher;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PeopleTeacherVO {
    // detail
    private String position_title;
    private String job;
    private String social_job;
    private String achievements;
    private Boolean is_phd_mentor;
    private Boolean is_master_mentor;
    private Boolean is_union_member;
    private String salary_card_no;
    private String bank;
    private String contract_no;
    private Date contract_start_date;
    private Date contract_end_date;
    private BigDecimal annual_salary;
    private BigDecimal monthly_salary;
    private BigDecimal housing_subsidy;
}
