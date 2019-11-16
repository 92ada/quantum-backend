package com.techncat.quantum.app.service.daily;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.daily.*;
import com.techncat.quantum.app.repository.daily.*;
import com.techncat.quantum.app.vos.daily.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DailyShowService {
    @Autowired
    private VOUtils voUtils;
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

    /* VO */

    public HostingVO fetchHostingVO(Long id) {
        return voUtils.copy(fetchHosting(id), HostingVO.class);
    }

    public ReportVO fetchReportVO(Long id) {
        return voUtils.copy(fetchReport(id), ReportVO.class);
    }

    public TravelVO fetchTravelVO(Long id) {
        return voUtils.copy(fetchTravel(id), TravelVO.class);
    }

    public VisitVO fetchVisitVO(Long id) {
        return voUtils.copy(fetchVisit(id), VisitVO.class);
    }

    public TravelFlightVO fetchTravelFlightVO(Long id) {
        return voUtils.copy(fetchTravelFlight(id), TravelFlightVO.class);
    }

    public VisitFlightVO fetchVisitFlightVO(Long id) {
        return voUtils.copy(fetchVisitFlight(id), VisitFlightVO.class);
    }

    public List<TravelFlightVO> listTravelFlightVO(Long travelId) {
        List<TravelFlight> flights = listTravelFlights(travelId);
        if (flights.isEmpty()) return new ArrayList<>();
        return flights.parallelStream().map(i -> voUtils.copy(i, TravelFlightVO.class)).collect(Collectors.toList());
    }

    public List<VisitFlightVO> listVisitFlightVO(Long visitId) {
        List<VisitFlight> flights = listVisitFlights(visitId);
        if (flights.isEmpty()) return new ArrayList<>();
        return flights.parallelStream().map(i -> voUtils.copy(i, VisitFlightVO.class)).collect(Collectors.toList());
    }

    /* DO */

    public Hosting fetchHosting(Long id) {
        Optional<Hosting> optional = hostingRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        throw new HostingNotFoundException(id);
    }

    public Report fetchReport(Long id) {
        Optional<Report> optional = reportRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        throw new ReportNotFoundException(id);
    }

    // travel & visit

    public Travel fetchTravel(Long id) {
        Optional<Travel> optional = travelRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        throw new TravelNotFoundException(id);
    }

    public Visit fetchVisit(Long id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        throw new VisitNotFoundException(id);
    }

    public TravelFlight fetchTravelFlight(Long id) {
        TravelFlight flight = travelFlightRepository.findFirstById(id);
        if (flight == null) throw new FlightNotFoundException(id);
        return flight;
    }

    public VisitFlight fetchVisitFlight(Long id) {
        VisitFlight flight = visitFlightRepository.findFirstById(id);
        if (flight == null) throw new FlightNotFoundException(id);
        return flight;
    }

    public List<TravelFlight> listTravelFlights(Long travelId) {
        return travelFlightRepository.findAllByTravel(fetchTravel(travelId));
    }

    public List<VisitFlight> listVisitFlights(Long visitId) {
        return visitFlightRepository.findAllByVisit(fetchVisit(visitId));
    }

    // exceptions

    public static class HostingNotFoundException extends RuntimeException {
        HostingNotFoundException(Long id) {
            super("Host id=[" + id + "] Not Found");
        }
    }

    public static class ReportNotFoundException extends RuntimeException {
        ReportNotFoundException(Long id) {
            super("Report id=[" + id + "] Not Found");
        }
    }

    public static class TravelNotFoundException extends RuntimeException {
        TravelNotFoundException(Long id) {
            super("Travel id=[" + id + "] Not Found");
        }
    }

    public static class VisitNotFoundException extends RuntimeException {
        VisitNotFoundException(Long id) {
            super("Visit id=[" + id + "] Not Found");
        }
    }

    public static class FlightNotFoundException extends RuntimeException {
        FlightNotFoundException(Long id) {
            super("Flight id=[" + id + "] Not Found");
        }
    }
}
