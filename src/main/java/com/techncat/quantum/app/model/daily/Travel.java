package com.techncat.quantum.app.model.daily;


import com.techncat.quantum.app.common.repo.JpaConverterJson;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "travels")
public class Travel {
    public enum Type {
        conference("会议"), cooperation("合作");

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date updateAt;
    private Date createdAt;


    @ManyToOne
    @JoinColumn(name = "traveler_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People traveler;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object travelerJson;
    @Enumerated
    private Type type;
    @Column(precision = 10, scale = 2)
    private BigDecimal budget;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    private IdentityType identity_type;
    private String identity_no;
}
