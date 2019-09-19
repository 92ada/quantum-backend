package com.techncat.quantum.app.controller.people;

import com.techncat.quantum.app.common.VOEnhanceUtil;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.vos.people.PeopleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    @Autowired
    private PeopleShowService showService;
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/{people_id}")
    public ResponseEntity<PeopleVO> show(@PathVariable("people_id") Long id) throws PeopleShowService.PeopleNotFoundException {
        return ResponseEntity.ok(showService.show(id));
    }

    @GetMapping("/{people_id}/update")
    public ResponseEntity<Map> updateInfo(@PathVariable("people_id") Long id) throws PeopleShowService.PeopleNotFoundException, IllegalAccessException {
        List result = voEnhanceUtil.enhance(showService.show(id));
        Map map = new HashMap();
        map.put("people", result);
        return ResponseEntity.ok(map);
    }
}
