package com.techncat.quantum.app.model.equipment;


import com.techncat.quantum.app.model.people.People;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
    @Column(precision=10, scale=2)
    private BigDecimal value;
    @Column(precision=10, scale=2)
    private BigDecimal net_value;
    private String taker_institution;
    @ManyToOne
    @JoinColumn(name = "taker_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People taker;
    @Column(columnDefinition="text")
    private String takerJson;
    private String placement_site;
    private String factory_no;
    private String status;
    private Integer used_years;
    private Integer min_usage_years;
    private String inbound_date;
    @ManyToOne
    @JoinColumn(name = "admin_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People admin;
    @Column(columnDefinition="text")
    private String adminJson;
    private String document_no;
    private String remark;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getNet_value() {
        return net_value;
    }

    public void setNet_value(BigDecimal net_value) {
        this.net_value = net_value;
    }

    public String getTaker_institution() {
        return taker_institution;
    }

    public void setTaker_institution(String taker_institution) {
        this.taker_institution = taker_institution;
    }

    public People getTaker() {
        return taker;
    }

    public void setTaker(People taker) {
        this.taker = taker;
    }

    public String getPlacement_site() {
        return placement_site;
    }

    public void setPlacement_site(String placement_site) {
        this.placement_site = placement_site;
    }

    public String getFactory_no() {
        return factory_no;
    }

    public void setFactory_no(String factory_no) {
        this.factory_no = factory_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUsed_years() {
        return used_years;
    }

    public void setUsed_years(Integer used_years) {
        this.used_years = used_years;
    }

    public Integer getMin_usage_years() {
        return min_usage_years;
    }

    public void setMin_usage_years(Integer min_usage_years) {
        this.min_usage_years = min_usage_years;
    }

    public String getInbound_date() {
        return inbound_date;
    }

    public void setInbound_date(String inbound_date) {
        this.inbound_date = inbound_date;
    }

    public People getAdmin() {
        return admin;
    }

    public void setAdmin(People admin) {
        this.admin = admin;
    }

    public String getDocument_no() {
        return document_no;
    }

    public void setDocument_no(String document_no) {
        this.document_no = document_no;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTakerJson() {
        return takerJson;
    }

    public void setTakerJson(String takerJson) {
        this.takerJson = takerJson;
    }

    public String getAdminJson() {
        return adminJson;
    }

    public void setAdminJson(String adminJson) {
        this.adminJson = adminJson;
    }
}
