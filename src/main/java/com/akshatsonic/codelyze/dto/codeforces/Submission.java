package com.akshatsonic.codelyze.dto.codeforces;

import com.akshatsonic.codelyze.enums.SubmissionVerdict;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Submission {
    private Long id;
    private Long contestId;
    private Long creationTimeSeconds;
    private Problem problem;
    private Author author;
    private String programmingLanguage;
    private SubmissionVerdict verdict;
}
