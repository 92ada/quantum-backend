package com.techncat.quantum.app.controller.research;


import com.techncat.quantum.app.model.research.ProjectAdmin;
import com.techncat.quantum.app.model.research.ProjectFund;
import com.techncat.quantum.app.model.research.ProjectMember;
import com.techncat.quantum.app.service.research.ProjectAdminService;
import com.techncat.quantum.app.service.research.ProjectFundService;
import com.techncat.quantum.app.service.research.ProjectMemberService;
import com.techncat.quantum.app.service.research.ResearchShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/research/project")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class ProjectController {
    @Autowired
    private ProjectAdminService adminService;
    @Autowired
    private ProjectMemberService memberService;
    @Autowired
    private ProjectFundService fundService;

    /* project admin */

    @GetMapping("/{project_id}/admin")
    public List listAdmin(@PathVariable("project_id") Long projectId) throws ResearchShowService.ProjectNotFoundException {
        return adminService.list(projectId);
    }

    @PostMapping("/{project_id}/admin/{people_id}")
    public ProjectAdmin addAdmin(@PathVariable("project_id") Long projectId, @PathVariable("people_id") Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        return adminService.add(projectId, peopleId);
    }

    @DeleteMapping("/{project_id}/admin/{people_id}")
    public ResponseEntity removeAdmin(@PathVariable("project_id") Long projectId, @PathVariable("people_id") Long peopleId) throws ResearchShowService.ProjectNotFoundException {
        adminService.remove(projectId, peopleId);
        return ResponseEntity.status(204).build();
    }

    /* project member */

    @GetMapping("/{project_id}/member")
    public List listMember(@PathVariable("project_id") Long projectId) throws ResearchShowService.ProjectNotFoundException {
        return memberService.list(projectId);
    }

    @PostMapping("/{project_id}/member")
    public ProjectMember addMember(@PathVariable("project_id") Long projectId, @RequestBody ProjectMember data) throws ResearchShowService.ProjectNotFoundException {
        return memberService.create(projectId, data);
    }

    @PutMapping("/{project_id}/member/{member_info_id}")
    public ProjectMember updateMember(@PathVariable("project_id") Long projectId, @PathVariable("member_info_id") Long recordId, @RequestBody ProjectMember data) throws ResearchShowService.ProjectNotFoundException, ProjectMemberService.ProjectMemberNotFoundException {
        return memberService.update(projectId, recordId, data);
    }

    @DeleteMapping("/{project_id}/member/{member_info_id}")
    public ResponseEntity removeMember(@PathVariable("project_id") Long projectId, @PathVariable("member_info_id") Long recordId) throws ResearchShowService.ProjectNotFoundException {
        memberService.delete(projectId, recordId);
        return ResponseEntity.status(204).build();
    }

    /* project fund */

    @GetMapping("/{project_id}/fund")
    public List listFund(@PathVariable("project_id") Long projectId) throws ResearchShowService.ProjectNotFoundException {
        return fundService.list(projectId);
    }

    @PostMapping("/{project_id}/fund")
    public ProjectFund addFund(@PathVariable("project_id") Long projectId, @RequestBody ProjectFund data) throws ResearchShowService.ProjectNotFoundException {
        return fundService.create(projectId, data);
    }

    @PutMapping("/{project_id}/fund/{fund_id}")
    public ProjectFund updateFund(@PathVariable("project_id") Long projectId, @PathVariable("fund_id") Long fundId, @RequestBody ProjectFund data) throws ProjectFundService.ProjectFundNotFoundException, ResearchShowService.ProjectNotFoundException {
        return fundService.update(projectId, fundId, data);
    }

    @DeleteMapping("/{project_id}/fund/{fund_id}")
    public ResponseEntity removeFund(@PathVariable("project_id") Long projectId, @PathVariable("fund_id") Long fundId) throws ResearchShowService.ProjectNotFoundException {
        fundService.delete(projectId, fundId);
        return ResponseEntity.status(204).build();
    }
}
