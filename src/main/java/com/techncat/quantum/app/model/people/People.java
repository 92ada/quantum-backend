package com.techncat.quantum.app.model.people;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people", indexes = {
        @Index(name = "people_index_sid", columnList = "sid", unique = true)
})
public class People {
    public enum Type {
        base, admin, postdoctoral, researcher, student, teacher, visitor
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

    @Column(length = 14)
    private String sid;
    @Enumerated
    private Type type = Type.base; // default
    @Enumerated
    private Status status = Status.normal;
    private String name;
    private IdentityType identity_type;
    private String identity_no;
    private String identity_photo_url;
    @Temporal(TemporalType.DATE)
    private Date birth_date;
    private String office_phone;
    private String mobile_phone;
    private String office_address;
    private String email;
    private String political_status;
    @Column(columnDefinition = "text")
    private String description;
    private String emergency_contact;
    @Temporal(TemporalType.DATE)
    private Date entry_date;
    @Temporal(TemporalType.DATE)
    private Date departure_date;
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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public IdentityType getIdentity_type() {
        return identity_type;
    }

    public void setIdentity_type(IdentityType identity_type) {
        this.identity_type = identity_type;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getOffice_address() {
        return office_address;
    }

    public void setOffice_address(String office_address) {
        this.office_address = office_address;
    }

    public String getIdentity_no() {
        return identity_no;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }

    public String getIdentity_photo_url() {
        return identity_photo_url;
    }

    public void setIdentity_photo_url(String identity_photo_url) {
        this.identity_photo_url = identity_photo_url;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPolitical_status() {
        return political_status;
    }

    public void setPolitical_status(String political_status) {
        this.political_status = political_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
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
