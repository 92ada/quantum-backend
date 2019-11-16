package com.techncat.quantum.app.controller.daily;

import com.techncat.quantum.app.model.daily.TravelFlight;
import com.techncat.quantum.app.model.daily.VisitFlight;
import com.techncat.quantum.app.service.daily.DailyCreateService;
import com.techncat.quantum.app.service.daily.DailyDeleteService;
import com.techncat.quantum.app.service.daily.DailyShowService;
import com.techncat.quantum.app.service.daily.DailyUpdateService;
import com.techncat.quantum.app.vos.daily.TravelFlightVO;
import com.techncat.quantum.app.vos.daily.VisitFlightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class DailyFlightController {
    @Autowired
    private DailyCreateService createService;
    @Autowired
    private DailyShowService showService;
    @Autowired
    private DailyUpdateService updateService;
    @Autowired
    private DailyDeleteService deleteService;

    /* travel flight */

    @GetMapping("/travel/{travel_id}/flights")
    public List listTravelFlight(@PathVariable("travel_id") Long id) {
        return showService.listTravelFlights(id);
    }

    @PostMapping("/travel/{travel_id}/flights")
    public ResponseEntity<TravelFlight> addFlight(@PathVariable("travel_id") Long id, @RequestBody TravelFlightVO data) {
        return ResponseEntity.status(201).body(createService.add(id, data));
    }

    @PutMapping("/travel/{travel_id}/flights/{flight_id}")
    public TravelFlight updateFlight(@PathVariable("travel_id") Long travelId, @PathVariable("flight_id") Long flightId, @RequestBody TravelFlightVO data) {
        return updateService.update(flightId, data);
    }

    @DeleteMapping("/travel/{travel_id}/flights/{flight_id}")
    public ResponseEntity removeTravelFlight(@PathVariable("travel_id") Long travelId, @PathVariable("flight_id") Long flightId) {
        deleteService.deleteTravelFlight(flightId);
        return ResponseEntity.status(204).build();
    }


    /* visit flight */

    @GetMapping("/visit/{visit_id}/flights")
    public List listVisitFlight(@PathVariable("visit_id") Long id) {
        return showService.listVisitFlights(id);
    }

    @PostMapping("/visit/{visit_id}/flights")
    public ResponseEntity<VisitFlight> addFlight(@PathVariable("visit_id") Long id, @RequestBody VisitFlightVO data) {
        return ResponseEntity.status(201).body(createService.add(id, data));
    }

    @PutMapping("/visit/{visit_id}/flights/{flight_id}")
    public VisitFlight updateFlight(@PathVariable("visit_id") Long visitId, @PathVariable("flight_id") Long flightId, @RequestBody VisitFlightVO data) {
        return updateService.update(flightId, data);
    }

    @DeleteMapping("/visit/{visit_id}/flights/{flight_id}")
    public ResponseEntity removeVisitFlight(@PathVariable("visit_id") Long visitId, @PathVariable("flight_id") Long flightId) {
        deleteService.deleteVisitFlight(flightId);
        return ResponseEntity.status(204).build();
    }
}
