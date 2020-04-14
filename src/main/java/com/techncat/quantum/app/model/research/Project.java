package com.techncat.quantum.app.model.research;

import com.techncat.quantum.app.model.people.People;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "projects", indexes = {
        @Index(name = "projects_expenditure_no1", columnList = "expenditureNo", unique = false)
})
public class Project {
    public enum Category {
        applying, approved
    }

    public enum WayOfTaking {
        lead, cooperate
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    private String type; // 可能是枚举，不清楚选项
    @Enumerated
    private Category category;
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "leader_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People leader;

    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;
    private WayOfTaking way_of_taking;
    @Column(precision = 10, scale = 2)
    private BigDecimal approved_funds;
    @Column(length = 45)
    private String expenditureNo;
}
