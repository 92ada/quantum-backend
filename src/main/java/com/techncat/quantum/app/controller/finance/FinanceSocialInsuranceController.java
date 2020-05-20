package com.techncat.quantum.app.controller.finance;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.annotation.ROLE;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.auth.AuthUtil;
import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.SocialInsurance;
import com.techncat.quantum.app.service.finance.social.FinanceSocialInsuranceService;
import com.techncat.quantum.app.vos.finance.SocialInsuranceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private AuthUtil authUtil;

    @GetMapping("/{id}")
    public ResponseEntity get(@ForkiAser(requiredRoles = {ROLE.finance, ROLE.finance_social_insurance}) Aser aser,
                              @PathVariable("id") Long id) {
        SocialInsurance record = financeSocialInsuranceService.fetch(id);
        if (record.getPeople() != null && !authUtil.hasAuth(aser, record.getPeople().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        SocialInsuranceVO data = voUtils.copy(record, SocialInsuranceVO.class);
//        data.setPeople(PeopleVO.renderSimple(record.getPeople()));

        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}/structure")
    public ResponseEntity structure(@ForkiAser(requiredRoles = {ROLE.finance, ROLE.finance_social_insurance}) Aser aser,
                                    @PathVariable("id") Long id) throws IllegalAccessException {
        SocialInsurance record = financeSocialInsuranceService.fetch(id);
        if (record.getPeople() != null && !authUtil.hasAuth(aser, record.getPeople().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity create(@ForkiAser(requiredRoles = {ROLE.edit_finance, ROLE.edit_finance_social_insurance}) Aser aser,
                                 @RequestBody SocialInsuranceVO payload) {
        return ResponseEntity.status(201).body(financeSocialInsuranceService.create(payload));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_finance, ROLE.edit_finance_social_insurance}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody SocialInsuranceVO payload) {
        SocialInsurance record = financeSocialInsuranceService.fetch(id);
        if (record.getPeople() != null && !authUtil.hasAuth(aser, record.getPeople().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(200).body(financeSocialInsuranceService.update(id, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@ForkiAser(requiredRoles = {ROLE.delete_finance, ROLE.delete_finance_social_insurance}) Aser aser,
                                 @PathVariable("id") Long id) {
        SocialInsurance record = financeSocialInsuranceService.fetch(id);
        if (record.getPeople() != null && !authUtil.hasAuth(aser, record.getPeople().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        financeSocialInsuranceService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
