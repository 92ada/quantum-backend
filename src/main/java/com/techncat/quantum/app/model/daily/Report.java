package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "inviter_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People inviter;

    private Date time;
    private String title;
    private String invitee_name;
    private Integer people_count;
    private String location;
}
