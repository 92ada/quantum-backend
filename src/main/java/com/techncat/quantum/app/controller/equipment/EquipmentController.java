package com.techncat.quantum.app.controller.equipment;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.service.equipment.EquipmentPurchasingService;
import com.techncat.quantum.app.service.equipment.EquipmentStockService;
import com.techncat.quantum.app.vos.equipment.PurchasingVO;
import com.techncat.quantum.app.vos.equipment.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<PurchasingVO> showPurchasing(@PathVariable("id") Long id) {
        return ResponseEntity.ok(purchasingService.fetchVO(id));
    }

    @GetMapping("/purchasing/{id}/structure")
    public ResponseEntity<Map> showPurchasingStructure(@PathVariable("id") Long id) throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", purchasingService.fetchVO(id));
        result.put("index", "daily.purchasing");
        result.put("update_url", "/api/equipment/purchasing/" + id);
        result.put("delete_url", "/api/equipment/purchasing/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/purchasing")
    public ResponseEntity create(@RequestBody PurchasingVO data) {
        return ResponseEntity.status(201).body(purchasingService.create(data));
    }

    @PutMapping("/purchasing/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody PurchasingVO data) {
        return ResponseEntity.status(201).body(purchasingService.update(id, data));
    }

    @DeleteMapping("/purchasing/{id}")
    public ResponseEntity deletePurchasing(@PathVariable("id") Long id) {
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
    public ResponseEntity<StockVO> showStock(@PathVariable("id") Long id) {
        return ResponseEntity.ok(stockService.fetchVO(id));
    }

    @GetMapping("/stock/{id}/structure")
    public ResponseEntity<Map> showStockStructure(@PathVariable("id") Long id) throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", stockService.fetchVO(id));
        result.put("index", "daily.stock");
        result.put("update_url", "/api/equipment/stock/" + id);
        result.put("delete_url", "/api/equipment/stock/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/stock")
    public ResponseEntity create(@RequestBody StockVO data) {
        return ResponseEntity.status(201).body(stockService.create(data));
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody StockVO data) {
        return ResponseEntity.status(201).body(stockService.update(id, data));
    }

    @DeleteMapping("/stock/{id}")
    public ResponseEntity deleteStock(@PathVariable("id") Long id) {
        stockService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
