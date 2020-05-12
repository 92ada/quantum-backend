package com.techncat.quantum.app.service.utils;

import com.alibaba.fastjson.JSONArray;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.repository.people.People_Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JsonLoader {
    @Resource
    private People_Repository peopleRepository;

    public List<People> loadPeopleList(Object applicantJson) {
        List<People> list = new ArrayList<>();
        if (applicantJson == null) return list;

        try {
            JSONArray jsonArray = (JSONArray) applicantJson;
            for (Object item : jsonArray) {
                String str = (String) item;
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(str);
                while(m.find()) {
                    Long id = Long.parseLong(m.group(1));
                    list.add(peopleRepository.findById(id).get());
                }
            }
        } catch (Exception e) {
            throw new JSONParseError("Load JSON failed");
        }
        return list;
    }

    public People loadPeople(Object applicantJson) {
        if (applicantJson == null) return null;
        List<People> list = loadPeopleList(applicantJson);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public static class JSONParseError extends RuntimeException {
        JSONParseError(String message) {
            super(message);
        }
    }
}
