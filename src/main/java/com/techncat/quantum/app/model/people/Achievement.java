package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    @Column(columnDefinition="text")
    private String people_json;

    private String achievement_type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<People> getPeople() {
        return people;
    }

    public void setPeople(Set<People> people) {
        this.people = people;
    }

    public String getPeople_json() {
        return people_json;
    }

    public void setPeople_json(String people_json) {
        this.people_json = people_json;
    }

    public String getAchievement_type() {
        return achievement_type;
    }

    public void setAchievement_type(String achievement_type) {
        this.achievement_type = achievement_type;
    }
}
