package com.techncat.quantum.app.controller.daily;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.annotation.ROLE;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.model.daily.Report;
import com.techncat.quantum.app.model.daily.Travel;
import com.techncat.quantum.app.model.daily.Visit;
import com.techncat.quantum.app.service.daily.DailyCreateService;
import com.techncat.quantum.app.service.daily.DailyDeleteService;
import com.techncat.quantum.app.service.daily.DailyShowService;
import com.techncat.quantum.app.service.daily.DailyUpdateService;
import com.techncat.quantum.app.vos.daily.HostingVO;
import com.techncat.quantum.app.vos.daily.ReportVO;
import com.techncat.quantum.app.vos.daily.TravelVO;
import com.techncat.quantum.app.vos.daily.VisitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.techncat.quantum.app.common.auth.AuthUtil.hasAuth;

@RestController
@RequestMapping("/api/daily")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class DailyController {
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;
    @Autowired
    private DailyCreateService createService;
    @Autowired
    private DailyShowService showService;
    @Autowired
    private DailyUpdateService updateService;
    @Autowired
    private DailyDeleteService deleteService;

    /* hosting */

    @GetMapping("/hosting/structure")
    public ResponseEntity<Map> astructureInfo1() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new HostingVO());
        result.put("index", "daily.hosting");
        result.put("post_url", "/api/daily/hosting");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/hosting/{id}")
    public ResponseEntity<HostingVO> showHosting(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_hosting}) Aser aser,
                                                 @PathVariable("id") Long id) {
        return ResponseEntity.ok(showService.fetchHostingVO(id));
    }

    @GetMapping("/hosting/{id}/structure")
    public ResponseEntity<Map> showHostingStructure(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_hosting}) Aser aser,
                                                    @PathVariable("id") Long id) throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", showService.fetchHostingVO(id));
        result.put("index", "daily.hosting");
        result.put("update_url", "/api/daily/hosting/" + id);
        result.put("delete_url", "/api/daily/hosting/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/hosting")
    public ResponseEntity create(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_hosting}) Aser aser,
                                 @RequestBody HostingVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/hosting/{id}")
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_hosting}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody HostingVO data) {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/hosting/{id}")
    public ResponseEntity deleteHosting(@ForkiAser(requiredRoles = {ROLE.delete_daily, ROLE.delete_daily_hosting}) Aser aser,
                                        @PathVariable("id") Long id) {
        deleteService.deleteHosting(id);
        return ResponseEntity.status(204).build();
    }

    /* report */

    @GetMapping("/report/structure")
    public ResponseEntity<Map> astructureInfo2() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new ReportVO());
        result.put("index", "daily.report");
        result.put("post_url", "/api/daily/report");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<ReportVO> showReport(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_report}) Aser aser,
                                               @PathVariable("id") Long id) {
        Report report = showService.fetchReport(id);
        if (report.getInviter() != null && !hasAuth(aser, report.getInviter().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(showService.fetchReportVO(id));
    }

    @GetMapping("/report/{id}/structure")
    public ResponseEntity<Map> showReportStructure(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_report}) Aser aser,
                                                   @PathVariable("id") Long id) throws IllegalAccessException {
        Report report = showService.fetchReport(id);
        if (report.getInviter() != null && !hasAuth(aser, report.getInviter().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        Map result = voEnhanceUtil.enhance("data", showService.fetchReportVO(id));
        result.put("index", "daily.report");
        result.put("update_url", "/api/daily/report/" + id);
        result.put("delete_url", "/api/daily/report/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/report")
    public ResponseEntity create(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_report}) Aser aser,
                                 @RequestBody ReportVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/report/{id}")
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_report}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody ReportVO data) {
        Report report = showService.fetchReport(id);
        if (report.getInviter() != null && !hasAuth(aser, report.getInviter().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/report/{id}")
    public ResponseEntity deleteReport(@ForkiAser(requiredRoles = {ROLE.delete_daily, ROLE.delete_daily_report}) Aser aser,
                                       @PathVariable("id") Long id) {
        Report report = showService.fetchReport(id);
        if (report.getInviter() != null && !hasAuth(aser, report.getInviter().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        deleteService.deleteReport(id);
        return ResponseEntity.status(204).build();
    }

    /* travel */

    @GetMapping("/travel/structure")
    public ResponseEntity<Map> astructureInfo3() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new TravelVO());
        result.put("index", "daily.travel");
        result.put("post_url", "/api/daily/travel");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/travel/{id}")
    public ResponseEntity<TravelVO> showTravel(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_travel}) Aser aser,
                                               @PathVariable("id") Long id) {
        Travel travel = showService.fetchTravel(id);
        if (travel.getTraveler() != null && !hasAuth(aser, travel.getTraveler().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(showService.fetchTravelVO(id));
    }

    @GetMapping("/travel/{id}/structure")
    public ResponseEntity<Map> showTravelStructure(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_travel}) Aser aser,
                                                   @PathVariable("id") Long id) throws IllegalAccessException {
        Travel travel = showService.fetchTravel(id);
        if (travel.getTraveler() != null && !hasAuth(aser, travel.getTraveler().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        Map result = voEnhanceUtil.enhance("data", showService.fetchTravelVO(id));
        result.put("index", "daily.travel");
        result.put("update_url", "/api/daily/travel/" + id);
        result.put("delete_url", "/api/daily/travel/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/travel")
    public ResponseEntity create(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_travel}) Aser aser,
                                 @RequestBody TravelVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/travel/{id}")
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_travel}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody TravelVO data) {
        Travel travel = showService.fetchTravel(id);
        if (travel.getTraveler() != null && !hasAuth(aser, travel.getTraveler().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/travel/{id}")
    public ResponseEntity deleteTravel(@ForkiAser(requiredRoles = {ROLE.delete_daily, ROLE.delete_daily_travel}) Aser aser,
                                       @PathVariable("id") Long id) {
        Travel travel = showService.fetchTravel(id);
        if (travel.getTraveler() != null && !hasAuth(aser, travel.getTraveler().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        deleteService.deleteTravel(id);
        return ResponseEntity.status(204).build();
    }

    /* visit */

    @GetMapping("/visit/structure")
    public ResponseEntity<Map> astructureInfo4() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new VisitVO());
        result.put("index", "daily.visit");
        result.put("post_url", "/api/daily/visit");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/visit/{id}")
    public ResponseEntity<VisitVO> showVisit(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_visit}) Aser aser,
                                             @PathVariable("id") Long id) {
        Visit visit = showService.fetchVisit(id);
        if (visit.getReceptionist() != null && !hasAuth(aser, visit.getReceptionist().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.ok(showService.fetchVisitVO(id));
    }

    @GetMapping("/visit/{id}/structure")
    public ResponseEntity<Map> showVisitStructure(@ForkiAser(requiredRoles = {ROLE.daily, ROLE.daily_visit}) Aser aser,
                                                  @PathVariable("id") Long id) throws IllegalAccessException {
        Visit visit = showService.fetchVisit(id);
        if (visit.getReceptionist() != null && !hasAuth(aser, visit.getReceptionist().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        Map result = voEnhanceUtil.enhance("data", showService.fetchVisitVO(id));
        result.put("index", "daily.visit");
        result.put("update_url", "/api/daily/visit/" + id);
        result.put("delete_url", "/api/daily/visit/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/visit")
    public ResponseEntity create(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_visit}) Aser aser,
                                 @RequestBody VisitVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/visit/{id}")
    public ResponseEntity update(@ForkiAser(requiredRoles = {ROLE.edit_daily, ROLE.edit_daily_visit}) Aser aser,
                                 @PathVariable("id") Long id, @RequestBody VisitVO data) {
        Visit visit = showService.fetchVisit(id);
        if (visit.getReceptionist() != null && !hasAuth(aser, visit.getReceptionist().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/visit/{id}")
    public ResponseEntity deleteVisit(@ForkiAser(requiredRoles = {ROLE.delete_daily, ROLE.delete_daily_visit}) Aser aser,
                                      @PathVariable("id") Long id) {
        Visit visit = showService.fetchVisit(id);
        if (visit.getReceptionist() != null && !hasAuth(aser, visit.getReceptionist().getId()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        deleteService.deleteVisit(id);
        return ResponseEntity.status(204).build();
    }
}
