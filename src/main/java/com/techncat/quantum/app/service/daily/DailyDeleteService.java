package com.techncat.quantum.app.service.daily;

import com.techncat.quantum.app.repository.daily.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DailyDeleteService {
    @Autowired
    private DailyShowService showService;
    @Resource
    private DailyHostingRepository hostingRepository;
    @Resource
    private DailyReportRepository reportRepository;
    @Resource
    private DailyTravelRepository travelRepository;
    @Resource
    private DailyVisitRepository visitRepository;
    @Resource
    private DailyTravelFlightRepository travelFlightRepository;
    @Resource
    private DailyVisitFlightRepository visitFlightRepository;

    public void deleteHosting(Long id) {
        hostingRepository.delete(showService.fetchHosting(id));
    }

    public void deleteReport(Long id) {
        reportRepository.delete(showService.fetchReport(id));
    }

    public void deleteTravel(Long id) {
        travelRepository.delete(showService.fetchTravel(id));
    }

    public void deleteVisit(Long id) {
        visitRepository.delete(showService.fetchVisit(id));
    }

    public void deleteTravelFlight(Long id) {
        travelFlightRepository.delete(showService.fetchTravelFlight(id));
    }

    public void deleteVisitFlight(Long id) {
        visitFlightRepository.delete(showService.fetchVisitFlight(id));
    }

    public void deleteAllTravelFlight(Long travelId) {
        travelFlightRepository.deleteAllByTravel(showService.fetchTravel(travelId));
    }

    public void deleteAllVisitFlight(Long visitId) {
        visitFlightRepository.deleteAllByVisit(showService.fetchVisit(visitId));
    }
}
