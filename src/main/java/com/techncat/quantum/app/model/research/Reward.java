package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rewards")
public class Reward {
    public enum Level {
        national, provincial, local, other
    }
    public enum Grade {
        special, first, second, third, other
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "rewarded_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People rewarded;

    private String title;
    private String issue_institution;
    @Enumerated
    private Level level;
    @Enumerated
    private Grade grade;
    private Date date;
    private String remark;
}
