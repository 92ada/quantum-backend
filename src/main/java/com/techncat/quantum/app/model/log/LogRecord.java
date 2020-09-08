package com.techncat.quantum.app.model.log;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "log_records", indexes = {
        @Index(name = "timestamp", columnList = "timestamp")
})
public class LogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String level = "info";
    private String sid;
    private String requestMethod;
    private String requestUrl;
    @Column(columnDefinition = "text")
    private String parameters;
    private String remark;
    private Long timestamp;
}
