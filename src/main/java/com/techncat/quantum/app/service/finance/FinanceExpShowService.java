package com.techncat.quantum.app.service.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.repository.finance.FinExp_Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FinanceExpShowService {
    @Resource
    private FinExp_Repository repository;

    public Exp fetch(Long id) {
        Exp exp = repository.findFirstById(id);
        if (exp == null) throw new FinanceExpException(id);
        return exp;
    }

    public Object fetchDetail(Long id) {
        Exp exp = fetch(id);
        if (exp.getType() == null) return null;
        switch (exp.getType()) {
            case conference:
                return exp.getExpConference();
            case consultation:
                return exp.getExpConsultation();
            case equipment:
                return exp.getExpEquipment();
            case indirective:
                return exp.getExpIndirective();
            case international:
                return exp.getExpInternational();
            case labor:
                return exp.getExpLabor();
            case material:
                return exp.getExpMaterial();
            case other:
                return exp.getExpOther();
            case processing:
                return exp.getExpProcessing();
            case publication:
                return exp.getExpPublication();
            case travel:
                return exp.getExpTravel();
            default:
                return null;
        }
    }

    public class FinanceExpException extends RuntimeException {
        FinanceExpException(Long id) {
            super("Finance Exp not found. id[" + id + "]");
        }
    }
}
