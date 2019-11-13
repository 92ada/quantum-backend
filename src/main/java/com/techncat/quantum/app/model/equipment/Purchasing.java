package com.techncat.quantum.app.model.equipment;


import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "purchasings")
public class Purchasing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String title;
    @Column(precision=10, scale=2)
    private BigDecimal budget;
    private Boolean is_imported;
    private String purchasing_method;
    private String argument_method;
    @Temporal(TemporalType.DATE)
    private Date request_date;

    @ManyToOne
    @JoinColumn(name = "handler_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People handler;
    @Column(columnDefinition="json")
    @Convert(converter = JpaConverterJson.class)
    private Object handlerJson;
    @ManyToOne
    @JoinColumn(name = "pi_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People pi;
    @Column(columnDefinition="text")
    private String piJson;

    private Boolean is_finished;
    private String status;
    private String supplier_reply_delivery_time;
    private String bid_winning_supplier;
    @Column(precision=10, scale=2)
    private BigDecimal contract_amount;
    @Column(precision=10, scale=2)
    private BigDecimal paid_amount;
    @Temporal(TemporalType.DATE)
    private Date contract_date;
    private String placement_site;
    private String funding_source;
    private String contract_no;
    private String payment_details;
    private String manufacturer;
    private String supplier_contact_person;
    private String supplier_contact_phone;
    private String supplier_contact_email;
    private String remark;
}
