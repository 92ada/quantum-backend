package com.techncat.quantum.app.excel.controller;


import com.techncat.quantum.app.excel.model.daily.TravelRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.model.daily.Travel;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.daily.DailyTravelRepository;
import com.techncat.quantum.app.service.daily.Daily_SearchService;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.service.utils.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/excel/daily/travel")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class DailyTravelExcelController {
    @Resource
    private DailyTravelRepository dailyTravelRepository;
    @Autowired
    private Daily_SearchService daily_searchService;

    @Autowired
    private TimeFormatter timeFormatter;
    @Autowired
    private ExcelService excelService;

    /**
     * 模版下载
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/{anyname}-template.xlsx")
    public void aexcelModel(HttpServletResponse response) throws IOException {
        List<TravelRow> rows = new ArrayList<>();
        TravelRow row = new TravelRow();
        rows.add(row);
        excelService.export(rows, response.getOutputStream());
    }

    @GetMapping("/{anyname}.xlsx") // 导出后下载保存名字为：anyname.xls
    public void excelExport(// @ForkiAser Aser aser,
                            @RequestParam(value = "start", required = false) String start, // 2018-01-01
                            @RequestParam(value = "end", required = false) String end,
                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "limit", defaultValue = "10") Integer size,
                            @RequestParam(value = "order", defaultValue = "desc") String order,
                            @RequestParam(value = "by", defaultValue = "createdAt") String byProp,
                            HttpServletResponse response) throws IOException {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        Page<Travel> expPage = daily_searchService.searchTravel(startDate, endDate, request);
        excelService.export(expPage.getContent().parallelStream().map(TravelRow::render).collect(Collectors.toList()), response.getOutputStream());
    }

    @Autowired
    private PeopleShowService peopleShowService;

    /**
     * 导入
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping
    @Transactional
    public ResponseEntity excelImport(MultipartFile file) throws IOException {
        List<Travel> data = excelService.read(file, TravelRow.class).parallelStream().map(travelRow -> {
                    String sid = travelRow.getTravelerSid();
                    if (sid == null || sid.trim().equals("")) return null;
                    People people = peopleShowService.fetchBySid(sid);
                    Travel travel = TravelRow.load(travelRow);
                    travel.setTraveler(people);
                    return travel;
                }
        ).filter(Objects::nonNull).collect(Collectors.toList());
        dailyTravelRepository.saveAll(data);
        return ResponseEntity.status(201).body("import success");
    }
}
