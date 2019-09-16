package com.techncat.quantum.app.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people_family")
public class PeopleFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People people;

    private String name;
    private String relationship;
    private String identityType;
    private String identityNo;
    private Date birthDate;
    private String phone;
    private String email;
    private String politicalStatus;
    private String remark;
}
