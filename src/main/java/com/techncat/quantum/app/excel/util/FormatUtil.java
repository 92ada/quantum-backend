package com.techncat.quantum.app.excel.util;

import com.techncat.quantum.app.model.people.People;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class FormatUtil {
    public static Date formatDate(String date) {
        if (date == null) return null;
        try {
            return DateFormat.getInstance().parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formatDate(Date date) {
        return DateFormat.getInstance().format(date);
    }

    public static <T extends Enum<T>> T formatEnum(Class<T> clazz, String value) {
        if (value == null) return null;
        if (value.trim().length() == 0) return null;
        return Enum.valueOf(clazz, value);
    }
}
