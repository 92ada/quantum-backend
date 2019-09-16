package com.techncat.quantum.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping(value = "/greeting")
    public String greeting() {
        return "hello";
    }
}
