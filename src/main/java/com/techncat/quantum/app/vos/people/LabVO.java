package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class LabVO {
    private Long id;
    @ValueType(value = "person", option_url = "/api/people/options")
    private People pi;
    private String name;
    private String description;

    public static LabVO renderSimple(Lab lab) {
       LabVO labVO = new LabVO();
       labVO.id = lab.getId();
       labVO.name = lab.getName();
       return labVO;
    }
    public static List<LabVO> renderSimple(List<Lab> labs) {
        if (labs == null) return new ArrayList<>();
        return labs.parallelStream().map(LabVO::renderSimple).collect(Collectors.toList());
    }
}
