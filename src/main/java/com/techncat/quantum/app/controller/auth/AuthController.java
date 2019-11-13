package com.techncat.quantum.app.controller.auth;

import com.techncat.quantum.app.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auths/people")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class AuthController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/{people_id}")
    public ResponseEntity listRoles(@PathVariable("people_id") Long id) {
        return ResponseEntity.ok(userRoleService.fetchRoleStatus(id));
    }
}
