package com.techncat.quantum.app.controller;

import com.github.houbb.iexcel.exception.ExcelRuntimeException;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.service.people.PeopleShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PeopleShowService.PeopleNotFoundException.class)
    public ResponseEntity<Object> exception(PeopleShowService.PeopleNotFoundException exception) {
        return toJsonResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

//    @ExceptionHandler(value = java.lang.IllegalArgumentException.class)
//    public ResponseEntity<Object> illegalArgumentException(java.lang.IllegalArgumentException exception) {
//        return toJsonResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
//    }

    @ExceptionHandler(value = VOUtils.BeanCopyException.class)
    public ResponseEntity<Object> beanCopyException(VOUtils.BeanCopyException exception) {
        return toJsonResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public ResponseEntity<Object> IllegalArgumentException(IllegalArgumentException exception) {
//        return toJsonResponse(HttpStatus.BAD_REQUEST, "参数类型错误，请确认格式");
//    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
        return toJsonResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<Object> SQLException(SQLException exception) {
        return toJsonResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(value = ExcelRuntimeException.class)
    public ResponseEntity<Object> ExcelRuntimeException(ExcelRuntimeException exception) {
        return toJsonResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> Exception(Exception exception) {
        String message = exception.getMessage();
        if (message.contains("constraint [people_index_sid]")) {
            return toJsonResponse(HttpStatus.BAD_REQUEST, "人员SID不能重复");
        }
        return toJsonResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }


    private ResponseEntity<Object> toJsonResponse(HttpStatus status, String message) {
        Map map = new HashMap();
        map.put("status", status.value());
        map.put("message", message);
        return ResponseEntity.status(status).body(map);
    }
}
