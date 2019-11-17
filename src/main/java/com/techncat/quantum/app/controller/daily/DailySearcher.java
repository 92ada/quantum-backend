package com.techncat.quantum.app.controller.daily;

import com.techncat.quantum.app.model.daily.Hosting;
import com.techncat.quantum.app.model.daily.Report;
import com.techncat.quantum.app.model.daily.Travel;
import com.techncat.quantum.app.model.daily.Visit;
import com.techncat.quantum.app.service.daily.Daily_SearchService;
import com.techncat.quantum.app.service.utils.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/daily")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class DailySearcher {
    @Autowired
    private Daily_SearchService searchService;
    @Autowired
    private TimeFormatter timeFormatter;

    @GetMapping("/hosting")
    public Page<Hosting> searchHosting(@RequestParam(value = "start", required = false) String start, // 2018-01-01
                                       @RequestParam(value = "end", required = false) String end,
                                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                       @RequestParam(value = "order", defaultValue = "desc") String order,
                                       @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return searchService.searchHosting(startDate, endDate, request);
    }

    @GetMapping("/report")
    public Page<Report> searchReport(@RequestParam(value = "start", required = false) String start, // 2018-01-01
                                     @RequestParam(value = "end", required = false) String end,
                                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                     @RequestParam(value = "order", defaultValue = "desc") String order,
                                     @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return searchService.searchReport(startDate, endDate, request);
    }

    @GetMapping("/travel")
    public Page<Travel> searchTravel(@RequestParam(value = "start", required = false) String start, // 2018-01-01
                                     @RequestParam(value = "end", required = false) String end,
                                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                     @RequestParam(value = "order", defaultValue = "desc") String order,
                                     @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return searchService.searchTravel(startDate, endDate, request);
    }

    @GetMapping("/visit")
    public Page<Visit> searchVisit(@RequestParam(value = "start", required = false) String start, // 2018-01-01
                                   @RequestParam(value = "end", required = false) String end,
                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                   @RequestParam(value = "order", defaultValue = "desc") String order,
                                   @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return searchService.searchVisit(startDate, endDate, request);
    }

}
