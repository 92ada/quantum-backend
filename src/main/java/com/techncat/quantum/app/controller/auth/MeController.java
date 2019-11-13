package com.techncat.quantum.app.controller.auth;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class MeController {
    @Autowired
    private PeopleShowService peopleShowService;

    @GetMapping("me")
    public ResponseEntity me(@ForkiAser Aser aser) {
        return ResponseEntity.ok(peopleShowService.fetchBySid(aser.getSid()));
    }

    @GetMapping("/roles")
    public ResponseEntity authList(@ForkiAser Aser aser) {
        Map<String, Object> map = new HashMap<>();
        map.put("sid", aser.getSid());
        map.put("roles", aser.getRoles());
        return ResponseEntity.ok(map);
    }
}
