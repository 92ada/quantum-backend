package com.techncat.quantum.app.vos.research;

import lombok.Data;

@Data
public class ProjectMemberVO {
    private Long id;

    private String memberName;
    private String phone;
    private String email;
    private String institution;
    private String position_title;
    private String degree;
    private String research_direction;
}
