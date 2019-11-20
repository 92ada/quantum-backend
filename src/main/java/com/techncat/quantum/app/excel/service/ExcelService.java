package com.techncat.quantum.app.excel.service;

import com.github.houbb.iexcel.bs.ExcelBs;
import com.github.houbb.iexcel.core.reader.IExcelReader;
import com.github.houbb.iexcel.core.writer.IExcelWriter;
import com.github.houbb.iexcel.util.excel.ExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExcelService {
    @Value("${file.location}")
    private String location;

    public void export(List<?> dataSource, OutputStream whereToWrite) {
        IExcelWriter writer = ExcelUtil.get07ExcelWriter();
        writer.write(dataSource);
        writer.flush(whereToWrite);
    }

    public void export(List<?> dataSource, String filename) {
        String filePath = location + "/" + filename + ".xlsx";
        ExcelBs.newInstance(filePath).write(dataSource);
    }

    public <T> List<T> read(MultipartFile xlsFile, Class<T> clazz) throws IOException {
        File tempFile = new File(location + "/IMPORT_EXCEL_" + System.currentTimeMillis() + ".xlsx");
        xlsFile.transferTo(tempFile);
        IExcelReader<T> reader = ExcelUtil.getExcelReader(tempFile);
        return reader.readAll(clazz);
    }
}
