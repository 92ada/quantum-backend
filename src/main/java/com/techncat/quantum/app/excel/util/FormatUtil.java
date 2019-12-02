package com.techncat.quantum.app.excel.util;

import com.techncat.quantum.app.model.people.People;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static Date formatDate(String date) {
        if (date == null) return null;
        try {
            if (date.trim().length() >= 16) return dateTimeFormat.parse(date);
            else return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(BigDecimal number) {
        if (number == null) return null;
        return number.toPlainString();
    }

    public static String format(Integer number) {
        if (number == null) return null;
        return number.toString();
    }

    public static String format(Boolean bool) {
        if (bool == null) return null;
        return bool ? "true" : "false";
    }

    public static BigDecimal toBigDecimal(String data) {
        if (data == null) return null;
        return new BigDecimal(data);
    }

    public static Integer toInteger(String data) {
        if (data == null) return null;
        return new Integer(data);
    }

    public static Boolean toBoolean(String data) {
        if (data == null) return null;
        return new Boolean(data);
    }

    public static String formatDate(Date date) {
        if (date == null) return null;
        return dateFormat.format(date);
    }

    public static String formatDateTime(Date date) {
        if (date == null) return null;
        return dateTimeFormat.format(date);
    }

    public static <T extends Enum<T>> T formatEnum(Class<T> clazz, String value) {
        if (value == null) return null;
        if (value.trim().length() == 0) return null;
        return Enum.valueOf(clazz, value);
    }
}
