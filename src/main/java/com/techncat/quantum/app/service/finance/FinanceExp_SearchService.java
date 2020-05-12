package com.techncat.quantum.app.service.finance;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.ProjectAdmin;
import com.techncat.quantum.app.repository.finance.FinExp_Repository;
import com.techncat.quantum.app.repository.research.ResearchProjectAdminRepository;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.techncat.quantum.app.common.auth.AuthUtil.isRoot;

@Service
public class FinanceExp_SearchService {

    @Resource
    private FinExp_Repository repository;
    @Resource
    private ResearchProjectAdminRepository projectAdminRepository;
    @Autowired
    private PeopleShowService peopleShowService;

    public Page<Exp> search(Aser aser, Date start, Date end, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return repository.findAll(pageRequest);
        }
        if (start == null || end == null) {
            return repository.findAllByExpenditureNoIn(this.availableENOs(aser.getSid()), pageRequest);
        }
        return repository.findAllByDateBetweenAndExpenditureNoIn(start, end, this.availableENOs(aser.getSid()), pageRequest);
    }

    public Page<Exp> search(Aser aser, Date start, Date end, Exp.Type type, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return repository.findAll(pageRequest);
        }
        if (start == null || end == null) {
            return repository.findAllByTypeAndExpenditureNoIn(type, this.availableENOs(aser.getSid()), pageRequest);
        }
        return repository.findAllByTypeAndDateBetweenAndExpenditureNoIn(type, start, end, this.availableENOs(aser.getSid()), pageRequest);
    }



    private List<String> availableENOs(String sid) {
        try {
            People people = peopleShowService.fetchBySid(sid);
            List<String> ids = new ArrayList<>();
            for (ProjectAdmin pa : projectAdminRepository.findAllByPeople(people)) {
                if (pa.getProject() != null) {
                    ids.add(pa.getProject().getExpenditureNo());
                }
            }
            return ids;
        } catch (PeopleShowService.PeopleNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
