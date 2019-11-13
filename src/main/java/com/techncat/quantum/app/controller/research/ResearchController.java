package com.techncat.quantum.app.controller.research;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.service.research.ResearchShowService;
import com.techncat.quantum.app.vos.research.PaperVO;
import com.techncat.quantum.app.vos.research.PatentVO;
import com.techncat.quantum.app.vos.research.ProjectVO;
import com.techncat.quantum.app.vos.research.RewardVO;
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

    @GetMapping("/paper/{paper_id}")
    public ResponseEntity<PaperVO> showPaper(@PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException {
        return ResponseEntity.ok(showService.showPaper(id));
    }

    @GetMapping("/paper/{paper_id}/structure")
    public ResponseEntity<Map> showPaperStructure(@PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException, IllegalAccessException {
        PaperVO paperVO = showService.showPaper(id);
        Map result = voEnhanceUtil.enhance("data", paperVO);
        result.put("index", "research.paper_info");
        result.put("post_url", "/api/research/paper");
        result.put("update_url", "/api/research/paper/" + id);
        result.put("delete_url", "/api/research/paper/" + id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/patent/{patent_id}")
    public ResponseEntity<PatentVO> showPatent(@PathVariable("patent_id") Long id) throws ResearchShowService.PatentNotFoundException {
        return ResponseEntity.ok(showService.showPatent(id));
    }

    @GetMapping("/patent/{patent_id}/structure")
    public ResponseEntity<Map> showPatentStructure(@PathVariable("patent_id") Long id) throws ResearchShowService.PatentNotFoundException, IllegalAccessException {
        PatentVO patentVO = showService.showPatent(id);
        Map result = voEnhanceUtil.enhance("data", patentVO);
        result.put("index", "research.patent_info");
        result.put("post_url", "/api/research/patent");
        result.put("update_url", "/api/research/patent/" + id);
        result.put("delete_url", "/api/research/patent/" + id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/project/{project_id}")
    public ResponseEntity<ProjectVO> showProject(@PathVariable("project_id") Long id) throws ResearchShowService.ProjectNotFoundException {
        return ResponseEntity.ok(showService.showProject(id));
    }

    @GetMapping("/project/{project_id}/structure")
    public ResponseEntity<Map> showProjectStructure(@PathVariable("project_id") Long id) throws IllegalAccessException, ResearchShowService.ProjectNotFoundException {
        ProjectVO projectVO = showService.showProject(id);
        Map result = voEnhanceUtil.enhance("data", projectVO);
        result.put("index", "research.project_info");
        result.put("post_url", "/api/research/project");
        result.put("update_url", "/api/research/project/" + id);
        result.put("delete_url", "/api/research/project/" + id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reward/{reward_id}")
    public ResponseEntity<RewardVO> showReward(@PathVariable("reward_id") Long id) throws ResearchShowService.RewardNotFoundException {
        return ResponseEntity.ok(showService.showReward(id));
    }

    @GetMapping("/reward/{reward_id}/structure")
    public ResponseEntity<Map> showRewardStructure(@PathVariable("reward_id") Long id) throws IllegalAccessException, ResearchShowService.RewardNotFoundException {
        RewardVO rewardVO = showService.showReward(id);
        Map result = voEnhanceUtil.enhance("data", rewardVO);
        result.put("index", "research.reward_info");
        result.put("post_url", "/api/research/reward");
        result.put("update_url", "/api/research/reward/" + id);
        result.put("delete_url", "/api/research/reward/" + id);
        return ResponseEntity.ok(result);
    }


}
