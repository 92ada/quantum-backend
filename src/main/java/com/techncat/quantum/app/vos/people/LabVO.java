package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.util.Date;

@Data
public class LabVO {
    private Long id;
    @ValueType(value = "person", option_url = "/api/people/options")
    private People pi;
    private String name;
    private String description;
}
