package com.techncat.quantum.app.service.finance;

import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.repository.finance.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FinanceExpDeleteService {
    @Resource
    private FinExp_Repository expRepository;
    @Resource
    private FinExpConferenceRepository expConferenceRepository;
    @Resource
    private FinExpConsultationRepository expConsultationRepository;
    @Resource
    private FinExpEquipmentRepository expEquipmentRepository;
    @Resource
    private FinExpIndirectiveRepository expIndirectiveRepository;
    @Resource
    private FinExpInternationalRepository expInternationalRepository;
    @Resource
    private FinExpLaborRepository expLaborRepository;
    @Resource
    private FinExpMaterialRepository expMaterialRepository;
    @Resource
    private FinExpOtherRepository expOtherRepository;
    @Resource
    private FinExpProcessingRepository expProcessingRepository;
    @Resource
    private FinExpPublicationRepository expPublicationRepository;
    @Resource
    private FinExpTravelRepository expTravelRepository;

    public void delete(Long expId) {
        Exp exp = expRepository.findFirstById(expId);
        if (exp == null) return;
        Exp.Type type = exp.getType();
        if (type == null) {
            expRepository.delete(exp);
            return;
        }
        switch (type) {
            case conference:
                expConferenceRepository.delete(exp.getExpConference()); break;
            case consultation:
                expConsultationRepository.delete(exp.getExpConsultation()); break;
            case equipment:
                expEquipmentRepository.delete(exp.getExpEquipment()); break;
            case indirective:
                expIndirectiveRepository.delete(exp.getExpIndirective()); break;
            case international:
                expInternationalRepository.delete(exp.getExpInternational()); break;
            case labor:
                expLaborRepository.delete(exp.getExpLabor()); break;
            case material:
                expMaterialRepository.delete(exp.getExpMaterial()); break;
            case other:
                expOtherRepository.delete(exp.getExpOther()); break;
            case processing:
                expProcessingRepository.delete(exp.getExpProcessing()); break;
            case publication:
                expPublicationRepository.delete(exp.getExpPublication()); break;
            case travel:
                expTravelRepository.delete(exp.getExpTravel()); break;
        }
        expRepository.delete(exp);
    }
}
