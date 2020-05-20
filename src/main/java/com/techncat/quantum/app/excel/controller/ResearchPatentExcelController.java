package com.techncat.quantum.app.excel.controller;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.excel.model.research.PatentRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.excel.service.ResearchExcelService;
import com.techncat.quantum.app.model.research.Patent;
import com.techncat.quantum.app.service.research.ResearchSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/excel/research/patent")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class ResearchPatentExcelController {
    @Autowired
    private ResearchSearchService researchSearchService;
    @Autowired
    private ResearchExcelService researchExcelService;

    @Autowired
    private ExcelService excelService;

    /**
     * 导出
     *
     * @param word
     * @param order
     * @param byProp
     * @param response
     * @throws IOException
     */
    @GetMapping("/{anyname}.xlsx") // 导出后下载保存名字为：anyname.xls
    public void excelExport(@ForkiAser Aser aser,
                            @RequestParam(value = "word", required = false) String word,
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
        Page<Patent> page = null;
        page = researchSearchService.searchPatent(aser, word, request);
        excelService.export(page.getContent().parallelStream().map(PatentRow::render).collect(Collectors.toList()), response.getOutputStream());
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
    public ResponseEntity excelImport(@RequestParam(required = false, defaultValue = "false") Boolean force,
                                      MultipartFile file) throws IOException {
        List<Patent> data = excelService.read(file, PatentRow.class).parallelStream().map(PatentRow::load).filter(Objects::nonNull).collect(Collectors.toList());
        long passCount = data.parallelStream().map(purchasing -> researchExcelService.create_or_update(purchasing, force)).count();

        String message = "导入成功" + passCount + "条，失败" + (data.size() - passCount) + "条";
        return ResponseEntity.status(201).body(message);
    }
}
