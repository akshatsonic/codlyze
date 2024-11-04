package com.akshatsonic.codelyze.client;

import com.akshatsonic.codelyze.dto.codeforces.GenericCodeforcesResponse;
import com.akshatsonic.codelyze.dto.codeforces.Submission;
import com.akshatsonic.codelyze.enums.CodeforcesResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeforcesClient {
    private final GenericRestClient genericRestClient;
    private final ObjectMapper objectMapper;
    @Value("${codeforces.base.url}")
    private String codeforcesBaseUrl;

    public GenericCodeforcesResponse<List<Submission>> getPaginatedSubmissions(String handle, int start, int count) {

        String response = genericRestClient.getResult(
                codeforcesBaseUrl + "/api/user.status?handle=" + handle + "&from=" + start + "&count=" + count,
                new LinkedMultiValueMap<>(),
                String.class
        );
        try {
            return objectMapper.readValue(response, new TypeReference<GenericCodeforcesResponse<List<Submission>>>() {
            });
        } catch (JsonProcessingException e) {
            log.error("Error while parsing response: {}", e.getMessage());
            return null;
        }
    }

    public GenericCodeforcesResponse getSubmissions(String handle) {
        List<Submission> allSubmissions = new ArrayList<>();
        boolean error = false;
        int page = 0;
        while (true) {
            log.info("Fetching submissions for handle: {} page: {}", handle, page);
            page++;
            GenericCodeforcesResponse<List<Submission>> submissions = getPaginatedSubmissions(handle, allSubmissions.size()+1, 100);
            if (submissions.getStatus().equals(CodeforcesResponseStatus.FAILED)) {
                error = true;
                break;
            }
            if (submissions.getResult().isEmpty()) {
                break;
            }
            allSubmissions.addAll(submissions.getResult());
        }
        if (error) {
            return GenericCodeforcesResponse.builder()
                    .status(CodeforcesResponseStatus.FAILED)
                    .comment("Error while fetching submissions")
                    .result(null)
                    .build();
        }
        return GenericCodeforcesResponse.builder()
                .status(CodeforcesResponseStatus.OK)
                .comment("Submissions fetched successfully")
                .result(allSubmissions)
                .build();
    }

}
