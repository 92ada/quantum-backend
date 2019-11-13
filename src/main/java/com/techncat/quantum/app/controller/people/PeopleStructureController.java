package com.techncat.quantum.app.controller.people;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.vos.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/people")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class PeopleStructureController {
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/base/structure")
    public ResponseEntity<Map> baseStructureInfo() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PeopleVO());
        result.put("index", "people.basic_info");
        result.put("key", "base");
        result.put("priority", "1");
        result.put("post_url", "/api/people/base");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/administration/structure")
    public ResponseEntity<Map> structureInfo1() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PeopleVO());
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/people/administration");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/postdoctoral/structure")
    public ResponseEntity<Map> structureInfo2() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PeoplePostdoctoralVO());
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/people/postdoctoral");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/researcher/structure")
    public ResponseEntity<Map> structureInfo3() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PeopleResearcherVO());
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/people/researcher");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/student/structure")
    public ResponseEntity<Map> structureInfo4() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PeopleStudentVO());
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/people/student");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/teacher/structure")
    public ResponseEntity<Map> structureInfo5() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PeopleTeacherVO());
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/people/teacher");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/visitor/structure")
    public ResponseEntity<Map> structureInfo6() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new PeopleVisitorVO());
        result.put("index", "people.other_info");
        result.put("key", "extra");
        result.put("priority", "2");
        result.put("post_url", "/api/people/visitor");
        return ResponseEntity.ok(result);
    }
}
