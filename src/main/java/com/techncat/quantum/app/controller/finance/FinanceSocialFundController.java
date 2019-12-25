package com.techncat.quantum.app.controller.finance;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.SocialFund;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.service.finance.social.FinanceSocialFundService;
import com.techncat.quantum.app.vos.finance.SocialFundVO;
import com.techncat.quantum.app.vos.people.PeopleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/finance/social_funds")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class FinanceSocialFundController {
    @Autowired
    private FinanceSocialFundService financeSocialFundService;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        SocialFund record = financeSocialFundService.fetch(id);
        SocialFundVO data = voUtils.copy(record, SocialFundVO.class);
        data.setPeople(PeopleVO.renderSimple(record.getPeople()));

        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}/structure")
    public ResponseEntity structure(@PathVariable("id") Long id) throws IllegalAccessException {
        SocialFund record = financeSocialFundService.fetch(id);

        SocialFundVO data = voUtils.copy(record, SocialFundVO.class);
        data.setPeople(PeopleVO.renderSimple(record.getPeople()));

        Map result = voEnhanceUtil.enhance("data", data);
        result.put("index", "finance.social_fund");
        result.put("post_url", "/api/finance/social_funds");
        result.put("update_url", "/api/finance/social_funds/" + id);
        result.put("delete_url", "/api/finance/social_funds/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SocialFundVO payload) {
        return ResponseEntity.status(201).body(financeSocialFundService.create(payload));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody SocialFundVO payload) {
        return ResponseEntity.status(200).body(financeSocialFundService.update(id, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        financeSocialFundService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
