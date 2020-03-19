package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "people_researcher")
public class PeopleResearcher {
    public enum Position {
        researcher("研究员"),
        associate_researcher("副研究员"),
        assistant_researcher("助理研究员"),
        assistant_professor("助理教授"),
        associate_professor("副教授"),
        RA("RA"),
        engineer("工程师"),
        assistant_research_professor("助理研究教授"),
        research_professor("研究教授"),
        senior_research_scholar("高级研究学者");

        private String value;

        public String getValue() {
            return this.value;
        }

        Position(String value) {
            this.value = value;
        }
    }

    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private Position position_title;
    private String job;

    @Column(columnDefinition="text")
    private String social_job;
    @Column(columnDefinition="text")
    private String achievements;

    private Boolean is_phd_mentor;
    private Boolean is_master_mentor;
    private Boolean is_union_member;

    private String salary_card_no;
    private String bank;
    private String contract_no;
    @Temporal(TemporalType.DATE)
    private Date contract_start_date;
    @Temporal(TemporalType.DATE)
    private Date contract_end_date;

    private BigDecimal annual_salary;
    private BigDecimal monthly_salary;
    private BigDecimal housing_subsidy;
}
