package com.techncat.quantum.app.service.finance;

import com.techncat.quantum.app.common.repo.RepoUtils;
import com.techncat.quantum.app.model.finance.*;
import com.techncat.quantum.app.repository.finance.*;
import com.techncat.quantum.app.vos.finance.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class FinanceExpUpdateService {

    @Autowired
    private RepoUtils repoUtils;
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


    public Exp update(Long expId, ExpVO baseVO, ExpConferenceVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpConference.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expConferenceRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpConference(postData1);
            preData2.setType(Exp.Type.conference);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expConferenceRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpConsultationVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpConsultation.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expConsultationRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpConsultation(postData1);
            preData2.setType(Exp.Type.consultation);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expConsultationRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpEquipmentVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpEquipment.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expEquipmentRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpEquipment(postData1);
            preData2.setType(Exp.Type.equipment);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expEquipmentRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpIndirectiveVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpIndirective.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expIndirectiveRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpIndirective(postData1);
            preData2.setType(Exp.Type.indirective);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expIndirectiveRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpInternationalVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpInternational.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expInternationalRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpInternational(postData1);
            preData2.setType(Exp.Type.international);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expInternationalRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpLaborVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpLabor.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expLaborRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpLabor(postData1);
            preData2.setType(Exp.Type.labor);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expLaborRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpMaterialVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpMaterial.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expMaterialRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpMaterial(postData1);
            preData2.setType(Exp.Type.material);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expMaterialRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpOtherVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpOther.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expOtherRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpOther(postData1);
            preData2.setType(Exp.Type.other);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expOtherRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpProcessingVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpProcessing.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expProcessingRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpProcessing(postData1);
            preData2.setType(Exp.Type.processing);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expProcessingRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpPublicationVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpPublication.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expPublicationRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpPublication(postData1);
            preData2.setType(Exp.Type.publication);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expPublicationRepository.save(postData1);
            return postData2;
        });
    }

    public Exp update(Long expId, ExpVO baseVO, ExpTravelVO extraVO) {
        Assert.notNull(baseVO, "data can not be null");
        Assert.notNull(extraVO, "data can not be null");
        return repoUtils.process(baseVO, extraVO, ExpTravel.class, preData1 -> {
            preData1.setUpdateAt(new Date());
            return expTravelRepository.save(preData1);
        }, Exp.class, (postData1, preData2) -> {
            // set each other
            preData2.setId(expId);
            preData2.setExpTravel(postData1);
            preData2.setType(Exp.Type.travel);
            Exp postData2 = expRepository.save(preData2);
            postData1.setExp(postData2);
            expTravelRepository.save(postData1);
            return postData2;
        });
    }
}
