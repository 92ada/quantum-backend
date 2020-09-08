package com.techncat.quantum.app.controller.my;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.equipment.EquPurchasingRepository;
import com.techncat.quantum.app.repository.equipment.EquStockRepository;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/my/equipment")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class MyEquipmentController {
    @Resource
    private EquStockRepository stockRepository;
    @Resource
    private EquPurchasingRepository purchasingRepository;
    @Autowired
    private PeopleShowService showService;


    @GetMapping("/stock")
    public List<Stock> searchStock(@ForkiAser Aser aser) {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        return stockRepository.findAllByAdmin(people);
    }

    @GetMapping("/purchasing")
    public List<Purchasing> searchPurchasing(@ForkiAser Aser aser) {
        String sid = aser.getSid();
        People people = showService.fetchBySid(sid);
        return purchasingRepository.findAllByPiOrHandler(people, people);
    }
}
