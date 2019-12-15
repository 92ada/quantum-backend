package com.techncat.quantum.app.controller.finance;

import com.alibaba.fastjson.JSONObject;
import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.service.finance.FinanceExpCreateService;
import com.techncat.quantum.app.service.finance.FinanceExpDeleteService;
import com.techncat.quantum.app.service.finance.FinanceExpShowService;
import com.techncat.quantum.app.service.finance.FinanceExpUpdateService;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.vos.finance.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/finance/exps")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class FinanceExpController {
    @Autowired
    private FinanceExpShowService financeExpShowService;
    @Autowired
    private FinanceExpCreateService financeExpCreateService;
    @Autowired
    private FinanceExpUpdateService financeExpUpdateService;
    @Autowired
    private FinanceExpDeleteService financeExpDeleteService;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/{id}/base")
    public ResponseEntity getBase(@PathVariable Long id) {
        return ResponseEntity.ok(financeExpShowService.fetch(id));
    }

    @GetMapping("/{id}/base/structure")
    public ResponseEntity<Map> baseStructureInfo(@PathVariable("id") Long id) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        Exp exp = financeExpShowService.fetch(id);
        ExpVO vo = voUtils.copy(exp, ExpVO.class);
        Map result = voEnhanceUtil.enhance("data", vo);
        result.put("index", "finance.expenditure");
        result.put("post_url", "/api/finance/exps/base");
        result.put("update_url", "/api/finance/exps/" + id + "/base");
        result.put("delete_url", "/api/finance/exps/" + id);
        result.put("key", "base");
        result.put("priority", "1");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/extra")
    public ResponseEntity getDeatil(@PathVariable Long id) {
        return ResponseEntity.ok(financeExpShowService.fetchDetail(id));
    }

    @GetMapping("/{id}/extra/structure")
    public ResponseEntity<Map> extraStructureInfo(@PathVariable("id") Long id) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        Exp exp = financeExpShowService.fetch(id);
        Object obj = financeExpShowService.fetchDetailVO(id);
        Map result = voEnhanceUtil.enhance("data", obj);
        result.put("index", "finance.expenditure");
        if (exp.getType() != null) {
            result.put("post_url", "/api/finance/exps/" + exp.getType().name());
            result.put("update_url", "/api/finance/exps/" + id + "/" + exp.getType().name());
        } else {
            result.put("post_url", "/api/finance/exps/base");
            result.put("update_url", "/api/finance/exps/" + id + "/base");
        }
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("delete_url", "/api/finance/exps/" + id);
        return ResponseEntity.ok(result);
    }

    // create

    @PostMapping("/conference")
    public ResponseEntity<Exp> create1(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpConferenceVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpConferenceVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/consultation")
    public ResponseEntity<Exp> create2(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpConsultationVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpConsultationVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/equipment")
    public ResponseEntity<Exp> create3(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpEquipmentVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpEquipmentVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/indirective")
    public ResponseEntity<Exp> create4(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpIndirectiveVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpIndirectiveVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/international")
    public ResponseEntity<Exp> create5(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpInternationalVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpInternationalVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/labor")
    public ResponseEntity<Exp> create6(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpLaborVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpLaborVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/material")
    public ResponseEntity<Exp> create7(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpMaterialVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpMaterialVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/other")
    public ResponseEntity<Exp> create8(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpOtherVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpOtherVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/processing")
    public ResponseEntity<Exp> create9(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpProcessingVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpProcessingVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/publication")
    public ResponseEntity<Exp> create10(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpPublicationVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpPublicationVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    @PostMapping("/travel")
    public ResponseEntity<Exp> create11(@RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpTravelVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpTravelVO.class);
        return ResponseEntity.status(201).body(financeExpCreateService.create(baseVO, extraVO));
    }

    // update

    @PutMapping("/{exp_id}/conference")
    public ResponseEntity<Exp> update1(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpConferenceVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpConferenceVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/consultation")
    public ResponseEntity<Exp> update2(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpConsultationVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpConsultationVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/equipment")
    public ResponseEntity<Exp> update3(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpEquipmentVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpEquipmentVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PostMapping("/{exp_id}/indirective")
    public ResponseEntity<Exp> update4(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpIndirectiveVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpIndirectiveVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/international")
    public ResponseEntity<Exp> update5(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpInternationalVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpInternationalVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/labor")
    public ResponseEntity<Exp> update6(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpLaborVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpLaborVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/material")
    public ResponseEntity<Exp> update7(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpMaterialVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpMaterialVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/other")
    public ResponseEntity<Exp> update8(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpOtherVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpOtherVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/processing")
    public ResponseEntity<Exp> update9(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpProcessingVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpProcessingVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/publication")
    public ResponseEntity<Exp> update10(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpPublicationVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpPublicationVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    @PutMapping("/{exp_id}/travel")
    public ResponseEntity<Exp> update11(@PathVariable("exp_id") Long id, @RequestBody JSONObject requestBody) throws VOUtils.BeanCopyException {
        ExpVO baseVO = requestBody.getJSONObject("base").toJavaObject(ExpVO.class);
        ExpTravelVO extraVO = requestBody.getJSONObject("extra").toJavaObject(ExpTravelVO.class);
        return ResponseEntity.status(200).body(financeExpUpdateService.update(id, baseVO, extraVO));
    }

    // delete

    @DeleteMapping("/{exp_id}")
    public ResponseEntity delete(@PathVariable("exp_id") Long id) {
        financeExpDeleteService.delete(id);
        return ResponseEntity.status(204).build();
    }

}
