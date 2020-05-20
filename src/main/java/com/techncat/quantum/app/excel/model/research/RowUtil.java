package com.techncat.quantum.app.excel.model.research;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.service.utils.JsonLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RowUtil {
     private static List<People> loadPeopleList(Object applicantJson) {
        List<People> list = new ArrayList<>();
        if (applicantJson == null) return list;

        try {
            JSONArray jsonArray = (JSONArray) applicantJson;
            for (Object item : jsonArray) {
                String str = (String) item;
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(str);
                while(m.find()) {
                    Long id = Long.parseLong(m.group(1));
                    People p = new People();
                    p.setId(id);
                    list.add(p);
                }
            }
        } catch (Exception e) {
            throw new JsonLoader.JSONParseError("Load JSON failed");
        }
        return list;
    }

    private static People loadPeople(Object applicantJson) {
        if (applicantJson == null) return null;
        List<People> list = loadPeopleList(applicantJson);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    static Object loadJson(String str) {
        String[] names = str.split(",");
        return JSONArray.parseArray(JSON.toJSONString(names));
    }

    static List<People> parsePeopleList(String source) {
        return loadPeopleList(loadJson(source));
    }

    static People parsePeople(String source) {
        return loadPeople(loadJson(source));
    }
}
