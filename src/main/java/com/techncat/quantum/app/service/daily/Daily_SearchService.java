package com.techncat.quantum.app.service.daily;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.daily.Hosting;
import com.techncat.quantum.app.model.daily.Report;
import com.techncat.quantum.app.model.daily.Travel;
import com.techncat.quantum.app.model.daily.Visit;
import com.techncat.quantum.app.repository.daily.DailyHostingRepository;
import com.techncat.quantum.app.repository.daily.DailyReportRepository;
import com.techncat.quantum.app.repository.daily.DailyTravelRepository;
import com.techncat.quantum.app.repository.daily.DailyVisitRepository;
import com.techncat.quantum.app.service.people.LabRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.techncat.quantum.app.common.auth.AuthUtil.isRoot;

@Service
public class Daily_SearchService {
    @Resource
    private DailyHostingRepository hostingRepository;
    @Resource
    private DailyReportRepository reportRepository;
    @Resource
    private DailyTravelRepository travelRepository;
    @Resource
    private DailyVisitRepository visitRepository;
    @Autowired
    private LabRunner runner;

    public Page<Hosting> searchHosting(Aser aser, Date start, Date end, PageRequest pageRequest) {
        if (start == null || end == null) return hostingRepository.findAll(pageRequest);
        return hostingRepository.findAllByTimeBetween(start, end, pageRequest);
    }

    public Page<Report> searchReport(Aser aser, Date start, Date end, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return reportRepository.findAll(pageRequest);
        }
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());

        if (start == null || end == null) return reportRepository.findAllByInviter_IdIn(peopleIds, pageRequest);
        return reportRepository.findAllByTimeBetweenAndInviter_IdIn(start, end, peopleIds, pageRequest);
    }

    public Page<Travel> searchTravel(Aser aser, Date start, Date end, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return travelRepository.findAll(pageRequest);
        }
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());

        if (start == null || end == null) return travelRepository.findAllByTraveler_IdIn(peopleIds, pageRequest);
        return travelRepository.findAllByStartDateBetweenAndTraveler_IdIn(start, end, peopleIds, pageRequest);
    }

    public Page<Visit> searchVisit(Aser aser, Date start, Date end, PageRequest pageRequest) {
        if (isRoot(aser)) {
            return visitRepository.findAll(pageRequest);
        }
        List<Long> peopleIds = runner.fixUserIds(aser.getSid());

        if (start == null || end == null) return visitRepository.findAllByReceptionist_IdIn(peopleIds, pageRequest);
        return visitRepository.findAllByTimeBetweenAndReceptionist_IdIn(start, end, peopleIds, pageRequest);
    }
}
