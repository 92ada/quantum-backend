package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    public enum Category {
        applying, approved
    }
    public enum WayOfTaking {
        lead, cooperate
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String type; // 可能是枚举，不清楚选项
    @Enumerated
    private Category category;
    @ManyToOne
    @JoinColumn(name = "leader_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People leader;
    @Column(columnDefinition="text")
    private String leaderJson;

    private Date start_date;
    private Date end_date;
    private WayOfTaking way_of_taking;
    private BigDecimal approved_funds;

    @ManyToMany
    @JoinColumn(name = "member_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<People> member;
    @Column(columnDefinition="text")
    private String membersJson;
}
