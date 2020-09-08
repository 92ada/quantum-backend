package com.techncat.quantum.app.controller.log;

import com.techncat.quantum.app.model.log.LogRecord;
import com.techncat.quantum.app.service.log.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/log")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class LogExportController {
    @Autowired
    private LogHelper logHelper;

    @GetMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = request.getQueryString();
        System.out.println("Dadada..." + query);
        Long timestamp = Long.parseLong(getValue(query, "timestamp", null));
        Integer size = Integer.parseInt(getValue(query, "size", "1000"));
        Page<LogRecord> page = logHelper.read(timestamp, size);
        List<LogRecord> list = page.getContent();
        String logs = list.parallelStream().map(this::form).collect(Collectors.joining());

        String info = "Timestamp: " + timestamp + ", \t Size: " + page.getSize() + "\n" + "Current Date: " + new Date() + "\n\n";
        String header = "DATETIME\tLEVEL\tSID\tMETHOD\tURL\tPARAMETERS\n";
        response.setContentType("text/plain");
        response.getWriter().write(info + header + logs);
    }

    private String form(LogRecord record) {
        Date time = new Date(record.getTimestamp());
        StringBuilder builder = new StringBuilder();
        builder.append(time).append("\t")
                .append(record.getLevel()).append("\t")
                .append(record.getSid() == null || record.getSid().equals("null") ? "<unknown>" : record.getSid()).append("\t")
                .append(record.getRequestMethod()).append("\t")
                .append(record.getRequestUrl()).append("\t")
                .append(record.getParameters()).append("\n");
//                .append(record.getRemark()).append("\n");
        return builder.toString();
    }

    private String getValue(String query, String key, String defaultValue) {
        if (query == null) return null;
        String[] params = query.split("&");
        for (String kv : params) {
            String[] kv_str = kv.split("=");
            if (key.equals(kv_str[0])) {
                return kv_str[1];
            }
        }
        return defaultValue;
    }
}
