package com.akshatsonic.codelyze.dto.codeforces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Problem {
    private Long contestId;
    private String index;
    private String name;
    private String type;
    private Double points;
    private Integer rating;
    private List<String> tags;
}
