package com.techncat.quantum.app.service.finance.social;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.SocialFund;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.finance.FinSocialFundRepository;
import com.techncat.quantum.app.service.people.LabRunner;
import com.techncat.quantum.app.vos.finance.SocialFundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.techncat.quantum.app.common.auth.AuthUtil.isRoot;

@Service
public class FinanceSocialFundService {
    @Resource
    private FinSocialFundRepository repository;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private LabRunner runner;

    public Page<SocialFund> page(Aser aser, Date start, Date end, Pageable pageable) {
        if (isRoot(aser)) {
            return repository.findAllByDateBetween(start, end, pageable);
        }
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        return repository.findAllByDateBetweenAndPeople_IdIn(start, end, peopleIds, pageable);
    }

    public SocialFund fetch(Long id) {
        SocialFund fund = repository.findFirstById(id);
        if (fund == null) throw new SocialFundNotFoundException(id);
        return fund;
    }

    public SocialFund create(SocialFundVO vo) {
        SocialFund data = voUtils.copy(vo, SocialFund.class);
        People _people = new People();
        _people.setId(vo.getPeople().getId());
        data.setPeople(_people);
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
