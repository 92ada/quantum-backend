package com.techncat.quantum.app.service.daily;

import com.techncat.quantum.app.model.daily.Hosting;
import com.techncat.quantum.app.model.daily.Report;
import com.techncat.quantum.app.model.daily.Travel;
import com.techncat.quantum.app.model.daily.Visit;
import com.techncat.quantum.app.repository.daily.DailyHostingRepository;
import com.techncat.quantum.app.repository.daily.DailyReportRepository;
import com.techncat.quantum.app.repository.daily.DailyTravelRepository;
import com.techncat.quantum.app.repository.daily.DailyVisitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

    public Page<Hosting> searchHosting(Date start, Date end, PageRequest pageRequest) {
        if (start == null || end == null) return hostingRepository.findAll(pageRequest);
        return hostingRepository.findAllByTimeBetween(start, end, pageRequest);
    }

    public Page<Report> searchReport(Date start, Date end, PageRequest pageRequest) {
        if (start == null || end == null) return reportRepository.findAll(pageRequest);
        return reportRepository.findAllByTimeBetween(start, end, pageRequest);
    }

    public Page<Travel> searchTravel(Date start, Date end, PageRequest pageRequest) {
        if (start == null || end == null) return travelRepository.findAll(pageRequest);
        return travelRepository.findAllByStartDateBetween(start, end, pageRequest);
    }

    public Page<Visit> searchVisit(Date start, Date end, PageRequest pageRequest) {
        if (start == null || end == null) return visitRepository.findAll(pageRequest);
        return visitRepository.findAllByTimeBetween(start, end, pageRequest);
    }
}
