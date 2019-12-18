package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "project_admins")
public class ProjectAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    private People people;
}
