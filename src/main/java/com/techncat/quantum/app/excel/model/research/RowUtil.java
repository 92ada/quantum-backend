package com.techncat.quantum.app.excel.model.research;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.People_Repository;
import com.techncat.quantum.app.service.utils.JsonLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class RowUtil {
    @Deprecated
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

    @Deprecated
    private static People loadPeople(Object applicantJson) {
        if (applicantJson == null) return null;
        List<People> list = loadPeopleList(applicantJson);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    @Deprecated
    static Object loadJson(String str) {
        String[] names = str.split(",");
        return JSONArray.parseArray(JSON.toJSONString(names));
    }

    @Deprecated
    static List<People> parsePeopleList(String source) {
        return loadPeopleList(loadJson(source));
    }

    @Deprecated
    static People parsePeople(String source) {
        return loadPeople(loadJson(source));
    }

    /**
     * Update 2020.5.26
     */

    private static People_Repository peopleRepository;

    @Autowired
    public RowUtil(People_Repository people_repository) {
        RowUtil.peopleRepository = people_repository;
    }

    static List<People> loadPeopleListFromSid(String source) {
        List<String> sids = Arrays.asList(source.split(",")).stream().map(String::trim).collect(Collectors.toList());
        List<People> peopleList = new ArrayList<>();
        sids.forEach(sid -> {
            People people = peopleRepository.findFirstBySid(sid);
            if (people != null) peopleList.add(people);
        });
        return peopleList;
    }

    static People loadPeopleFromSid(String source) {
        List<People> list = loadPeopleListFromSid(source);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    static Object toJson(List<People> peopleList) {
         List<String> names = peopleList.stream()
                 .map(p -> p.getName() + " (" + p.getId().toString() + ")")
                 .collect(Collectors.toList());
         return JSONArray.parseArray(JSON.toJSONString(names));
    }

    static Object toJson(People p) {
        String name = p.getName() + " (" + p.getId().toString() + ")";
        List<String> array = new ArrayList<>();
        array.add(name);
        return JSONArray.parseArray(JSON.toJSONString(array));
    }
}
