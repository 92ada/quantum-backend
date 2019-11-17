package com.techncat.quantum.app.service.equipment;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.repository.equipment.EquStockRepository;
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

@Service
public class EquipmentStockService {
    @Resource
    private EquStockRepository stockRepository;

    @Autowired
    private VOUtils voUtils;

    public Page<Stock> page(String word, Pageable pageable) {
        if (word == null) return stockRepository.findAll(pageable);
        String wordLike = "%" + word + "%";
        return stockRepository.findAllByTitleLike(wordLike, pageable);
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
        return stockRepository.save(preData);
    }

    public Stock update(Long id, StockVO data) {
        Stock record = fetch(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
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
