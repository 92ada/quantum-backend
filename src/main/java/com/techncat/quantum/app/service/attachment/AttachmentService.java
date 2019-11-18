package com.techncat.quantum.app.service.attachment;

import com.techncat.quantum.app.model.attachment.Attachment;
import com.techncat.quantum.app.model.attachment.daily.HostingAttachment;
import com.techncat.quantum.app.model.attachment.daily.ReportAttachment;
import com.techncat.quantum.app.model.attachment.daily.VisitAttachment;
import com.techncat.quantum.app.model.attachment.people.PeopleAttachment;
import com.techncat.quantum.app.model.attachment.research.PaperAttachment;
import com.techncat.quantum.app.model.attachment.research.PatentAttachment;
import com.techncat.quantum.app.model.attachment.research.ProjectAttachment;
import com.techncat.quantum.app.model.attachment.research.RewardAttachment;
import com.techncat.quantum.app.repository.attachment.daily.HostingAttachmentRepository;
import com.techncat.quantum.app.repository.attachment.daily.ReportAttachmentRepository;
import com.techncat.quantum.app.repository.attachment.daily.VisitAttachmentRepository;
import com.techncat.quantum.app.repository.attachment.people.PeopleAttachmentRepository;
import com.techncat.quantum.app.repository.attachment.research.PaperAttachmentRepository;
import com.techncat.quantum.app.repository.attachment.research.PatentAttachmentRepository;
import com.techncat.quantum.app.repository.attachment.research.ProjectAttachmentRepository;
import com.techncat.quantum.app.repository.attachment.research.RewardAttachmentRepository;
import com.techncat.quantum.app.service.daily.DailyShowService;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.service.research.ResearchShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttachmentService {
    @Resource
    private HostingAttachmentRepository hostingAttachmentRepository;
    @Resource
    private ReportAttachmentRepository reportAttachmentRepository;
    @Resource
    private VisitAttachmentRepository visitAttachmentRepository;
    @Resource
    private PaperAttachmentRepository paperAttachmentRepository;
    @Resource
    private PatentAttachmentRepository patentAttachmentRepository;
    @Resource
    private ProjectAttachmentRepository projectAttachmentRepository;
    @Resource
    private RewardAttachmentRepository rewardAttachmentRepository;
    @Resource
    private PeopleAttachmentRepository peopleAttachmentRepository;
    @Autowired
    private DailyShowService dailyShowService;
    @Autowired
    private ResearchShowService researchShowService;
    @Autowired
    private PeopleShowService peopleShowService;

    // list

    public List<Attachment> listHostingAttachment(Long id) {
        return hostingAttachmentRepository.findAllByHosting(dailyShowService.fetchHosting(id)).parallelStream().map(HostingAttachment::getAttachment).collect(Collectors.toList());
    }

    public List<Attachment> listReportAttachment(Long id) {
        return reportAttachmentRepository.findAllByReport(dailyShowService.fetchReport(id)).parallelStream().map(ReportAttachment::getAttachment).collect(Collectors.toList());
    }

    public List<Attachment> listVisitAttachment(Long id) {
        return visitAttachmentRepository.findAllByVisit(dailyShowService.fetchVisit(id)).parallelStream().map(VisitAttachment::getAttachment).collect(Collectors.toList());
    }

    public List<Attachment> listPaperAttachment(Long id) {
        return paperAttachmentRepository.findAllByPaper(researchShowService.fetchPaper(id)).parallelStream().map(PaperAttachment::getAttachment).collect(Collectors.toList());
    }

    public List<Attachment> listPatentAttachment(Long id) {
        return patentAttachmentRepository.findAllByPatent(researchShowService.fetchPatent(id)).parallelStream().map(PatentAttachment::getAttachment).collect(Collectors.toList());
    }

    public List<Attachment> listProjectAttachment(Long id) {
        return projectAttachmentRepository.findAllByProject(researchShowService.fetchProject(id)).parallelStream().map(ProjectAttachment::getAttachment).collect(Collectors.toList());
    }

    public List<Attachment> listRewardAttachment(Long id) {
        return rewardAttachmentRepository.findAllByReward(researchShowService.fetchReward(id)).parallelStream().map(RewardAttachment::getAttachment).collect(Collectors.toList());
    }

    public List<Attachment> listPeopleAttachment(Long id) {
        return peopleAttachmentRepository.findAllByPeople(peopleShowService.fetchBase(id)).parallelStream().map(PeopleAttachment::getAttachment).collect(Collectors.toList());
    }

    // daily

    public void createHostingAttachment(Long hostingId, Attachment attachment) {
        HostingAttachment model = new HostingAttachment();
        model.setAttachment(attachment);
        model.setHosting(dailyShowService.fetchHosting(hostingId));
        hostingAttachmentRepository.save(model);
    }

    public void deleteHostingAttachment(Long hostingAttachmentId) {
        HostingAttachment record = hostingAttachmentRepository.getOne(hostingAttachmentId);
        if (record != null)
            hostingAttachmentRepository.delete(record);
    }

    public void createReportAttachment(Long reportId, Attachment attachment) {
        ReportAttachment model = new ReportAttachment();
        model.setAttachment(attachment);
        model.setReport(dailyShowService.fetchReport(reportId));
        reportAttachmentRepository.save(model);
    }

    public void deleteReportAttachment(Long reportAttachmentId) {
        ReportAttachment record = reportAttachmentRepository.getOne(reportAttachmentId);
        if (record != null)
            reportAttachmentRepository.delete(record);
    }

    public void createVisitAttachment(Long visitId, Attachment attachment) {
        VisitAttachment model = new VisitAttachment();
        model.setAttachment(attachment);
        model.setVisit(dailyShowService.fetchVisit(visitId));
        visitAttachmentRepository.save(model);
    }

    public void deleteVisitAttachment(Long visitAttachmentId) {
        VisitAttachment record = visitAttachmentRepository.getOne(visitAttachmentId);
        if (record != null)
            visitAttachmentRepository.delete(record);
    }

    // research

    public void createPaperAttachment(Long paperId, Attachment attachment) {
        PaperAttachment model = new PaperAttachment();
        model.setAttachment(attachment);
        model.setPaper(researchShowService.fetchPaper(paperId));
        paperAttachmentRepository.save(model);
    }

    public void deletePaperAttachment(Long paperAttachmentId) {
        PaperAttachment record = paperAttachmentRepository.getOne(paperAttachmentId);
        if (record != null)
            paperAttachmentRepository.delete(record);
    }

    public void createPatentAttachment(Long patentId, Attachment attachment) {
        PatentAttachment model = new PatentAttachment();
        model.setAttachment(attachment);
        model.setPatent(researchShowService.fetchPatent(patentId));
        patentAttachmentRepository.save(model);
    }

    public void deletePatentAttachment(Long patentAttachmentId) {
        PatentAttachment record = patentAttachmentRepository.getOne(patentAttachmentId);
        if (record != null)
            patentAttachmentRepository.delete(record);
    }

    public void createProjectAttachment(Long projectId, Attachment attachment) {
        ProjectAttachment model = new ProjectAttachment();
        model.setAttachment(attachment);
        model.setProject(researchShowService.fetchProject(projectId));
        projectAttachmentRepository.save(model);
    }

    public void deleteProjectAttachment(Long projectAttachmentId) {
        ProjectAttachment record = projectAttachmentRepository.getOne(projectAttachmentId);
        if (record != null)
            projectAttachmentRepository.delete(record);
    }

    public void createRewardAttachment(Long rewardId, Attachment attachment) {
        RewardAttachment model = new RewardAttachment();
        model.setAttachment(attachment);
        model.setReward(researchShowService.fetchReward(rewardId));
        rewardAttachmentRepository.save(model);
    }

    public void deleteRewardAttachment(Long rewardAttachmentId) {
        RewardAttachment record = rewardAttachmentRepository.getOne(rewardAttachmentId);
        if (record != null)
            rewardAttachmentRepository.delete(record);
    }

    // people

    public void createPeopleAttachment(Long peopleId, Attachment attachment) {
        PeopleAttachment model = new PeopleAttachment();
        model.setAttachment(attachment);
        model.setPeople(peopleShowService.fetchBase(peopleId));
        peopleAttachmentRepository.save(model);
    }

    public void deletePeopleAttachment(Long peopleAttachmentId) {
        PeopleAttachment record = peopleAttachmentRepository.getOne(peopleAttachmentId);
        if (record != null)
            peopleAttachmentRepository.delete(record);
    }
}
