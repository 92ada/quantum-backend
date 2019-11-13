package com.techncat.quantum.app.controller.auth;

import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.service.people.PeopleShowService;
import com.techncat.quantum.app.service.user.UserRoleService;
import com.techncat.quantum.app.service.user.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UserService userService;
    @Autowired
    private PeopleShowService peopleShowService;

    /**
     * 获取该用户角色（全部角色列表展示模式）
     *
     * @param id
     * @return
     */
    @GetMapping("/{people_id}")
    public ResponseEntity listRoles(@PathVariable("people_id") Long id) {
        return ResponseEntity.ok(userRoleService.fetchRoleStatus(id));
    }

    /**
     * 重置所有权限角色名字
     *
     * @param id
     * @param payload
     * @return
     */
    @PostMapping("/{people_id}")
    public ResponseEntity resetAll(@PathVariable("people_id") Long id, @RequestBody Payload payload) {
        People people = peopleShowService.fetchBase(id);
        userService.resetRoles(people.getSid(), payload.getRoles());
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return ResponseEntity.ok(map);
    }

    @Data
    static class Payload {
        private List<String> roles;
    }
}
