package com.techncat.quantum.app.vos.people;

import com.techncat.quantum.app.model.people.People;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
public class AchievementVO {
    private Long id;

    private People people;

    private String achievement_type;
}
