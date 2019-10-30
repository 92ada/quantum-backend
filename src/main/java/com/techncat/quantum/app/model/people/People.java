package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people")
public class People {
    public enum Type {
        admin, postdoctoral, researcher, student, teacher, visitor
    }

    public enum IdentityType {
        ID_card, passport
    }

    public enum Gender {
        male, female, other
    }
    public enum Status {
        normal, abnormal, dismissed, on_vacation
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;

    private String sid;
    @Enumerated
    private Type type;
    @Enumerated
    private Status status;
    private String name;
    private IdentityType identityType;
    private String identityNo;
    private String identityPhotoUrl;
    private Date birthDate;
    private String phone;
    private String email;
    private String politicalStatus;
    @Column(columnDefinition="text")
    private String description;
    private String emergencyContact;
    private Date entryDate;
    private Date departureDate;
    @Enumerated
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "lab_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Lab lab;

    @OneToOne
    @JoinColumn(name = "people_admin_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleAdmin peopleAdmin;
    @OneToOne
    @JoinColumn(name = "people_postdoctoral_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeoplePostdoctoral peoplePostdoctoral;
    @OneToOne
    @JoinColumn(name = "people_researcher_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleResearcher peopleResearcher;
    @OneToOne
    @JoinColumn(name = "people_student_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleStudent peopleStudent;
    @OneToOne
    @JoinColumn(name = "people_teacher_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleTeacher peopleTeacher;
    @OneToOne
    @JoinColumn(name = "people_visitor_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleVisitor peopleVisitor;


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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public PeopleAdmin getPeopleAdmin() {
        return peopleAdmin;
    }

    public void setPeopleAdmin(PeopleAdmin peopleAdmin) {
        this.peopleAdmin = peopleAdmin;
    }

    public PeoplePostdoctoral getPeoplePostdoctoral() {
        return peoplePostdoctoral;
    }

    public void setPeoplePostdoctoral(PeoplePostdoctoral peoplePostdoctoral) {
        this.peoplePostdoctoral = peoplePostdoctoral;
    }

    public PeopleResearcher getPeopleResearcher() {
        return peopleResearcher;
    }

    public void setPeopleResearcher(PeopleResearcher peopleResearcher) {
        this.peopleResearcher = peopleResearcher;
    }

    public PeopleStudent getPeopleStudent() {
        return peopleStudent;
    }

    public void setPeopleStudent(PeopleStudent peopleStudent) {
        this.peopleStudent = peopleStudent;
    }

    public PeopleTeacher getPeopleTeacher() {
        return peopleTeacher;
    }

    public void setPeopleTeacher(PeopleTeacher peopleTeacher) {
        this.peopleTeacher = peopleTeacher;
    }

    public PeopleVisitor getPeopleVisitor() {
        return peopleVisitor;
    }

    public void setPeopleVisitor(PeopleVisitor peopleVisitor) {
        this.peopleVisitor = peopleVisitor;
    }
}
