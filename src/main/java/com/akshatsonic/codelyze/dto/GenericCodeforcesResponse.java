package com.akshatsonic.codelyze.dto;

import com.akshatsonic.codelyze.enums.CodeforcesResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericCodeforcesResponse<T> {
    private CodeforcesResponseStatus status;
    private String comment;
    private T result;
}
