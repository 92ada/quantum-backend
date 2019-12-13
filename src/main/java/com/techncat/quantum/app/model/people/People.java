package com.techncat.quantum.app.model.people;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "people", indexes = {
        @Index(name = "people_index_sid", columnList = "sid", unique = true)
})
public class People {
    public enum Type {
        base, administration, postdoctoral, researcher, student, teacher, visitor
    }

    public enum IdentityType {
        ID_card("身份证"), passport("护照");
        private String value;

        public String getValue() {
            return this.value;
        }

        IdentityType(String value) {
            this.value = value;
        }
    }

    public enum Gender {
        male("男"), female("女"), other("其他");
        private String value;

        public String getValue() {
            return this.value;
        }

        Gender(String value) {
            this.value = value;
        }
    }

    public enum Status {
        normal("正常"), abnormal("非正常"), dismissed("离职"), on_vacation("休假");
        private String value;

        public String getValue() {
            return this.value;
        }

        Status(String value) {
            this.value = value;
        }
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

    @ManyToMany
    @JoinColumn(name = "lab_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Lab> lab;

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
}
