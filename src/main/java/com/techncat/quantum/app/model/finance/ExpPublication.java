package com.techncat.quantum.app.model.finance;

import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exp_publications")
public class ExpPublication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

//    @OneToOne
//    @JoinColumn(name = "exp_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private Exp exp;

    private String subject;
    private String matter;
    private String department;

    @ManyToOne
    @JoinColumn(name = "handler_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People handler;
    @Column(columnDefinition="text")
    private String handlerJson;

    @ManyToOne
    @JoinColumn(name = "payee_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People payee;
    @Column(columnDefinition="text")
    private String payeeJson;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public People getHandler() {
        return handler;
    }

    public void setHandler(People handler) {
        this.handler = handler;
    }

    public People getPayee() {
        return payee;
    }

    public void setPayee(People payee) {
        this.payee = payee;
    }

    public String getHandlerJson() {
        return handlerJson;
    }

    public void setHandlerJson(String handlerJson) {
        this.handlerJson = handlerJson;
    }

    public String getPayeeJson() {
        return payeeJson;
    }

    public void setPayeeJson(String payeeJson) {
        this.payeeJson = payeeJson;
    }
}
