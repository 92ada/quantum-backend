package com.techncat.quantum.app.controller;

import com.techncat.quantum.app.service.UserService;
import com.techncat.quantum.app.vos.PeopleHomePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<PeopleHomePageVO> show(@PathVariable("user_id") Long id) throws UserService.PeopleNotFoundException {
        PeopleHomePageVO vo = userService.fetch(id);
        return ResponseEntity.ok(vo);
    }

    @PostMapping
    public ResponseEntity<PeopleHomePageVO> create(@RequestBody PeopleHomePageVO data) {
        PeopleHomePageVO vo = userService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(vo);
    }

//    @PatchMapping("/{user_id}")
    @PutMapping("/{user_id}")
    public ResponseEntity<PeopleHomePageVO> update(@PathVariable("user_id") Long id, @RequestBody PeopleHomePageVO data) throws UserService.PeopleNotFoundException {
        return ResponseEntity.ok(userService.update(id, data));
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<?> delete(@PathVariable("user_id") Long id) throws UserService.PeopleNotFoundException {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
