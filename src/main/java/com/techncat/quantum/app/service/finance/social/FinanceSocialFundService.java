package com.techncat.quantum.app.service.finance.social;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.SocialFund;
import com.techncat.quantum.app.repository.finance.FinSocialFundRepository;
import com.techncat.quantum.app.vos.finance.SocialFundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FinanceSocialFundService {
    @Resource
    private FinSocialFundRepository repository;
    @Autowired
    private VOUtils voUtils;

    public List<SocialFund> list(Date start, Date end) {
        return repository.findAllByDateBetween(start, end);
    }

    public Page<SocialFund> page(Date start, Date end, Pageable pageable) {
        return repository.findAllByDateBetween(start, end, pageable);
    }

    public SocialFund fetch(Long id) {
        SocialFund fund = repository.findFirstById(id);
        if (fund == null) throw new SocialFundNotFoundException(id);
        return fund;
    }

    public SocialFund create(SocialFundVO vo) {
        SocialFund data = voUtils.copy(vo, SocialFund.class);
        data.setId(null);
        data.setCreatedAt(new Date());
        data.setUpdateAt(new Date());
        return repository.save(data);
    }

    public SocialFund update(Long id, SocialFundVO vo) {
        SocialFund data = voUtils.copy(vo, SocialFund.class);
        data.setId(id);
        data.setUpdateAt(new Date());
        return repository.save(data);
    }

    public void delete(Long id) {
        SocialFund fund = fetch(id);
        repository.delete(fund);
    }

    public static class SocialFundNotFoundException extends RuntimeException {
        SocialFundNotFoundException(Long id) {
            super("SocialFund not found, id=[" + id + "]");
        }
    }
}
