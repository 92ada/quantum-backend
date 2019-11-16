package com.techncat.quantum.app.controller.daily;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.service.daily.DailyCreateService;
import com.techncat.quantum.app.service.daily.DailyDeleteService;
import com.techncat.quantum.app.service.daily.DailyShowService;
import com.techncat.quantum.app.service.daily.DailyUpdateService;
import com.techncat.quantum.app.vos.daily.HostingVO;
import com.techncat.quantum.app.vos.daily.ReportVO;
import com.techncat.quantum.app.vos.daily.TravelVO;
import com.techncat.quantum.app.vos.daily.VisitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<HostingVO> showHosting(@PathVariable("id") Long id) {
        return ResponseEntity.ok(showService.fetchHostingVO(id));
    }

    @GetMapping("/hosting/{id}/structure")
    public ResponseEntity<Map> showHostingStructure(@PathVariable("id") Long id) throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", showService.fetchHostingVO(id));
        result.put("index", "daily.hosting");
        result.put("update_url", "/api/daily/hosting/" + id);
        result.put("delete_url", "/api/daily/hosting/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/hosting")
    public ResponseEntity create(@RequestBody HostingVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/hosting/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody HostingVO data) {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/hosting/{id}")
    public ResponseEntity deleteHosting(@PathVariable("id") Long id) {
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
    public ResponseEntity<ReportVO> showReport(@PathVariable("id") Long id) {
        return ResponseEntity.ok(showService.fetchReportVO(id));
    }

    @GetMapping("/report/{id}/structure")
    public ResponseEntity<Map> showReportStructure(@PathVariable("id") Long id) throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", showService.fetchReportVO(id));
        result.put("index", "daily.report");
        result.put("update_url", "/api/daily/report/" + id);
        result.put("delete_url", "/api/daily/report/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/report")
    public ResponseEntity create(@RequestBody ReportVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/report/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ReportVO data) {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/report/{id}")
    public ResponseEntity deleteReport(@PathVariable("id") Long id) {
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
    public ResponseEntity<TravelVO> showTravel(@PathVariable("id") Long id) {
        return ResponseEntity.ok(showService.fetchTravelVO(id));
    }

    @GetMapping("/travel/{id}/structure")
    public ResponseEntity<Map> showTravelStructure(@PathVariable("id") Long id) throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", showService.fetchTravelVO(id));
        result.put("index", "daily.travel");
        result.put("update_url", "/api/daily/travel/" + id);
        result.put("delete_url", "/api/daily/travel/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/travel")
    public ResponseEntity create(@RequestBody TravelVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/travel/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody TravelVO data) {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/travel/{id}")
    public ResponseEntity deleteTravel(@PathVariable("id") Long id) {
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
    public ResponseEntity<VisitVO> showVisit(@PathVariable("id") Long id) {
        return ResponseEntity.ok(showService.fetchVisitVO(id));
    }

    @GetMapping("/visit/{id}/structure")
    public ResponseEntity<Map> showVisitStructure(@PathVariable("id") Long id) throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", showService.fetchVisitVO(id));
        result.put("index", "daily.visit");
        result.put("update_url", "/api/daily/visit/" + id);
        result.put("delete_url", "/api/daily/visit/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/visit")
    public ResponseEntity create(@RequestBody VisitVO data) {
        return ResponseEntity.status(201).body(createService.create(data));
    }

    @PutMapping("/visit/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody VisitVO data) {
        return ResponseEntity.status(201).body(updateService.update(id, data));
    }

    @DeleteMapping("/visit/{id}")
    public ResponseEntity deleteVisit(@PathVariable("id") Long id) {
        deleteService.deleteVisit(id);
        return ResponseEntity.status(204).build();
    }
}
