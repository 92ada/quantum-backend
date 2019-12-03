package com.techncat.quantum.app.excel.downloader;


import com.techncat.quantum.app.excel.model.people.PeopleRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.model.people.*;
import com.techncat.quantum.app.repository.attachment.people.PeopleAttachmentRepository;
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
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
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
    public ResponseEntity excelImport(MultipartFile file) throws IOException, SQLIntegrityConstraintViolationException {
        List<People> data = excelService.read(file, PeopleRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
        List<People> dataF = data.parallelStream().map(people -> {
            if (null != people.getType())
                switch (people.getType()) {
                    case administration:
                        people.setPeopleAdmin(adminRepository.save(new PeopleAdmin()));
                        break;
                    case postdoctoral:
                        people.setPeoplePostdoctoral(postdoctoralRepository.save(new PeoplePostdoctoral()));
                        break;
                    case researcher:
                        people.setPeopleResearcher(researcherRepository.save(new PeopleResearcher()));
                        break;
                    case student:
                        people.setPeopleStudent(studentRepository.save(new PeopleStudent()));
                        break;
                    case teacher:
                        people.setPeopleTeacher(teacherRepository.save(new PeopleTeacher()));
                        break;
                    case visitor:
                        people.setPeopleVisitor(visitorRepository.save(new PeopleVisitor()));
                        break;
                }
            return people;
        }).collect(Collectors.toList());
        // insert
        people_repository.saveAll(dataF);
        return ResponseEntity.status(201).body("import success");
    }
}
