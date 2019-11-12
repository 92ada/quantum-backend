package com.techncat.quantum.app.controller.finance;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.service.finance.FinanceExpShowService;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.vos.finance.ExpVO;
import com.techncat.quantum.app.vos.people.PeopleVO;
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
public class FinanceController {
    @Autowired
    private FinanceExpShowService financeExpShowService;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/exp/{id}/base")
    public ResponseEntity getBase(@PathVariable Long id) {
        return ResponseEntity.ok(financeExpShowService.fetch(id));
    }

    @GetMapping("/{id}/base/structure")
    public ResponseEntity<Map> baseStructureInfo(@PathVariable("id") Long id) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        Exp exp = financeExpShowService.fetch(id);
        ExpVO vo = voUtils.copy(exp, ExpVO.class);
        Map result = voEnhanceUtil.enhance("data", vo);
        result.put("index", "finance.exp");
        result.put("post_url", "/api/finance/exp/base");
        result.put("update_url", "/api/finance/exp/" + id + "/base");
        result.put("delete_url", "/api/finance/exp/" + id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/exp/{id}/extra")
    public ResponseEntity getDeatil(@PathVariable Long id) {
        return ResponseEntity.ok(financeExpShowService.fetchDetail(id));
    }

    @GetMapping("/exp/{id}/extra/structure")
    public ResponseEntity<Map> extraStructureInfo(@PathVariable("id") Long id) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        Exp exp = financeExpShowService.fetch(id);
        Object obj = financeExpShowService.fetchDetail(id);
        Map result = voEnhanceUtil.enhance("data", obj);
        result.put("index", "people.other_info");
        result.put("post_url", "/api/finance/exp/" + exp.getType().name());
        result.put("update_url", "/api/finance/exp/" + id + "/" + exp.getType().name());
        result.put("delete_url", "/api/finance/exp/" + id);
        return ResponseEntity.ok(result);
    }

}
