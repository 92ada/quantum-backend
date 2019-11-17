package com.techncat.quantum.app.excel.downloader;


import com.techncat.quantum.app.excel.model.people.PeopleRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.People_Repository;
import com.techncat.quantum.app.service.people.People_SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/excel/people")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class PeopleExcelController {
    @Autowired
    private People_SearchService people_searchService;
    @Resource
    private People_Repository people_repository;
    @Autowired
    private ExcelService excelService;

    /**
     * 模版下载
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/{anyname}-template.xls")
    public void aexcelModel(HttpServletResponse response) throws IOException {
        List<PeopleRow> peopleRows = new ArrayList<>();
        PeopleRow row = new PeopleRow();
        peopleRows.add(row);
        excelService.export(peopleRows, response.getOutputStream());

    }

    /**
     * 导出
     *
     * @param word
     * @param type
     * @param order
     * @param byProp
     * @param response
     * @throws IOException
     */
    @GetMapping("/{anyname}.xls") // 导出后下载保存名字为：anyname.xls
    public void excelExport(@RequestParam(value = "word", required = false) String word,
                            @RequestParam(value = "type", required = false) People.Type type,
                            @RequestParam(value = "order", defaultValue = "desc") String order,
                            @RequestParam(value = "by", defaultValue = "createdAt") String byProp,
                            HttpServletResponse response) throws IOException {
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(0, 10000, sort); // max: 10000
        Page<People> peoplePage = null;
        if (type == null) {
            peoplePage = people_searchService.search(word, request);
        } else {
            peoplePage = people_searchService.search(word, type, request);
        }
        excelService.export(peoplePage.getContent().parallelStream().map(PeopleRow::render).collect(Collectors.toList()), response.getOutputStream());
    }

    /**
     * 导入
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping
    public ResponseEntity excelImport(MultipartFile file) throws IOException {
        List<People> data = excelService.read(file, PeopleRow.class).parallelStream().map(PeopleRow::load).collect(Collectors.toList());
        // insert
        people_repository.saveAll(data);
        return ResponseEntity.status(201).body("import success");
    }
}
