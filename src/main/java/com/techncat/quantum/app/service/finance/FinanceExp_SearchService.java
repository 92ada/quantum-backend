package com.techncat.quantum.app.service.finance;

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

@Service
public class FinanceExp_SearchService {

    @Resource
    private FinExp_Repository repository;
    @Resource
    private ResearchProjectAdminRepository projectAdminRepository;
    @Autowired
    private PeopleShowService peopleShowService;

    public Page<Exp> search(Date start, Date end, PageRequest pageRequest) {
        if (start == null || end == null) {
            return repository.findAll(pageRequest);
        }
        return repository.findAllByDateBetween(start, end, pageRequest);
    }

    public Page<Exp> search(Date start, Date end, Exp.Type type, PageRequest pageRequest) {
        if (start == null || end == null) {
            return repository.findAllByType(type, pageRequest);
        }
        return repository.findAllByTypeAndDateBetween(type, start, end, pageRequest);
    }

    public Page<Exp> search(String sid, Date start, Date end, PageRequest pageRequest) {
        if (start == null || end == null) {
            return repository.findAll(pageRequest);
        }
        return repository.findAllByDateBetweenAndExpenditureNoIn(start, end, this.availableENOs(sid), pageRequest);
    }

    public Page<Exp> search(String sid, Date start, Date end, Exp.Type type, PageRequest pageRequest) {
        if (start == null || end == null) {
            return repository.findAllByTypeAndExpenditureNoIn(type, this.availableENOs(sid), pageRequest);
        }
        return repository.findAllByTypeAndDateBetweenAndExpenditureNoIn(type, start, end, this.availableENOs(sid), pageRequest);
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
