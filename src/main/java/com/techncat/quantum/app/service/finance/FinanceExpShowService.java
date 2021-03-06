package com.techncat.quantum.app.service.finance;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.repository.finance.FinExp_Repository;
import com.techncat.quantum.app.vos.finance.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FinanceExpShowService {
    @Resource
    private FinExp_Repository repository;
    @Autowired
    private VOUtils voUtils;

    public Exp fetch(Long id) {
        Exp exp = repository.findFirstById(id);
        if (exp == null) throw new FinanceExpException(id);
        return exp;
    }

    public Object fetchDetailVO(Long id) {
        Exp exp = fetch(id);
        if (exp.getType() == null) return null;
        switch (exp.getType()) {
            case conference:
                return voUtils.copy(exp.getExpConference(), ExpConferenceVO.class);
            case consultation:
                return voUtils.copy(exp.getExpConsultation(), ExpConsultationVO.class);
            case equipment:
                return voUtils.copy(exp.getExpEquipment(), ExpEquipmentVO.class);
            case indirective:
                return voUtils.copy(exp.getExpIndirective(), ExpIndirectiveVO.class);
            case international:
                return voUtils.copy(exp.getExpInternational(), ExpInternationalVO.class);
            case labor:
                return voUtils.copy(exp.getExpLabor(), ExpLaborVO.class);
            case material:
                return voUtils.copy(exp.getExpMaterial(), ExpMaterialVO.class);
            case other:
                return voUtils.copy(exp.getExpOther(), ExpOtherVO.class);
            case processing:
                return voUtils.copy(exp.getExpProcessing(), ExpProcessingVO.class);
            case publication:
                return voUtils.copy(exp.getExpPublication(), ExpPublicationVO.class);
            case travel:
                return voUtils.copy(exp.getExpTravel(), ExpTravelVO.class);
            default:
                return null;
        }
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
