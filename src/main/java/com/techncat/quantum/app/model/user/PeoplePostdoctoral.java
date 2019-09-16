package com.techncat.quantum.app.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people_postdoctoral")
public class PeoplePostdoctoral {
    private Date updateAt;
    private Date createdAt;

    @Id
    private Long people_id;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String edu_system;
    private String category;

    @OneToOne
    @JoinColumn(name = "advisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People advisor;
    @OneToOne
    @JoinColumn(name = "vice_advisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People vice_advisor;

    private String midtermAssessmentStatus;
    private String openingAssessmentStatus;
}
