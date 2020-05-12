package com.techncat.quantum.app.service.equipment;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.repository.equipment.EquPurchasingRepository;
import com.techncat.quantum.app.service.people.LabRunner;
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
        if (isRoot(aser)) return purchasingRepository.findAll(pageable);

        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        if (word == null) return purchasingRepository.findAllByPi_IdIn(peopleIds, pageable);

        String wordLike = "%" + word + "%";
        return purchasingRepository.findAllByTitleLikeAndPi_IdIn(wordLike, peopleIds, pageable);
    }

    public List<Purchasing> list(String word) {
        if (word == null) return purchasingRepository.findAll();
        String wordLike = "%" + word + "%";
        return purchasingRepository.findAllByTitleLike(wordLike);
    }

    public PurchasingVO fetchVO(Long id) {
        return voUtils.copy(fetch(id), PurchasingVO.class);
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
        preData.setHandler(jsonLoader.loadPeople(preData.getHandlerJson()));
        preData.setPi(jsonLoader.loadPeople(preData.getPiJson()));
        return purchasingRepository.save(preData);
    }

    public Purchasing update(Long id, PurchasingVO data) {
        Purchasing record = fetch(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        record.setHandler(jsonLoader.loadPeople(record.getHandlerJson()));
        record.setPi(jsonLoader.loadPeople(record.getPiJson()));
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

}
