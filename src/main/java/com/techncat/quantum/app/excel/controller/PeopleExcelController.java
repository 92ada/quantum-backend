package com.techncat.quantum.app.excel.controller;


import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.excel.model.people.*;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.excel.service.PeopleExcelService;
import com.techncat.quantum.app.model.people.*;
import com.techncat.quantum.app.repository.people.*;
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
import javax.transaction.Transactional;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.techncat.quantum.app.model.people.People.Type.*;

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
    @Resource
    private PeopleAdminRepository adminRepository;
    @Resource
    private PeoplePostdoctoralRepository postdoctoralRepository;
    @Resource
    private PeopleResearcherRepository researcherRepository;
    @Resource
    private PeopleStudentRepository studentRepository;
    @Resource
    private PeopleTeacherRepository teacherRepository;
    @Resource
    private PeopleVisitorRepository visitorRepository;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private PeopleExcelService peopleExcelService;

    /**
     * 模版下载
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/{anyname}-template.xlsx")
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
    @GetMapping("/{anyname}.xlsx") // 导出后下载保存名字为：anyname.xls
    public void excelExport(// @RequestParam(required = false) String sid,
                            @ForkiAser Aser aser,
                            @RequestParam(value = "word", required = false) String word,
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

        boolean isRoot = aser.getRoles().contains("ROOT") || aser.getRoles().contains("root");
        if (type == null && !isRoot) {
            peoplePage = people_searchService.search(word, aser.getSid(), request);
        }
        if (type == null && isRoot) {
            peoplePage = people_searchService.search(word, request);
        }
        if (type != null && !isRoot) {
            peoplePage = people_searchService.search(word, type, aser.getSid(), request);
        }
        if (type != null && isRoot) {
            peoplePage = people_searchService.search(word, type, request);
        }
        excelService.export(peoplePage
                        .getContent()
                        .parallelStream()
                        .map(PeopleRow::render)
                        .collect(Collectors.toList())
                , response.getOutputStream()
        );
    }

    /**
     * 导入
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping(("/{peopleType}"))
    @Transactional
    public ResponseEntity excelImport2(@PathVariable("peopleType") People.Type peopleType, @RequestParam(required = false, defaultValue = "false") Boolean force, MultipartFile file) throws IOException {
        // data prepare
        List<People> data;
        switch (peopleType) {
            case administration:
                data = excelService.read(file, PeopleAdminRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
                break;
            case postdoctoral:
                data = excelService.read(file, PeoplePostdoctoralRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
                break;
            case researcher:
                data = excelService.read(file, PeopleResearcherRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
                break;
            case student:
                data = excelService.read(file, PeopleStudentRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
                break;
            case teacher:
                data = excelService.read(file, PeopleTeacherRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
                break;
            case visitor:
                data = excelService.read(file, PeopleVisitorRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
                break;
            default:
                return ResponseEntity.status(400).body("Invalid path variable");
        }

        Boolean typeCheck = data.parallelStream().allMatch(people -> peopleType == people.getType());

        if (!typeCheck) {
            throw new IOException("导出数据中【人员类型】设置有误，请检查");
        }

        // start import

        List<Boolean> total_result = data.parallelStream().map(people -> peopleExcelService.create_or_update(people, force)).collect(Collectors.toList());

        // count result
        int nb_count = 0;
        int total_count = 0;
        for (boolean pass : total_result) {
            total_count += 1;
            nb_count += pass ? 1 : 0;
        }

        return ResponseEntity.status(201).body("总共数据【" + total_count + "】条；成功导入【" + nb_count + "】条，失败【" + (total_count - nb_count) + "】条");
    }
}
