package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.people.PeopleLab;
import com.techncat.quantum.app.repository.people.LabRepository;
import com.techncat.quantum.app.repository.people.PeopleLabRepository;
import com.techncat.quantum.app.repository.people.People_Repository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LabRunner {
    @Resource
    private People_Repository peopleRepository;
    @Resource
    private LabRepository labRepository;
    @Resource
    private PeopleLabRepository peopleLabRepository;

    public List<Long> fixUserIds(String visitSid) {
        List<PeopleLab> pls = peopleLabRepository.findAllByLabIdIn(this.findVisitableLabIds(visitSid));
        Set<Long> ids = pls.parallelStream().map(PeopleLab::getPeopleId).collect(Collectors.toSet());
        ids.add(peopleRepository.findFirstBySid(visitSid).getId());
        return new ArrayList<>(ids);
    }

    // 找到合适的访问区间，根据该人员的所属实验室
    public List<Long> findVisitableLabIds(String sid) {
        List<Long> ids = new ArrayList<>();
        People me = peopleRepository.findFirstBySid(sid);
        if (me == null) return ids; // 如果访问者不在库内
        // 判断访问者所属实验室
        List<Lab> labs = me.getLab();
        List<Lab> LABS = labRepository.findAll();
        return this.findVisitableLabIds(LABS, labs);
    }

    // 可访问的lab有哪些？
    private List<Long> findVisitableLabIds(List<Lab> LABS, List<Lab> myLabs) {
        if (myLabs.isEmpty()) return new ArrayList<>();
        if (LABS.isEmpty()) return new ArrayList<>();
        return this.create(LABS, myLabs);
    }

    /**
     * 构建成一棵树，然后获取可查询的节点
     *
     * @param labs      全部实验室
     * @param whichLabs 自己所属的实验室
     * @return
     */
    private List<Long> create(List<Lab> labs, List<Lab> whichLabs) {
        Map<Long, LabNode> labMap = new HashMap<>();

        // 全部存进 map
        for (Lab lab : labs) {
            LabNode node = labMap.get(lab.getId());
            if (node == null) {
                LabNode labNode = new LabNode();
                labNode.setChildren(new ArrayList<>());
                labNode.setId(lab.getId());
                labNode.setLevel(lab.getLevel());
                labMap.put(lab.getId(), labNode);
            }
        }
        for (Lab lab : labs) {
            Lab fatherLab = lab.getFatherLab();
            if (fatherLab == null) continue;
            LabNode myFatherNode = labMap.get(fatherLab.getId());
            LabNode myNode = labMap.get(lab.getId());
            if (myNode != null && myFatherNode != null) { // 找到了父节点
                myFatherNode.getChildren().add(myNode);
            }
        }
        // 提取需要的 lab 们
        List<Long> IDS = new ArrayList<>();
        for (Lab lab : whichLabs) {
            List<Long> labIds = this.fetchLabIds(labMap.get(lab.getId()), lab.getLevel());
            IDS.addAll(labIds);
        }
        return IDS.parallelStream().distinct().collect(Collectors.toList());
    }

    // 提取 id
    private List<Long> fetchLabIds(LabNode node, Integer level) {
        List<Long> ids = new ArrayList<>();
        if (node.getLevel() <= level) {
            ids.add(node.getId());
            process(node, level, ids);
        }
        return ids;
    }

    private void process(LabNode father, Integer level, List<Long> container) {
        if (father == null || father.getChildren() == null) return;
        for (LabNode node : father.getChildren()) {
            if (node.getLevel() <= level) { // 当等级在用户所属等级范围内时，符合要求
                container.add(node.getId());
                process(node, level, container);
            }
        }
    }

    @Data
    class LabNode {
        private Long id;
        private int level = 9;
        private List<LabNode> children = new ArrayList<>();
    }

}
