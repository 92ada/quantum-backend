package com.techncat.quantum.app.controller.finance;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.SocialInsurance;
import com.techncat.quantum.app.service.finance.social.FinanceSocialInsuranceService;
import com.techncat.quantum.app.vos.finance.SocialInsuranceVO;
import com.techncat.quantum.app.vos.people.PeopleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/finance/social_insurances")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class FinanceSocialInsuranceController {
    @Autowired
    private FinanceSocialInsuranceService financeSocialInsuranceService;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        SocialInsurance record = financeSocialInsuranceService.fetch(id);
        SocialInsuranceVO data = voUtils.copy(record, SocialInsuranceVO.class);
//        data.setPeople(PeopleVO.renderSimple(record.getPeople()));

        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}/structure")
    public ResponseEntity structure(@PathVariable("id") Long id) throws IllegalAccessException {
        SocialInsurance record = financeSocialInsuranceService.fetch(id);

        SocialInsuranceVO data = voUtils.copy(record, SocialInsuranceVO.class);
//        data.setPeople(PeopleVO.renderSimple(record.getPeople()));

        Map result = voEnhanceUtil.enhance("data", data);
        result.put("index", "finance.social_insurance");
        result.put("post_url", "/api/finance/social_insurances");
        result.put("update_url", "/api/finance/social_insurances/" + id);
        result.put("delete_url", "/api/finance/social_insurances/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SocialInsuranceVO payload) {
        return ResponseEntity.status(201).body(financeSocialInsuranceService.create(payload));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody SocialInsuranceVO payload) {
        return ResponseEntity.status(200).body(financeSocialInsuranceService.update(id, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        financeSocialInsuranceService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
