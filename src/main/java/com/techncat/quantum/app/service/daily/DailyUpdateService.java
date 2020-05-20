package com.techncat.quantum.app.service.daily;

import com.techncat.quantum.app.model.daily.*;
import com.techncat.quantum.app.repository.daily.*;
import com.techncat.quantum.app.service.utils.JsonLoader;
import com.techncat.quantum.app.vos.daily.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DailyUpdateService {
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

    @Autowired
    JsonLoader jsonLoader;

    public Hosting update(Long id, HostingVO data) {
        Hosting record = showService.fetchHosting(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        return hostingRepository.save(record);
    }

    public Report update(Long id, ReportVO data) {
        Report record = showService.fetchReport(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        record.setInviter(jsonLoader.loadPeople(record.getInviterJson()));
        return reportRepository.save(record);
    }

    public Travel update(Long id, TravelVO data) {
        Travel record = showService.fetchTravel(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        record.setTraveler(jsonLoader.loadPeople(record.getTravelerJson()));
        return travelRepository.save(record);
    }

    public Visit update(Long id, VisitVO data) {
        Visit record = showService.fetchVisit(id);
        BeanUtils.copyProperties(data, record);
        record.setId(id);
        record.setUpdateAt(new Date());
        record.setReceptionist(jsonLoader.loadPeople(record.getReceptionistJson()));
        return visitRepository.save(record);
    }

    public TravelFlight update(Long flightId, TravelFlightVO flight) {
        TravelFlight record = showService.fetchTravelFlight(flightId);
        BeanUtils.copyProperties(flight, record);
        record.setId(flightId);
        record.setUpdateAt(new Date());
        return travelFlightRepository.save(record);
    }

    public VisitFlight update(Long flightId, VisitFlightVO flight) {
        VisitFlight record = showService.fetchVisitFlight(flightId);
        BeanUtils.copyProperties(flight, record);
        record.setId(flightId);
        record.setUpdateAt(new Date());
        return visitFlightRepository.save(record);
    }

}
