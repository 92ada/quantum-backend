package com.techncat.quantum.app.service.equipment;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.repository.equipment.EquPurchasingRepository;
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

@Service
public class EquipmentPurchasingService {
    @Resource
    private EquPurchasingRepository purchasingRepository;

    @Autowired
    private VOUtils voUtils;

    public Page<Purchasing> page(String word, Pageable pageable) {
        if (word == null) return purchasingRepository.findAll(pageable);
        String wordLike = "%" + word + "%";
        return purchasingRepository.findAllByTitleLike(wordLike, pageable);
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
        return purchasingRepository.save(preData);
    }

    public Purchasing update(Long id, PurchasingVO data) {
        Purchasing record = fetch(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
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
