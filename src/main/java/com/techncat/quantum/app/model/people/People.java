package com.techncat.quantum.app.model.people;

import com.techncat.quantum.app.service.people.lab.LabService;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "people", indexes = {
        @Index(name = "people_index_sid", columnList = "sid", unique = true)
})
public class People {
    public enum Type {
        base("base"), administration("行政人员"), postdoctoral("博士后"), researcher("科研人员"), student("学生"), teacher("教辅人员"), visitor("访问人员");
        private String value;

        public String getValue() {
            return this.value;
        }

        Type(String value) {
            this.value = value;
        }
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
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "lab_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Lab> lab;

    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_admin_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleAdmin peopleAdmin;
    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_postdoctoral_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeoplePostdoctoral peoplePostdoctoral;
    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_researcher_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleResearcher peopleResearcher;
    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_student_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleStudent peopleStudent;
    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_teacher_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleTeacher peopleTeacher;
    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "people_visitor_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PeopleVisitor peopleVisitor;

    public List<Lab> getLab() {
        if (this.lab == null) return null;

        ArrayList<Lab> _lab = new ArrayList<>();
        for (Lab lb : this.lab) {
            _lab.add(LabService.avoidRef(lb));
        }
        return _lab;
    }
 }
