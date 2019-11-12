package com.techncat.quantum.app.controller.research;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.service.research.ResearchShowService;
import com.techncat.quantum.app.vos.research.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/research")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class ResearchController {
    @Autowired
    private ResearchShowService showService;

    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/{paper_id}")
    public ResponseEntity<PaperVO> showPaper(@PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException {
        return ResponseEntity.ok(showService.showPaper(id));
    }

    @GetMapping("/{paper_id}/structure")
    public ResponseEntity<Map> showPaperStructure(@PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException, IllegalAccessException {
        PaperVO paperVO = showService.showPaper(id);
        Map result = voEnhanceUtil.enhance("data", paperVO);
        result.put("index", "research.paper");
        result.put("post_url", "/api/research/paper");
        result.put("update_url", "/api/research/paper/" + id);
        result.put("delete_url", "/api/research/paper/" + id);
        return ResponseEntity.ok(result);
    }
}
