package com.techncat.quantum.app.model.research;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "project_members")
public class ProjectMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    private String memberName;
    private String phone;
    private String email;
    private String institution;
    private String position_title;
    private String degree;
    private String research_direction;
}
