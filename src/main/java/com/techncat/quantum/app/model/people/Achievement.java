package com.techncat.quantum.app.model.people;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "achievements")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToMany
    @JoinColumn(name = "people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<People> people;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object peopleJson;

    private String achievement_type;
}
