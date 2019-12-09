package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.Lab;

import java.util.ArrayList;
import java.util.List;

public class LabRunnerTest {
    public static void main(String[] args) {
        List<Lab> labs = new ArrayList<>();
        Lab a = createLab(1L, 0);
        Lab b = createLab(2L, 3);
        Lab c = createLab(3L, 0);
        Lab a0 = createLab(10L, 1, a);
        Lab a1 = createLab(11L, 1, a);
        Lab a2 = createLab(12L, 1, a);
        Lab a3 = createLab(13L, 1, a);
        Lab b0 = createLab(20L, 1, b);
        Lab b1 = createLab(21L, 0, b);
        Lab b2 = createLab(22L, 1, b);
        Lab b3 = createLab(23L, 1, b);
        labs.add(a);
        labs.add(b);
        labs.add(c);
        labs.add(a0);
        labs.add(a1);
        labs.add(a2);
        labs.add(a3);
        labs.add(b0);
        labs.add(b1);
        labs.add(b2);
        labs.add(b3);
        LabRunner runner = new LabRunner();
        List<Lab> myLabs = new ArrayList<>();
        myLabs.add(a1);
        myLabs.add(b);
        List<Long> labIds = runner.findVisitableLabIds(labs, myLabs);
        System.out.println(labIds);
    }

    private static Lab createLab(Long id, Integer level) {
        Lab lab = new Lab();
        lab.setId(id);
        lab.setLevel(level);
        return lab;
    }
    private static Lab createLab(Long id, Integer level, Lab father) {
        Lab lab = new Lab();
        lab.setId(id);
        lab.setLevel(level);
        lab.setFatherLab(father);
        return lab;
    }
}
