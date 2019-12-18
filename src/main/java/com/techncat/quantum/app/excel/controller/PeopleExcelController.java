package com.techncat.quantum.app.excel.controller;


import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.excel.model.people.PeopleRow;
import com.techncat.quantum.app.excel.service.ExcelService;
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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

//        if (type == null) {
//            peoplePage =  people_searchService.search(word, sid, request);
//        } else {
//            peoplePage =  people_searchService.search(word, type, sid, request);
//        }
        boolean isRoot = aser.getRoles().contains("ROOT") || aser.getRoles().contains("root");
        if (type == null && !isRoot) {
            peoplePage =  people_searchService.search(word, aser.getSid(), request);
        }
        if (type == null && isRoot) {
            peoplePage =  people_searchService.search(word, request);
        }
        if (type != null && !isRoot) {
            peoplePage =  people_searchService.search(word, type, aser.getSid(), request);
        }
        if (type != null && isRoot) {
            peoplePage =  people_searchService.search(word, type, request);
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
    @Transactional
    public ResponseEntity excelImport(MultipartFile file) throws IOException {
        List<People> data = excelService.read(file, PeopleRow.class).parallelStream().map(PeopleRow::load).filter(Objects::nonNull).collect(Collectors.toList());
        data.parallelStream().forEach(people -> {
            if (null != people.getType())
                switch (people.getType()) {
                    case administration:
                        PeopleAdmin peopleAdmin = adminRepository.save(new PeopleAdmin());
                        people.setPeopleAdmin(peopleAdmin);
                        people = people_repository.save(people);
                        peopleAdmin.setPeople(people);
                        adminRepository.save(peopleAdmin);
                        return;
                    case postdoctoral:
                        PeoplePostdoctoral peoplePostdoctoral = postdoctoralRepository.save(new PeoplePostdoctoral());
                        people.setPeoplePostdoctoral(peoplePostdoctoral);
                        people = people_repository.save(people);
                        peoplePostdoctoral.setPeople(people);
                        postdoctoralRepository.save(peoplePostdoctoral);
                        return;
                    case researcher:
                        PeopleResearcher peopleResearcher = researcherRepository.save(new PeopleResearcher());
                        people.setPeopleResearcher(peopleResearcher);
                        people = people_repository.save(people);
                        peopleResearcher.setPeople(people);
                        researcherRepository.save(peopleResearcher);
                        return;
                    case student:
                        PeopleStudent peopleStudent = studentRepository.save(new PeopleStudent());
                        people.setPeopleStudent(peopleStudent);
                        people = people_repository.save(people);
                        peopleStudent.setPeople(people);
                        studentRepository.save(peopleStudent);
                        return;
                    case teacher:
                        PeopleTeacher peopleTeacher = teacherRepository.save(new PeopleTeacher());
                        people.setPeopleTeacher(peopleTeacher);
                        people = people_repository.save(people);
                        peopleTeacher.setPeople(people);
                        teacherRepository.save(peopleTeacher);
                        return;
                    case visitor:
                        PeopleVisitor peopleVisitor = visitorRepository.save(new PeopleVisitor());
                        people.setPeopleVisitor(peopleVisitor);
                        people = people_repository.save(people);
                        peopleVisitor.setPeople(people);
                        visitorRepository.save(peopleVisitor);
                        return;
                }
        });
        return ResponseEntity.status(201).body("import success");
    }
}
