package com.techncat.quantum.app.service.equipment;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.repository.equipment.EquStockRepository;
import com.techncat.quantum.app.service.people.LabRunner;
import com.techncat.quantum.app.service.utils.JsonLoader;
import com.techncat.quantum.app.vos.equipment.StockVO;
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
public class EquipmentStockService {
    @Resource
    private EquStockRepository stockRepository;

    @Autowired
    private VOUtils voUtils;
    @Autowired
    private JsonLoader jsonLoader;
    @Autowired
    private LabRunner runner;

    public Page<Stock> page(Aser aser, String word, Pageable pageable) {
        if (isRoot(aser)) return stockRepository.findAll(pageable);

        List<Long> peopleIds = runner.fixUserIds(aser.getSid());
        if (word == null) return stockRepository.findAllByAdmin_IdIn(peopleIds, pageable);
        String wordLike = "%" + word + "%";
        return stockRepository.findAllByTitleLikeAndAdmin_IdIn(wordLike, peopleIds, pageable);
    }

    public List<Stock> list(String word) {
        if (word == null) return stockRepository.findAll();
        String wordLike = "%" + word + "%";
        return stockRepository.findAllByTitleLike(wordLike);
    }

    public StockVO fetchVO(Long id) {
        return voUtils.copy(fetch(id), StockVO.class);
    }

    public Stock fetch(Long id) {
        Optional<Stock> optional = stockRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        throw new StockNotFoundException(id);
    }

    public Stock create(StockVO data) {
        Stock preData = voUtils.copy(data, Stock.class);
        preData.setId(null);
        preData.setUpdateAt(new Date());
        preData.setCreatedAt(new Date());
        preData.setAdmin(jsonLoader.loadPeople(preData.getAdminJson()));
        preData.setTaker(jsonLoader.loadPeople(preData.getTakerJson()));
        return stockRepository.save(preData);
    }

    public Stock update(Long id, StockVO data) {
        Stock record = fetch(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        record.setAdmin(jsonLoader.loadPeople(record.getAdminJson()));
        record.setTaker(jsonLoader.loadPeople(record.getTakerJson()));
        return stockRepository.save(record);
    }

    public void delete(Long id) {
        stockRepository.delete(fetch(id));
    }

    public static class StockNotFoundException extends RuntimeException {
        StockNotFoundException(Long id) {
            super("Stock id=[" + id + "] Not Found");
        }
    }

}
