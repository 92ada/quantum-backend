package com.techncat.quantum.app.controller.attachment;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.service.attachment.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachment")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    // hosting

    @GetMapping("/hosting/{hosting_id}")
    public List<Attachment> listHosting(@PathVariable("hosting_id") Long id) {
        return attachmentService.listHostingAttachment(id);
    }

    @PostMapping("/hosting/{hosting_id}")
    public ResponseEntity createHosting(@PathVariable("hosting_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createHostingAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/hosting/{hosting_id}/{attachment_id}")
    public ResponseEntity deleteHosting(@PathVariable("hosting_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deleteHostingAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

    // report

    @GetMapping("/report/{report_id}")
    public List<Attachment> listReport(@PathVariable("report_id") Long id) {
        return attachmentService.listReportAttachment(id);
    }

    @PostMapping("/report/{report_id}")
    public ResponseEntity createReport(@PathVariable("report_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createReportAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/report/{report_id}/{attachment_id}")
    public ResponseEntity deleteReport(@PathVariable("report_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deleteReportAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

    // visit

    @GetMapping("/visit/{visit_id}")
    public List<Attachment> listVisit(@PathVariable("visit_id") Long id) {
        return attachmentService.listVisitAttachment(id);
    }

    @PostMapping("/visit/{visit_id}")
    public ResponseEntity createVisit(@PathVariable("visit_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createVisitAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/visit/{visit_id}/{attachment_id}")
    public ResponseEntity deleteVisit(@PathVariable("visit_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deleteVisitAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

    // paper

    @GetMapping("/paper/{paper_id}")
    public List<Attachment> listPaper(@PathVariable("paper_id") Long id) {
        return attachmentService.listPaperAttachment(id);
    }

    @PostMapping("/paper/{paper_id}")
    public ResponseEntity createPaper(@PathVariable("paper_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createPaperAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/paper/{paper_id}/{attachment_id}")
    public ResponseEntity deletePaper(@PathVariable("paper_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deletePaperAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

    // patent

    @GetMapping("/patent/{patent_id}")
    public List<Attachment> listPatent(@PathVariable("patent_id") Long id) {
        return attachmentService.listPatentAttachment(id);
    }

    @PostMapping("/patent/{patent_id}")
    public ResponseEntity createPatent(@PathVariable("patent_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createPatentAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/patent/{patent_id}/{attachment_id}")
    public ResponseEntity deletePatent(@PathVariable("patent_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deletePatentAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

    // project

    @GetMapping("/project/{project_id}")
    public List<Attachment> listProject(@PathVariable("project_id") Long id) {
        return attachmentService.listProjectAttachment(id);
    }

    @PostMapping("/project/{project_id}")
    public ResponseEntity createProject(@PathVariable("project_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createProjectAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/project/{project_id}/{attachment_id}")
    public ResponseEntity deleteProject(@PathVariable("project_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deleteProjectAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

    // reward

    @GetMapping("/reward/{reward_id}")
    public List<Attachment> listReward(@PathVariable("reward_id") Long id) {
        return attachmentService.listRewardAttachment(id);
    }

    @PostMapping("/reward/{reward_id}")
    public ResponseEntity createReward(@PathVariable("reward_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createRewardAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/reward/{reward_id}/{attachment_id}")
    public ResponseEntity deleteReward(@PathVariable("reward_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deleteRewardAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

    // people

    @GetMapping("/people/{people_id}")
    public List<Attachment> listPeople(@PathVariable("people_id") Long id) {
        return attachmentService.listPeopleAttachment(id);
    }

    @PostMapping("/people/{people_id}")
    public ResponseEntity createPeople(@PathVariable("people_id") Long id, @RequestBody Attachment attachment) {
        attachmentService.createPeopleAttachment(id, attachment);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/people/{people_id}/{attachment_id}")
    public ResponseEntity deletePeople(@PathVariable("people_id") Long id, @PathVariable("attachment_id") Long attachmentId) {
        attachmentService.deletePeopleAttachment(attachmentId);
        return ResponseEntity.status(204).build();
    }

}
