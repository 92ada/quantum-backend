package com.techncat.quantum.app.model.equipment;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String type;
    private String no;
    private String title;
    private String model;
    private BigDecimal value;
    private BigDecimal net_value;
    private String taker_institution;
    @ManyToOne
    @JoinColumn(name = "taker_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People taker;
    private String placement_site;
    private String factory_no;
    private String status;
    private int used_years;
    private int min_usage_years;
    private String inbound_date;
    @ManyToOne
    @JoinColumn(name = "admin_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People admin;
    private String document_no;
    private String remark;
}
