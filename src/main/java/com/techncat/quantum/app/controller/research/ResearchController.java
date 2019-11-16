package com.techncat.quantum.app.controller.research;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.service.research.ResearchCreateService;
import com.techncat.quantum.app.service.research.ResearchDeleteService;
import com.techncat.quantum.app.service.research.ResearchShowService;
import com.techncat.quantum.app.service.research.ResearchUpdateService;
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
    private ResearchCreateService createService;
    @Autowired
    private ResearchUpdateService updateService;
    @Autowired
    private ResearchDeleteService deleteService;

    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    /* paper */

    @GetMapping("/paper/structure")
    public ResponseEntity<Map> astructureInfo1() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PaperVO());
        result.put("index", "research.paper_info");
        result.put("post_url", "/api/research/paper");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/paper/{paper_id}")
    public ResponseEntity<PaperVO> showPaper(@PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException {
        return ResponseEntity.ok(showService.showPaper(id));
    }

    @GetMapping("/paper/{paper_id}/structure")
    public ResponseEntity<Map> showPaperStructure(@PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException, IllegalAccessException {
        PaperVO paperVO = showService.showPaper(id);
        Map result = voEnhanceUtil.enhance("data", paperVO);
        result.put("index", "research.paper_info");
        result.put("update_url", "/api/research/paper/" + id);
        result.put("delete_url", "/api/research/paper/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/paper")
    public ResponseEntity create(@RequestBody PaperVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/paper/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody PaperVO data) throws ResearchShowService.PaperNotFoundException {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/paper/{id}")
    public ResponseEntity deletePaper(@PathVariable("id") Long id) throws ResearchShowService.PaperNotFoundException {
        deleteService.deletePaper(id);
        return ResponseEntity.status(204).build();
    }

    /* patent */

    @GetMapping("/patent/structure")
    public ResponseEntity<Map> astructureInfo2() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PatentVO());
        result.put("index", "research.patent_info");
        result.put("post_url", "/api/research/patent");
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
        result.put("update_url", "/api/research/patent/" + id);
        result.put("delete_url", "/api/research/patent/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/patent")
    public ResponseEntity create(@RequestBody PatentVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/patent/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody PatentVO data) throws ResearchShowService.PatentNotFoundException {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/patent/{id}")
    public ResponseEntity deletePatent(@PathVariable("id") Long id) throws ResearchShowService.PatentNotFoundException {
        deleteService.deletePatent(id);
        return ResponseEntity.status(204).build();
    }

    /* project */

    @GetMapping("/project/structure")
    public ResponseEntity<Map> astructureInfo3() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ProjectVO());
        result.put("index", "research.project_info");
        result.put("post_url", "/api/research/project");
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
        result.put("update_url", "/api/research/project/" + id);
        result.put("delete_url", "/api/research/project/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/project")
    public ResponseEntity create(@RequestBody ProjectVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/project/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ProjectVO data) throws ResearchShowService.ProjectNotFoundException {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity deleteProject(@PathVariable("id") Long id) throws ResearchShowService.ProjectNotFoundException {
        deleteService.deleteProject(id);
        return ResponseEntity.status(204).build();
    }


    /* reward */

    @GetMapping("/reward/structure")
    public ResponseEntity<Map> astructureInfo4() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new RewardVO());
        result.put("index", "research.reward_info");
        result.put("post_url", "/api/research/reward");
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
        result.put("update_url", "/api/research/reward/" + id);
        result.put("delete_url", "/api/research/reward/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/reward")
    public ResponseEntity create(@RequestBody RewardVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/reward/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody RewardVO data) throws ResearchShowService.RewardNotFoundException {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/reward/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws ResearchShowService.RewardNotFoundException {
        deleteService.deleteReward(id);
        return ResponseEntity.status(204).build();
    }


}
