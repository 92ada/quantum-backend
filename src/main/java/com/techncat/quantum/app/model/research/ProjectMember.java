package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "project_members")
public class ProjectMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    private People people;
}
