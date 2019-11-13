package com.techncat.quantum.app.service.finance.social;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.SocialInsurance;
import com.techncat.quantum.app.repository.finance.FinSocialInsuranceRepository;
import com.techncat.quantum.app.vos.finance.SocialInsuranceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class FinanceSocialInsuranceService {
    @Resource
    private FinSocialInsuranceRepository repository;
    @Autowired
    private VOUtils voUtils;

    public SocialInsurance fetch(Long id) {
        SocialInsurance fund = repository.findFirstById(id);
        if (fund == null) throw new SocialInsuranceNotFoundException(id);
        return fund;
    }

    public SocialInsurance create(SocialInsuranceVO vo) {
        SocialInsurance data = voUtils.copy(vo, SocialInsurance.class);
        data.setId(null);
        data.setCreatedAt(new Date());
        data.setUpdateAt(new Date());
        return repository.save(data);
    }

    public SocialInsurance update(Long id, SocialInsuranceVO vo) {
        SocialInsurance data = voUtils.copy(vo, SocialInsurance.class);
        data.setId(id);
        data.setUpdateAt(new Date());
        return repository.save(data);
    }

    public void delete(Long id) {
        SocialInsurance fund = fetch(id);
        repository.delete(fund);
    }

    public static class SocialInsuranceNotFoundException extends RuntimeException {
        SocialInsuranceNotFoundException(Long id) {
            super("SocialInsurance not found, id=[" + id + "]");
        }
    }
}
