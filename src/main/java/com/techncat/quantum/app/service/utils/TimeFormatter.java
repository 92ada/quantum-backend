package com.techncat.quantum.app.service.utils;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeFormatter {
    /**
     * @param date 2018-01-01
     * @return Date()
     */
    public Date formatDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (date == null) return null;
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public Date formatDate(String date, Date defaultDate) {
        if (date == null) return defaultDate;
        return formatDate(date);
    }
    public Date formatDate(String date, String defaultDate) {
        if (date == null) return formatDate(defaultDate);
        return formatDate(date);
    }
}
