package com.techncat.quantum.app.service.log;

import com.techncat.quantum.app.model.log.LogRecord;
import com.techncat.quantum.app.repository.log.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LogHelper {
    @Autowired
    private LogRepository repository;

    public void error(String sid, String requestMethod, String requestUrl, String parameters) {
        write("error", sid, requestMethod, requestUrl, parameters, null);
    }

    public void info(String sid, String requestMethod, String requestUrl, String parameters) {
        write("info", sid, requestMethod, requestUrl, parameters, null);
    }

    public Page<LogRecord> read(long timestamp, int size) {
        return repository.findAllByTimestampLessThanOrderByTimestampAsc(timestamp, PageRequest.of(0, size));
    }

    public void write(String level, String sid, String requestMethod, String requestUrl, String parameters, String remark) {
        LogRecord record = new LogRecord();
        record.setLevel(level);
        record.setSid(sid);
        record.setRequestMethod(requestMethod);
        record.setRequestUrl(requestUrl);
        record.setParameters(parameters);
        record.setRemark(remark);
        record.setTimestamp(System.currentTimeMillis());
        repository.save(record);
    }
}
