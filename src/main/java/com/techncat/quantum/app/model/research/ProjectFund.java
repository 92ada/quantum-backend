package com.techncat.quantum.app.model.research;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "project_funds")
@Data
public class ProjectFund {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "project_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Project project;

    @Temporal(TemporalType.DATE)
    private Date arrival_date;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
    private String remark;
}
