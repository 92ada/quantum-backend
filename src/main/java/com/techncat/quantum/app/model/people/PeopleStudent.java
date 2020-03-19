package com.techncat.quantum.app.model.people;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "people_student")
public class PeopleStudent {
    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String edu_system;
    private String major;

    @ManyToOne
    @JoinColumn(name = "advisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People advisor;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private String advisorJson;
    @ManyToOne
    @JoinColumn(name = "vice_advisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People vice_advisor;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object viceAdvisorJson;

    private String midterm_assessment_status;
    private String opening_assessment_status;
}
