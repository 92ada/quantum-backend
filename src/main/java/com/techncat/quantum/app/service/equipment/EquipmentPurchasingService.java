package com.techncat.quantum.app.service.equipment;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.repository.equipment.EquPurchasingRepository;
import com.techncat.quantum.app.service.people.LabRunner;
import com.techncat.quantum.app.service.people.People_SearchService;
import com.techncat.quantum.app.service.utils.JsonLoader;
import com.techncat.quantum.app.vos.equipment.PurchasingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.techncat.quantum.app.common.auth.AuthUtil.isRoot;

@Service
public class EquipmentPurchasingService {
    @Resource
    private EquPurchasingRepository purchasingRepository;

    @Autowired
    private VOUtils voUtils;
    @Autowired
    private JsonLoader jsonLoader;
    @Autowired
    private LabRunner runner;

    public Page<Purchasing> page(Aser aser, String word, Pageable pageable) {
        String wordLike = "%" + word + "%";
        if (isRoot(aser)) return avoidRef(purchasingRepository.findAllByTitleLike(wordLike, pageable));

        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        return avoidRef(purchasingRepository.findAllByTitleLikeAndPi_IdIn(wordLike, peopleIds, pageable));
    }

    public List<Purchasing> list(String word) {
        String wordLike = "%" + word + "%";
        return avoidRef(purchasingRepository.findAllByTitleLike(wordLike));
    }

    public PurchasingVO fetchVO(Long id) {
        PurchasingVO vo = voUtils.copy(fetch(id), PurchasingVO.class);
        return vo;
    }

    public Purchasing fetch(Long id) {
        Optional<Purchasing> optional = purchasingRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        throw new PurchasingNotFoundException(id);
    }

    public Purchasing create(PurchasingVO data) {
        Purchasing preData = voUtils.copy(data, Purchasing.class);
        preData.setId(null);
        preData.setUpdateAt(new Date());
        preData.setCreatedAt(new Date());
        preData.setHandler(jsonLoader.loadPeople(data.getHandlerJson()));
        preData.setPi(jsonLoader.loadPeople(data.getPiJson()));
        return purchasingRepository.save(preData);
    }

    public Purchasing update(Long id, PurchasingVO data) {
        Purchasing record = fetch(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        record.setHandler(jsonLoader.loadPeople(data.getHandlerJson()));
        record.setPi(jsonLoader.loadPeople(data.getPiJson()));
        return purchasingRepository.save(record);
    }

    public void delete(Long id) {
        purchasingRepository.delete(fetch(id));
    }

    public static class PurchasingNotFoundException extends RuntimeException {
        PurchasingNotFoundException(Long id) {
            super("Purchasing id=[" + id + "] Not Found");
        }
    }

    private Page<Purchasing> avoidRef(Page<Purchasing> source) {
        return source.map(record -> {
            record.setPi(People_SearchService.avoidRef(record.getPi()));
            record.setHandler(People_SearchService.avoidRef(record.getHandler()));
            return record;
        });
    }

    private List<Purchasing> avoidRef(List<Purchasing> source) {
        source.forEach(record -> {
            record.setPi(People_SearchService.avoidRef(record.getPi()));
            record.setHandler(People_SearchService.avoidRef(record.getHandler()));
        });
        return source;
    }
}
