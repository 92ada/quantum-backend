package com.techncat.quantum.app.controller.finance;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.vos.finance.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/finance")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class FinanceStructureController {
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/exps/base/structure")
    public ResponseEntity<Map> baseStructureInfo() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpVO());
        result.put("index", "finance.expenditure");
        result.put("key", "base");
        result.put("priority", "1");
        result.put("post_url", "/api/finance/exps/base");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/conference/structure")
    public ResponseEntity<Map> structureInfo1() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpConferenceVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/conference");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/consultation/structure")
    public ResponseEntity<Map> structureInfo2() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpConsultationVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/consultation");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/equipment/structure")
    public ResponseEntity<Map> structureInfo3() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpEquipmentVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/equipment");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/indirective/structure")
    public ResponseEntity<Map> structureInfo4() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpIndirectiveVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/indirective");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/international/structure")
    public ResponseEntity<Map> structureInfo5() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpInternationalVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/international");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/labor/structure")
    public ResponseEntity<Map> structureInfo6() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpLaborVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/labor");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/material/structure")
    public ResponseEntity<Map> structureInfo7() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpMaterialVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/material");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/other/structure")
    public ResponseEntity<Map> structureInfo8() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpOtherVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/other");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/processing/structure")
    public ResponseEntity<Map> structureInfo9() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpProcessingVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/processing");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/publication/structure")
    public ResponseEntity<Map> structureInfo10() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpPublicationVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/publication");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exps/travel/structure")
    public ResponseEntity<Map> structureInfo11() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ExpTravelVO());
        result.put("index", "finance.expenditure");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/finance/exps/travel");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/social_funds/structure")
    public ResponseEntity<Map> structureInfo12() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new SocialFundVO());
        result.put("index", "finance.social_fund");
        result.put("post_url", "/api/finance/social_funds");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/social_insurances/structure")
    public ResponseEntity<Map> structureInfo13() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new SocialInsuranceVO());
        result.put("index", "finance.social_insurance");
        result.put("post_url", "/api/finance/social_insurances");
        return ResponseEntity.ok(result);
    }
}
