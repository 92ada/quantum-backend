package com.techncat.quantum.app.excel.controller;


import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.excel.model.equipment.StockRow;
import com.techncat.quantum.app.excel.service.ExcelService;
import com.techncat.quantum.app.model.equipment.Stock;
import com.techncat.quantum.app.repository.equipment.EquStockRepository;
import com.techncat.quantum.app.service.equipment.EquipmentStockService;
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
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/excel/equipment/stock")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class EquipmentStockExcelController {
    @Autowired
    private EquipmentStockService equipmentStockService;
    @Resource
    private EquStockRepository equStockRepository;
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
        List<StockRow> stockRows = new ArrayList<>();
        StockRow row = new StockRow();
        stockRows.add(row);
        excelService.export(stockRows, response.getOutputStream());
    }

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
        Page<Stock> stockPage = null;
        stockPage = equipmentStockService.page(aser, word, request);
        excelService.export(stockPage.getContent().parallelStream().map(StockRow::render).collect(Collectors.toList()), response.getOutputStream());
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
        List<Stock> data = excelService.read(file, StockRow.class).parallelStream().map(StockRow::load).filter(Objects::nonNull).collect(Collectors.toList());
        // insert
        equStockRepository.saveAll(data);
        return ResponseEntity.status(201).body("import success");
    }
}
