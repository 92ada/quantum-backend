package com.techncat.quantum.app.vos.people;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.techncat.quantum.app.common.auth.annotation.Visible;
import com.techncat.quantum.app.common.voenhance.annotation.Editable;
import com.techncat.quantum.app.common.voenhance.annotation.Required;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [{
 *     value: 300123199901014444
 *     type: string
 *     index: identity_no
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

@Data
public class PeopleVO {
    private Long id;
    @Required(true)
    private String sid;
    @ValueType("photo")
    private String identity_photo_url;
    // base info
    @ValueType("enumerated")
    @Editable(false)
    private People.Type type;
    @ValueType("enumerated")
    private People.Status status;
    private String name;
    @ValueType("enumerated")
    private People.IdentityType identity_type;
    private String identity_no;
    @Visible(requiredRoles = {Visible.ROLE.root, Visible.ROLE.admin})
    private Date birth_date;
    @ValueType("phone")
    private String office_phone;
    @ValueType("phone")
    private String mobile_phone;
    private String office_address;
    @ValueType("email")
    private String email;
    private String political_status;
    private String description;
    private String emergency_contact;
    private Date entry_date;
    private Date departure_date;
    @ValueType("enumerated")
    private People.Gender gender;
    @ValueType(value = "labs", option_url = "/api/labs/options")
    private List<Lab> lab;

    public static PeopleVO renderSimple(People person) {
        PeopleVO vo = new PeopleVO();
        vo.id = person.getId();
        vo.name = person.getName();
        return vo;
    }
    public static List<PeopleVO> renderSimple(List<People> people) {
        if (people == null) return new ArrayList<>();
        return people.parallelStream().map(PeopleVO::renderSimple).collect(Collectors.toList());
    }

    public List<LabVO> getLab() {
        return LabVO.renderSimple(this.lab);
    }

    @Data
    public class PeopleSimpleVO {
        Long id;
        String name;
    }

    public class PeopleSimpleSerializer extends JsonSerializer<People> {
        @Override
        public void serialize(People people, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            PeopleSimpleVO simpleVO = new PeopleSimpleVO();
            simpleVO.setId(people.getId());
            simpleVO.setName(people.getName());
            try {
                jsonGenerator.writeObject(simpleVO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
