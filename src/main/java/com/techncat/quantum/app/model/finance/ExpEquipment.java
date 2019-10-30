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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Exp exp;

    private Type purchase_type;
    private Integer payment_status;
    private String inbound_no;
    @Column(precision=10, scale=2)
    private BigDecimal warranty_amount;
    private Date warranty_date;

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

    public Exp getExp() {
        return exp;
    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    public Type getPurchase_type() {
        return purchase_type;
    }

    public void setPurchase_type(Type purchase_type) {
        this.purchase_type = purchase_type;
    }

    public Integer getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(Integer payment_status) {
        this.payment_status = payment_status;
    }

    public String getInbound_no() {
        return inbound_no;
    }

    public void setInbound_no(String inbound_no) {
        this.inbound_no = inbound_no;
    }

    public BigDecimal getWarranty_amount() {
        return warranty_amount;
    }

    public void setWarranty_amount(BigDecimal warranty_amount) {
        this.warranty_amount = warranty_amount;
    }

    public Date getWarranty_date() {
        return warranty_date;
    }

    public void setWarranty_date(Date warranty_date) {
        this.warranty_date = warranty_date;
    }
}
