package com.techncat.quantum.app.controller.research;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.annotation.ROLE;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.auth.AuthUtil;
import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.model.research.Project;
import com.techncat.quantum.app.model.research.Reward;
import com.techncat.quantum.app.service.research.ResearchCreateService;
import com.techncat.quantum.app.service.research.ResearchDeleteService;
import com.techncat.quantum.app.service.research.ResearchShowService;
import com.techncat.quantum.app.service.research.ResearchUpdateService;
import com.techncat.quantum.app.vos.research.PaperVO;
import com.techncat.quantum.app.vos.research.PatentVO;
import com.techncat.quantum.app.vos.research.ProjectVO;
import com.techncat.quantum.app.vos.research.RewardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    private AuthUtil authUtil;

    /* paper */

    @GetMapping("/paper/structure")
    public ResponseEntity<Map> astructureInfo1() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PaperVO());
        result.put("index", "research.paper_info");
        result.put("post_url", "/api/research/paper");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/paper/{paper_id}")
    public ResponseEntity<PaperVO> showPaper(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_paper}) Aser aser,
                                             @PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException {
        Paper paper = showService.fetchPaper(id);
        if (paper.getSustech_people() != null && !authUtil.hasAuth(aser, paper.getSustech_people().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        else
            return ResponseEntity.ok(showService.showPaper(id));
    }

    @GetMapping("/paper/{paper_id}/structure")
    public ResponseEntity<Map> showPaperStructure(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_paper}) Aser aser,
                                                  @PathVariable("paper_id") Long id) throws ResearchShowService.PaperNotFoundException, IllegalAccessException {
        Paper paper = showService.fetchPaper(id);
        if (paper.getSustech_people() != null && !authUtil.hasAuth(aser, paper.getSustech_people().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_research, ROLE.edit_research_paper}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody PaperVO data) throws ResearchShowService.PaperNotFoundException {
        Paper paper = showService.fetchPaper(id);
        if (paper.getSustech_people() != null && !authUtil.hasAuth(aser, paper.getSustech_people().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/paper/{id}")
    public ResponseEntity deletePaper(@ForkiAser(requiredRoles = {ROLE.delete_research, ROLE.delete_research_paper}) Aser aser,
                                      @PathVariable("id") Long id) throws ResearchShowService.PaperNotFoundException {
        Paper paper = showService.fetchPaper(id);
        if (paper.getSustech_people() != null && !authUtil.hasAuth(aser, paper.getSustech_people().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity<PatentVO> showPatent(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_patent}) Aser aser,
                                               @PathVariable("patent_id") Long id) throws ResearchShowService.PatentNotFoundException {
        Patent patent = showService.fetchPatent(id);
        if (patent.getApplicant() != null && !authUtil.hasAuth(aser, patent.getApplicant().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(showService.showPatent(id));
    }

    @GetMapping("/patent/{patent_id}/structure")
    public ResponseEntity<Map> showPatentStructure(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_patent}) Aser aser,
                                                   @PathVariable("patent_id") Long id) throws ResearchShowService.PatentNotFoundException, IllegalAccessException {
        Patent patent = showService.fetchPatent(id);
        if (patent.getApplicant() != null && !authUtil.hasAuth(aser, patent.getApplicant().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_research, ROLE.edit_research_patent}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody PatentVO data) throws ResearchShowService.PatentNotFoundException {
        Patent patent = showService.fetchPatent(id);
        if (patent.getApplicant() != null && !authUtil.hasAuth(aser, patent.getApplicant().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/patent/{id}")
    public ResponseEntity deletePatent(@ForkiAser(requiredRoles = {ROLE.delete_research, ROLE.delete_research_patent}) Aser aser,
                                       @PathVariable("id") Long id) throws ResearchShowService.PatentNotFoundException {
        Patent patent = showService.fetchPatent(id);
        if (patent.getApplicant() != null && !authUtil.hasAuth(aser, patent.getApplicant().stream().map(x -> x.getId()).collect(Collectors.toList())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity<ProjectVO> showProject(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_project}) Aser aser,
                                                 @PathVariable("project_id") Long id) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(id);
        if (project.getLeader() != null && !authUtil.hasAuth(aser, project.getLeader().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(showService.showProject(id));
    }

    @GetMapping("/project/{project_id}/structure")
    public ResponseEntity<Map> showProjectStructure(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_project}) Aser aser,
                                                    @PathVariable("project_id") Long id) throws IllegalAccessException, ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(id);
        if (project.getLeader() != null && !authUtil.hasAuth(aser, project.getLeader().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_research, ROLE.edit_research_project}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody ProjectVO data) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(id);
        if (project.getLeader() != null && !authUtil.hasAuth(aser, project.getLeader().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity deleteProject(@ForkiAser(requiredRoles = {ROLE.delete_research, ROLE.delete_research_project}) Aser aser,
                                        @PathVariable("id") Long id) throws ResearchShowService.ProjectNotFoundException {
        Project project = showService.fetchProject(id);
        if (project.getLeader() != null && !authUtil.hasAuth(aser, project.getLeader().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity<RewardVO> showReward(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_reward}) Aser aser,
                                               @PathVariable("reward_id") Long id) throws ResearchShowService.RewardNotFoundException {
        Reward reward = showService.fetchReward(id);
        if (reward.getRewarded() != null && !authUtil.hasAuth(aser, reward.getRewarded().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(showService.showReward(id));
    }

    @GetMapping("/reward/{reward_id}/structure")
    public ResponseEntity<Map> showRewardStructure(@ForkiAser(requiredRoles = {ROLE.research, ROLE.research_reward}) Aser aser,
                                                   @PathVariable("reward_id") Long id) throws IllegalAccessException, ResearchShowService.RewardNotFoundException {
        Reward reward = showService.fetchReward(id);
        if (reward.getRewarded() != null && !authUtil.hasAuth(aser, reward.getRewarded().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

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
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_research, ROLE.edit_research_reward}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody RewardVO data) throws ResearchShowService.RewardNotFoundException {
        Reward reward = showService.fetchReward(id);
        if (reward.getRewarded() != null && !authUtil.hasAuth(aser, reward.getRewarded().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/reward/{id}")
    public ResponseEntity delete(@ForkiAser(requiredRoles = {ROLE.delete_research, ROLE.delete_research_reward}) Aser aser,
                                 @PathVariable("id") Long id) throws ResearchShowService.RewardNotFoundException {
        Reward reward = showService.fetchReward(id);
        if (reward.getRewarded() != null && !authUtil.hasAuth(aser, reward.getRewarded().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        deleteService.deleteReward(id);
        return ResponseEntity.status(204).build();
    }
}
