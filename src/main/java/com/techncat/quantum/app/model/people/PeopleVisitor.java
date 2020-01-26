package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "people_visitor")
public class PeopleVisitor {
    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String position_title;

    private String salary_card_no;
    private String bank;

    private String citizenship;
    private String institution;
    private String research_direction;
    private BigDecimal salary;
    @Column(columnDefinition="text")
    private String remark;
}
