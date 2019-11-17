package com.techncat.quantum.app.excel.model.people;

import lombok.Data;

@Data
public class LabRow {
    private Long id;
    //    @ValueType(value = "person", option_url = "/api/people/options")
//    private People pi;
    private String personName;

    private String name;

    private String description;
}
