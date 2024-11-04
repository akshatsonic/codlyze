package com.akshatsonic.codelyze.controller;

import com.akshatsonic.codelyze.dto.codeforces.Submission;
import com.akshatsonic.codelyze.service.SubmissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity syncSubmissions(@RequestParam("handle") String handle) {
        try{
             submissionsService.syncSubmissions(handle);
                return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(
                    "An error occurred while syncing submissions for handle: " + handle + " , message: " + e.getMessage()
            );
        }
    }
}
