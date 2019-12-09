package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "people_lab")
public class PeopleLab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "people_id")
    private Long peopleId;
    @Column(name = "lab_id")
    private Long labId;
}
