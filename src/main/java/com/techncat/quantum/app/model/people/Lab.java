package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "labs")
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "pi_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People pi;

    @Column(columnDefinition = "text")
    private String description;
}
