package com.techncat.quantum.app.controller;

import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PeopleShowService.PeopleNotFoundException.class)
    public ResponseEntity<Object> exception(PeopleShowService.PeopleNotFoundException exception) {
        return toJsonResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(value = java.lang.IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentException(java.lang.IllegalArgumentException exception) {
        return toJsonResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(value = VOUtils.BeanCopyException.class)
    public ResponseEntity<Object> beanCopyException(VOUtils.BeanCopyException exception) {
        return toJsonResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    private ResponseEntity toJsonResponse(HttpStatus status, String message) {
        Map map = new HashMap();
        map.put("status", status.value());
        map.put("message", message);
        return ResponseEntity.status(status).body(map);
    }
}
