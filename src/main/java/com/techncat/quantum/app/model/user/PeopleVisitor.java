package com.techncat.quantum.app.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people_visitor")
public class PeopleVisitor {
    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String positionTitle;

    private String salaryCardNo;
    private String bank;

    private String citizenship;
    private String institution;
    private String researchDirection;
    private float salary;
    @Column(columnDefinition="text")
    private String remark;
}
