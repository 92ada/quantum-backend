package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "people_visitor")
public class PeopleVisitor {
    public enum Position {
        visiting_scholar("访问学者"),
        visiting_student("访问学生");

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

    private String salary_card_no;
    private String bank;

    private String citizenship;
    private String institution;
    private String research_direction;
    private BigDecimal salary;
    @Column(columnDefinition="text")
    private String remark;
}
