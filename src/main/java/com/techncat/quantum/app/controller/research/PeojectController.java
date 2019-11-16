package com.techncat.quantum.app.controller.research;


import com.techncat.quantum.app.model.research.ProjectFund;
import com.techncat.quantum.app.model.research.ProjectMember;
import com.techncat.quantum.app.service.research.ProjectFundService;
import com.techncat.quantum.app.service.research.ProjectMemberService;
import com.techncat.quantum.app.service.research.ResearchShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research/project")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class PeojectController {
    @Autowired
    private ProjectMemberService memberService;
    @Autowired
    private ProjectFundService fundService;

    /* project member */

    @PostMapping("/member/{project_id}/{people_id}")
    public ProjectMember addMember(@PathVariable("project_id") Long projectId, @PathVariable("people_id") Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        return memberService.add(projectId, peopleId);
    }

    @DeleteMapping("/member/{project_id}/{people_id}")
    public ResponseEntity removeMember(@PathVariable("project_id") Long projectId, @PathVariable("people_id") Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        memberService.remove(projectId, peopleId);
        return ResponseEntity.status(204).build();
    }

    /* project fund */

    @PostMapping("/fund/{project_id}")
    public ProjectFund addFund(@PathVariable("project_id") Long projectId, @RequestBody ProjectFund data) throws ResearchShowService.ProjectNotFoundException {
        return fundService.create(projectId, data);
    }

    @PutMapping("/fund/{project_id}/{fund_id}")
    public ProjectFund updateFund(@PathVariable("project_id") Long projectId, @PathVariable("fund_id") Long fundId, @RequestBody ProjectFund data) throws ProjectFundService.ProjectFundNotFoundException, ResearchShowService.ProjectNotFoundException {
        return fundService.update(projectId, fundId, data);
    }

    @DeleteMapping("/fund/{project_id}/{fund_id}")
    public ResponseEntity removeFund(@PathVariable("project_id") Long projectId, @PathVariable("fund_id") Long fundId) throws ResearchShowService.ProjectNotFoundException {
        fundService.delete(projectId, fundId);
        return ResponseEntity.status(204).build();
    }
}
