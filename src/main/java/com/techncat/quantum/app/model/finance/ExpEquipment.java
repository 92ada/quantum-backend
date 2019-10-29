package com.techncat.quantum.app.model.finance;


import com.techncat.quantum.app.model.people.Lab;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "exp_equipments")
public class ExpEquipment {
    public enum Type {
        daily, contract
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    private Type purchase_type;
    private Integer payment_status;
    private String inbound_no;
    private BigDecimal warranty_amount;
    private Date warranty_date;
}
