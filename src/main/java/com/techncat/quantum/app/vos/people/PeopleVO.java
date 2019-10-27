package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * [{
 *     value: 300123199901014444
 *     type: string
 *     index: identityNo
 * },
 * {
 *     value: 300123199901014444
 *     type: enum
 *     index: type
 *     options: ["admin", "researcher"]
 * }
 * {
 *     value: [
 *          {
 *              value: null
 *              type: string
 *              index: description
 *          },
 *     ]
 *     type: object
 *     index: lab,
 *     // option_url: "/api/labs/options"
 * }]
 */
public class PeopleVO {
    private Long id;
    private Date updateAt;
    private Date createdAt;
    // base info
    @ValueType("enumerated")
    private People.Type type;
    private People.Status status;
    private String name;
    private String identityType;
    private String identityNo;
    private String identityPhotoUrl;
    private Date birthDate;
    @ValueType("phone")
    private String phone;
    @ValueType("email")
    private String email;
    private String politicalStatus;
    private String description;
    private String emergencyContact;
    private Date entryDate;
    private Date departureDate;
    @ValueType("enumerated")
    private People.Gender gender;
    @ValueType(value = "object", option_url = "/api/labs/options")
    private Lab lab;

    public PeopleVO(People people) {
        BeanUtils.copyProperties(people, this);
    }

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

    public People.Type getType() {
        return type;
    }

    public void setType(People.Type type) {
        this.type = type;
    }

    public People.Status getStatus() {
        return status;
    }

    public void setStatus(People.Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getIdentityPhotoUrl() {
        return identityPhotoUrl;
    }

    public void setIdentityPhotoUrl(String identityPhotoUrl) {
        this.identityPhotoUrl = identityPhotoUrl;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public People.Gender getGender() {
        return gender;
    }

    public void setGender(People.Gender gender) {
        this.gender = gender;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "PeopleVO{" +
                "id=" + id +
                ", updateAt=" + updateAt +
                ", createdAt=" + createdAt +
                ", type=" + type +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", identityType='" + identityType + '\'' +
                ", identityNo='" + identityNo + '\'' +
                ", identityPhotoUrl='" + identityPhotoUrl + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", description='" + description + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", entryDate=" + entryDate +
                ", departureDate=" + departureDate +
                ", gender=" + gender +
                ", lab=" + lab +
                '}';
    }
}
