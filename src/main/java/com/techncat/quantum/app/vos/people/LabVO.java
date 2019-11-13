package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.util.Date;

@Data
public class LabVO {
    private Long id;

    private String name;
    private Date updateAt;
    private Date createdAt;

    private People pi;

    private String description;
}
