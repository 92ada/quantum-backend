package com.techncat.quantum.app.model.equipment;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String type;
    private String no;
    private String title;
    private String model;
    @Column(precision = 10, scale = 2)
    private BigDecimal value;
    @Column(precision = 10, scale = 2)
    private BigDecimal net_value;
    private String taker_institution;
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "taker_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People taker;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object takerJson;
    private String placement_site;
    private String factory_no;
    private String status;
    private Integer used_years;
    private Integer min_usage_years;
    @Temporal(TemporalType.DATE)
    private Date inbound_date;
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "admin_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People admin;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object adminJson;
    private String document_no;
    private String remark;
}
