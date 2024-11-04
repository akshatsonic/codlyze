package com.akshatsonic.codelyze.controller;

import com.akshatsonic.codelyze.dto.Submission;
import com.akshatsonic.codelyze.service.SubmissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/submissions")
@RestController
@RequiredArgsConstructor
public class SubmissionsController {
    private final SubmissionsService submissionsService;

    @PostMapping("/sync")
    public List<Submission> syncSubmissions(@RequestParam("handle") String handle) {
        return submissionsService.syncSubmissions(handle);
    }
}
