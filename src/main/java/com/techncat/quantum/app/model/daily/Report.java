package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "inviter_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People inviter;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object inviterJson;

    private Date time;
    private String title;
    private String invitee_name;
    private Integer people_count;
    private String location;
}
