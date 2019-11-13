package com.techncat.quantum.app.controller.auth;

import com.techncat.quantum.app.auth.cas.CasService;
import com.techncat.quantum.app.auth.service.JwtService;
import com.techncat.quantum.app.model.user.User;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.service.user.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/login")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class CasLoginController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;
    @Autowired
    private PeopleShowService peopleShowService;
    @Autowired
    private CasService casService;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginPayload payload) {
        if (casService.login(payload.getSid(), payload.getPassword())) {
//            peopleShowService.fetchBySid(payload.getSid()); // if not exist, throw notfound exception
            User user = userService.fetch(payload.getSid());
            return ResponseEntity.ok(jwtService.encode(user.getSid(), user.getRoles()));
        } else {
            Map<String, String> map = new HashMap<String, String>();
            map.put("message", "Password Wrong");
            return ResponseEntity.badRequest().body(map);
        }
    }

    @Data
    private static class LoginPayload {
        private String sid;
        private String password;
    }
}
