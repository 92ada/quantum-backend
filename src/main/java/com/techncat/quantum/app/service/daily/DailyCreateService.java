package com.techncat.quantum.app.service.daily;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.daily.*;
import com.techncat.quantum.app.repository.daily.*;
import com.techncat.quantum.app.vos.daily.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DailyCreateService {
    @Autowired
    private VOUtils voUtils;
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

    public Hosting create(HostingVO data) {
        Hosting preData = voUtils.copy(data, Hosting.class);
        preData.setId(null);
        preData.setUpdateAt(new Date());
        preData.setCreatedAt(new Date());
        return hostingRepository.save(preData);
    }

    public Report create(ReportVO data) {
        Report preData = voUtils.copy(data, Report.class);
        preData.setId(null);
        preData.setUpdateAt(new Date());
        preData.setCreatedAt(new Date());
        return reportRepository.save(preData);
    }

    public Travel create(TravelVO data) {
        Travel preData = voUtils.copy(data, Travel.class);
        preData.setId(null);
        preData.setUpdateAt(new Date());
        preData.setCreatedAt(new Date());
        return travelRepository.save(preData);
    }

    public Visit create(VisitVO data) {
        Visit preData = voUtils.copy(data, Visit.class);
        preData.setId(null);
        preData.setUpdateAt(new Date());
        preData.setCreatedAt(new Date());
        return visitRepository.save(preData);
    }

    public TravelFlight add(Long travelId, TravelFlightVO flightData) {
        Travel travel = showService.fetchTravel(travelId);
        TravelFlight flight = voUtils.copy(flightData, TravelFlight.class);
        flight.setId(null);
        flight.setUpdateAt(new Date());
        flight.setCreatedAt(new Date());
        flight.setTravel(travel);
        return travelFlightRepository.save(flight);
    }

    public VisitFlight add(Long visitId, VisitFlightVO flightData) {
        Visit visit = showService.fetchVisit(visitId);
        VisitFlight flight = voUtils.copy(flightData, VisitFlight.class);
        flight.setId(null);
        flight.setUpdateAt(new Date());
        flight.setCreatedAt(new Date());
        flight.setVisit(visit);
        return visitFlightRepository.save(flight);
    }

}
