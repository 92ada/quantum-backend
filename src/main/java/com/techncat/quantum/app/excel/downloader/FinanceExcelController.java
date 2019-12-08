package com.techncat.quantum.app.excel.downloader;


import com.techncat.quantum.app.excel.model.finance.ExpRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.repository.finance.FinExp_Repository;
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
    public void excelExport(@RequestParam(value = "start", required = false) String start, // 2018-01-01
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
            expPage = financeExp_searchService.search(startDate, endDate, request);
        } else {
            expPage = financeExp_searchService.search(startDate, endDate, type, request);
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
    public ResponseEntity excelImport(MultipartFile file) throws IOException {
        List<Exp> data = excelService.read(file, ExpRow.class).parallelStream().map(ExpRow::load).filter(Objects::nonNull).collect(Collectors.toList());
        // insert
        finExp_repository.saveAll(data);
        return ResponseEntity.status(201).body("import success");
    }
}