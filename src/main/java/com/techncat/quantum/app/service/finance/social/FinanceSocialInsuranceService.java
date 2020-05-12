package com.techncat.quantum.app.service.finance.social;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.SocialInsurance;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.finance.FinSocialInsuranceRepository;
import com.techncat.quantum.app.service.people.LabRunner;
import com.techncat.quantum.app.vos.finance.SocialInsuranceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.techncat.quantum.app.common.auth.AuthUtil.isRoot;

@Service
@Transactional
public class FinanceSocialInsuranceService {
    @Resource
    private FinSocialInsuranceRepository repository;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private LabRunner runner;

    public Page<SocialInsurance> page(Aser aser, Date start, Date end, Pageable pageable) {
        if (isRoot(aser)) {
            return avoidRef(repository.findAllByDateBetween(start, end, pageable));
        }
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        return avoidRef(repository.findAllByDateBetweenAndPeople_IdIn(start, end, peopleIds, pageable));
    }

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

    private static List<SocialInsurance> avoidRef(List<SocialInsurance> list) {
        return list.stream().map(FinanceSocialInsuranceService::avoidRef).collect(Collectors.toList());
    }

    private static Page<SocialInsurance> avoidRef(Page<SocialInsurance> page) {
        return page.map(FinanceSocialInsuranceService::avoidRef);
    }

    private static SocialInsurance avoidRef(SocialInsurance si) {
        People p1 = si.getPeople();
        People p2 = new People();
        p2.setId(p1.getId());
        p2.setSid(p1.getSid());
        p2.setName(p1.getName());
        si.setPeople(p2);
        return si;
    }
}
