package com.techncat.quantum.app.excel.controller;


import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.excel.model.finance.ExpRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.model.finance.*;
import com.techncat.quantum.app.repository.finance.*;
import com.techncat.quantum.app.service.finance.FinanceExp_SearchService;
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
@RequestMapping("/api/excel/finance/exps")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class FinanceExcelController {
    @Autowired
    private FinanceExp_SearchService financeExp_searchService;
    @Resource
    private FinExp_Repository finExp_repository;
    @Resource
    private FinExpConferenceRepository conferenceRepository;
    @Resource
    private FinExpConsultationRepository consultationRepository;
    @Resource
    private FinExpEquipmentRepository equipmentRepository;
    @Resource
    private FinExpIndirectiveRepository indirectiveRepository;
    @Resource
    private FinExpInternationalRepository internationalRepository;
    @Resource
    private FinExpLaborRepository laborRepository;
    @Resource
    private FinExpMaterialRepository materialRepository;
    @Resource
    private FinExpOtherRepository otherRepository;
    @Resource
    private FinExpProcessingRepository processingRepository;
    @Resource
    private FinExpPublicationRepository publicationRepository;
    @Resource
    private FinExpTravelRepository travelRepository;

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
        List<ExpRow> expRows = new ArrayList<>();
        ExpRow row = new ExpRow();
        expRows.add(row);
        excelService.export(expRows, response.getOutputStream());
    }


    @GetMapping("/{anyname}.xlsx") // 导出后下载保存名字为：anyname.xls
    public void excelExport(@ForkiAser Aser aser,
                            @RequestParam(value = "start", required = false) String start, // 2018-01-01
                            @RequestParam(value = "end", required = false) String end,
                            @RequestParam(value = "type", required = false) Exp.Type type,
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
        Page<Exp> expPage = null;
        if (type == null) {
            expPage = financeExp_searchService.search(aser.getSid(), startDate, endDate, request);
        } else {
            expPage = financeExp_searchService.search(aser.getSid(), startDate, endDate, type, request);
        }
        excelService.export(expPage.getContent().parallelStream().map(ExpRow::render).collect(Collectors.toList()), response.getOutputStream());
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
        List<Exp> data = excelService.read(file, ExpRow.class).parallelStream().map(ExpRow::load).filter(Objects::nonNull).collect(Collectors.toList());
        data.parallelStream().forEach(exp -> {
            if (null != exp.getType())
                switch (exp.getType()) {
                    case conference:
                        ExpConference expConference = conferenceRepository.save(new ExpConference());
                        exp.setExpConference(expConference);
                        exp = finExp_repository.save(exp);
                        expConference.setExp(exp);
                        conferenceRepository.save(expConference);
                        return;
                    case consultation:
                        ExpConsultation expConsultation = consultationRepository.save(new ExpConsultation());
                        exp.setExpConsultation(expConsultation);
                        exp = finExp_repository.save(exp);
                        expConsultation.setExp(exp);
                        consultationRepository.save(expConsultation);
                        return;
                    case equipment:
                        ExpEquipment expEquipment = equipmentRepository.save(new ExpEquipment());
                        exp.setExpEquipment(expEquipment);
                        exp = finExp_repository.save(exp);
                        expEquipment.setExp(exp);
                        equipmentRepository.save(expEquipment);
                        return;
                    case indirective:
                        ExpIndirective expIndirective = indirectiveRepository.save(new ExpIndirective());
                        exp.setExpIndirective(expIndirective);
                        exp = finExp_repository.save(exp);
                        expIndirective.setExp(exp);
                        indirectiveRepository.save(expIndirective);
                        return;
                    case international:
                        ExpInternational expInternational = internationalRepository.save(new ExpInternational());
                        exp.setExpInternational(expInternational);
                        exp = finExp_repository.save(exp);
                        expInternational.setExp(exp);
                        internationalRepository.save(expInternational);
                        return;
                    case labor:
                        ExpLabor expLabor = laborRepository.save(new ExpLabor());
                        exp.setExpLabor(expLabor);
                        exp = finExp_repository.save(exp);
                        expLabor.setExp(exp);
                        laborRepository.save(expLabor);
                        return;
                    case material:
                        ExpMaterial expMaterial = materialRepository.save(new ExpMaterial());
                        exp.setExpMaterial(expMaterial);
                        exp = finExp_repository.save(exp);
                        expMaterial.setExp(exp);
                        materialRepository.save(expMaterial);
                        return;
                    case other:
                        ExpOther expOther = otherRepository.save(new ExpOther());
                        exp.setExpOther(expOther);
                        exp = finExp_repository.save(exp);
                        expOther.setExp(exp);
                        otherRepository.save(expOther);
                        return;
                    case travel:
                        ExpTravel expTravel = travelRepository.save(new ExpTravel());
                        exp.setExpTravel(expTravel);
                        exp = finExp_repository.save(exp);
                        expTravel.setExp(exp);
                        travelRepository.save(expTravel);
                        return;
                    case processing:
                        ExpProcessing expProcessing = processingRepository.save(new ExpProcessing());
                        exp.setExpProcessing(expProcessing);
                        exp = finExp_repository.save(exp);
                        expProcessing.setExp(exp);
                        processingRepository.save(expProcessing);
                        return;
                    case publication:
                        ExpPublication expPublication = publicationRepository.save(new ExpPublication());
                        exp.setExpPublication(expPublication);
                        exp = finExp_repository.save(exp);
                        expPublication.setExp(exp);
                        publicationRepository.save(expPublication);
                        return;
                }
        });
        return ResponseEntity.status(201).body("import success");
    }
}
