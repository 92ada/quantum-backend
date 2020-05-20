package com.techncat.quantum.app.excel.service;

import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.repository.equipment.EquPurchasingRepository;
import com.techncat.quantum.app.repository.equipment.EquStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class EquipmentExcelService {
    @Autowired
    EquPurchasingRepository purchasingRepository;
    @Autowired
    EquStockRepository stockRepository;

    @Transactional
    public boolean create_or_update(Purchasing record, boolean forceUpdate) {
        return exist(record) ? update(record, forceUpdate) : create(record);
    }

    @Transactional
    public boolean create_or_update(Stock record, boolean forceUpdate) {
        return exist(record) ? update(record, forceUpdate) : create(record);
    }

    private boolean exist(Purchasing purchasing) {
        return purchasingRepository.findFirstByTitle(purchasing.getTitle()).isPresent();
    }

    private boolean exist(Stock stock) {
        return stockRepository.findFirstByTitle(stock.getTitle()).isPresent();
    }

    private boolean update(Purchasing purchasing, boolean forceUpdate) {
        if (!forceUpdate) return true;
        Purchasing original = purchasingRepository.findFirstByTitle(purchasing.getTitle()).get();
        Long id = original.getId();

        purchasing.setId(id);
        purchasing.setUpdateAt(new Date());
        purchasingRepository.save(purchasing);
        return true;
    }

    private boolean update(Stock stock, boolean forceUpdate) {
        if (!forceUpdate) return true;
        Stock original = stockRepository.findFirstByTitle(stock.getTitle()).get();
        Long id = original.getId();

        stock.setId(id);
        stock.setUpdateAt(new Date());
        stockRepository.save(stock);
        return true;
    }

    private boolean create(Purchasing purchasing) {
        purchasing.setUpdateAt(new Date());
        purchasing.setCreatedAt(new Date());
        purchasingRepository.save(purchasing);
        return true;
    }

    private boolean create(Stock stock) {
        stock.setUpdateAt(new Date());
        stock.setCreatedAt(new Date());
        stockRepository.save(stock);
        return true;
    }
}

