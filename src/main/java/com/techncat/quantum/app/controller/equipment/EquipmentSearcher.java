package com.techncat.quantum.app.controller.equipment;

import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.service.equipment.EquipmentPurchasingService;
import com.techncat.quantum.app.service.equipment.EquipmentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class EquipmentSearcher {
    @Autowired
    private EquipmentStockService equipmentStockService;
    @Autowired
    private EquipmentPurchasingService purchasingService;

    @GetMapping("/purchasing")
    public Page<Purchasing> searchPurchasing(@RequestParam(value = "word", required = false) String word,
                                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                             @RequestParam(value = "order", defaultValue = "desc") String order,
                                             @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return purchasingService.page(word, request);
    }

    @GetMapping("/stock")
    public Page<Stock> searchStock(@RequestParam(value = "word", required = false) String word,
                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                   @RequestParam(value = "order", defaultValue = "desc") String order,
                                   @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return equipmentStockService.page(word, request);
    }
}
