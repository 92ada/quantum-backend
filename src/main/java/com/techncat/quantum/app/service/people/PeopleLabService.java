package com.techncat.quantum.app.service.people;

import com.techncat.quantum.app.model.people.PeopleLab;
import com.techncat.quantum.app.repository.people.PeopleLabRepository;
import com.techncat.quantum.app.vos.people.LabVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleLabService {
    @Resource
    private PeopleLabRepository repository;

    public void resetLabs(Long peopleId, List<LabVO> labVOS) {
        if (labVOS.isEmpty()) return;
        this.update(peopleId, labVOS.parallelStream().map(LabVO::getId).collect(Collectors.toList()));
    }

    public void update(Long peopleId, Long labId) {
        PeopleLab pl = repository.findFirstByPeopleIdAndLabId(peopleId, labId);
        if (pl == null) {
            pl = new PeopleLab();
            pl.setPeopleId(peopleId);
            pl.setLabId(labId);
            repository.save(pl);
        }
    }

    public void update(Long peopleId, List<Long> labIds) {
        if (labIds == null) return;
        labIds.parallelStream().forEach(labId -> this.update(peopleId, labId));
    }
}
