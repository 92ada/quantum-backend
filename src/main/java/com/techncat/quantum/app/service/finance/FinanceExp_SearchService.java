package com.techncat.quantum.app.service.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.repository.finance.FinExp_Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FinanceExp_SearchService {

    @Resource
    private FinExp_Repository repository;

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

    public List<Exp> search(Date start, Date end) {
        return repository.findAllByDateBetween(start, end);
    }
}
