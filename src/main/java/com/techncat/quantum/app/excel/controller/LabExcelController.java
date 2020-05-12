package com.techncat.quantum.app.excel.controller;


import com.techncat.quantum.app.excel.model.people.LabRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.repository.people.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/excel/lab")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class LabExcelController {
    @Autowired
    private LabRepository labRepository;
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
        List<LabRow> rows = new ArrayList<>();
        LabRow row = new LabRow();
        rows.add(row);
        excelService.export(rows, response.getOutputStream());
    }

    @GetMapping("/{anyname}.xlsx") // 导出后下载保存名字为：anyname.xls
    public void excelExport(HttpServletResponse response) throws IOException {
        List<Lab> labs = labRepository.findAll();
        excelService.export(labs.parallelStream().map(LabRow::render).collect(Collectors.toList()), response.getOutputStream());
    }
}
