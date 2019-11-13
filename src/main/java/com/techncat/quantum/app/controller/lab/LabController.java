package com.techncat.quantum.app.controller.lab;

import com.techncat.quantum.app.common.voenhance.VOEnhanceUtil;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.Lab;
import com.techncat.quantum.app.service.people.lab.LabService;
import com.techncat.quantum.app.vos.people.LabVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/labs")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class LabController {
    @Autowired
    private LabService labService;
    @Autowired
    private VOUtils voUtils;
    @Autowired
    private VOEnhanceUtil voEnhanceUtil;

    @GetMapping("/structure")
    public ResponseEntity<Map> structureInfo() throws IllegalAccessException {
        Map result = voEnhanceUtil.enhance("data", new LabVO());
        result.put("index", "lab");
        result.put("post_url", "/api/labs");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(labService.fetch(id));
    }

    @GetMapping("/{id}/structure")
    public ResponseEntity structure(@PathVariable("id") Long id) throws IllegalAccessException {
        Lab record = labService.fetch(id);
        LabVO data = voUtils.copy(record, LabVO.class);
        Map result = voEnhanceUtil.enhance("data", data);
        result.put("index", "lab");
        result.put("post_url", "/api/labs");
        result.put("update_url", "/api/labs/" + id);
        result.put("delete_url", "/api/labs/" + id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody LabVO payload) {
        return ResponseEntity.status(201).body(labService.create(payload));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody LabVO payload) {
        return ResponseEntity.status(200).body(labService.update(id, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        labService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
