package com.techncat.quantum.app.model.finance;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "exp_equipments")
public class ExpEquipment {
    public enum Type {
        daily, contract
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    private Type purchase_type;
    private Integer payment_status;
    private String inbound_no;
    @Column(precision = 10, scale = 2)
    private BigDecimal warranty_amount;
    @Temporal(TemporalType.DATE)
    private Date warranty_date;
}
