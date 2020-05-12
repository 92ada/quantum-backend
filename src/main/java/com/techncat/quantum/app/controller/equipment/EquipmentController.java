package com.techncat.quantum.app.controller.equipment;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.annotation.ROLE;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.model.equipment.Purchasing;
import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.service.equipment.EquipmentPurchasingService;
import com.techncat.quantum.app.service.equipment.EquipmentStockService;
import com.techncat.quantum.app.vos.equipment.PurchasingVO;
import com.techncat.quantum.app.vos.equipment.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.techncat.quantum.app.common.auth.AuthUtil.hasAuth;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class EquipmentController {
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;
    @Autowired
    private EquipmentPurchasingService purchasingService;
    @Autowired
    private EquipmentStockService stockService;

    /* purchasing */

    @GetMapping("/purchasing/structure")
    public ResponseEntity<Map> astructureInfo1() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PurchasingVO());
        result.put("index", "equipment.purchasing");
        result.put("post_url", "/api/equipment/purchasing");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/purchasing/{id}")
    public ResponseEntity<PurchasingVO> showPurchasing(@ForkiAser(requiredRoles = {ROLE.equipment, ROLE.equipment_purchasing}) Aser aser,
                                                       @PathVariable("id") Long id) {
        Purchasing purchasing = purchasingService.fetch(id);
        if (purchasing.getPi() != null && !hasAuth(aser, purchasing.getPi().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(purchasingService.fetchVO(id));
    }

    @GetMapping("/purchasing/{id}/structure")
    public ResponseEntity<Map> showPurchasingStructure(@ForkiAser(requiredRoles = {ROLE.equipment, ROLE.equipment_purchasing}) Aser aser,
                                                       @PathVariable("id") Long id) throws IllegalAccessException {
        Purchasing purchasing = purchasingService.fetch(id);
        if (purchasing.getPi() != null && !hasAuth(aser, purchasing.getPi().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        Map result = voEnhanceUtil.enhance("data", purchasingService.fetchVO(id));
        result.put("index", "equipment.purchasing");
        result.put("update_url", "/api/equipment/purchasing/" + id);
        result.put("delete_url", "/api/equipment/purchasing/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/purchasing")
    public ResponseEntity create(@ForkiAser(requiredRoles = {ROLE.edit_equipment, ROLE.edit_equipment_purchasing}) Aser aser,
                                 @RequestBody PurchasingVO data) {
        return ResponseEntity.status(201).body(purchasingService.create(data));
    }

    @PutMapping("/purchasing/{id}")
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_equipment, ROLE.edit_equipment_purchasing}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody PurchasingVO data) {
        Purchasing purchasing = purchasingService.fetch(id);
        if (purchasing.getPi() != null && !hasAuth(aser, purchasing.getPi().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(purchasingService.update(id, data));
    }

    @DeleteMapping("/purchasing/{id}")
    public ResponseEntity deletePurchasing(@ForkiAser(requiredRoles = {ROLE.delete_equipment, ROLE.delete_equipment_purchasing}) Aser aser,
                                           @PathVariable("id") Long id) {
        Purchasing purchasing = purchasingService.fetch(id);
        if (purchasing.getPi() != null && !hasAuth(aser, purchasing.getPi().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        purchasingService.delete(id);
        return ResponseEntity.status(204).build();
    }

    /* stock */

    @GetMapping("/stock/structure")
    public ResponseEntity<Map> astructureInfo2() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new StockVO());
        result.put("index", "equipment.stock");
        result.put("post_url", "/api/equipment/stock");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<StockVO> showStock(@ForkiAser(requiredRoles = {ROLE.equipment, ROLE.equipment_stock}) Aser aser,
                                             @PathVariable("id") Long id) {
        Stock stock = stockService.fetch(id);
        if (stock.getAdmin() != null && !hasAuth(aser, stock.getAdmin().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(stockService.fetchVO(id));
    }

    @GetMapping("/stock/{id}/structure")
    public ResponseEntity<Map> showStockStructure(@ForkiAser(requiredRoles = {ROLE.equipment, ROLE.equipment_stock}) Aser aser,
                                                  @PathVariable("id") Long id) throws IllegalAccessException {
        Stock stock = stockService.fetch(id);
        if (stock.getAdmin() != null && !hasAuth(aser, stock.getAdmin().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        Map result = voEnhanceUtil.enhance("data", stockService.fetchVO(id));
        result.put("index", "equipment.stock");
        result.put("update_url", "/api/equipment/stock/" + id);
        result.put("delete_url", "/api/equipment/stock/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/stock")
    public ResponseEntity create(@ForkiAser(requiredRoles = {ROLE.edit_equipment, ROLE.edit_equipment_stock}) Aser aser,
                                 @RequestBody StockVO data) {
        return ResponseEntity.status(201).body(stockService.create(data));
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_equipment, ROLE.edit_equipment_stock}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody StockVO data) {
        Stock stock = stockService.fetch(id);
        if (stock.getAdmin() != null && !hasAuth(aser, stock.getAdmin().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(stockService.update(id, data));
    }

    @DeleteMapping("/stock/{id}")
    public ResponseEntity deleteStock(@ForkiAser(requiredRoles = {ROLE.delete_equipment, ROLE.delete_equipment_stock}) Aser aser,
                                      @PathVariable("id") Long id) {
        Stock stock = stockService.fetch(id);
        if (stock.getAdmin() != null && !hasAuth(aser, stock.getAdmin().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        stockService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
