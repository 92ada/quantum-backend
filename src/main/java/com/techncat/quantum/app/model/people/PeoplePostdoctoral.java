package com.techncat.quantum.app.model.people;

import com.techncat.quantum.app.common.repo.JpaConverterJson;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "people_postdoctoral")
public class PeoplePostdoctoral {
    public enum Category {
        independent("南科大独立培养"), cooperation("联培");

        private String value;

        public String getValue() {
            return this.value;
        }

        Category(String value) {
            this.value = value;
        }
    }

    private Date updateAt;
    private Date createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supervisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People supervisor;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object supervisorJson;
    @ManyToOne
    @JoinColumn(name = "co_supervisor_people_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private People co_supervisor;
    @Column(columnDefinition = "json")
    @Convert(converter = JpaConverterJson.class)
    private Object coSupervisorJson;

    private String midterm_assessment_status;
    private String opening_assessment_status;
}
