package com.akshatsonic.codelyze.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/submissions")
public class SubmissionsController {

    @PostMapping("/sync")
    public void syncSubmissions() {
        System.out.println("hello world");
    }
}
