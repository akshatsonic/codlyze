package com.akshatsonic.codelyze.client;

import com.akshatsonic.codelyze.dto.GenericCodeforcesResponse;
import com.akshatsonic.codelyze.dto.Submission;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeforcesClient {
    private final GenericRestClient genericRestClient;
    private final ObjectMapper objectMapper;
    @Value("${codeforces.base.url}") private String codeforcesBaseUrl;

    public GenericCodeforcesResponse getSubmissions(String handle, int count) {

        String response = genericRestClient.getResult(
                codeforcesBaseUrl + "/api/user.status?handle=" + handle + "&from=1&count=" + count,
                new LinkedMultiValueMap<>(),
                String.class
        );
        try {
            return objectMapper.readValue(response, new TypeReference<GenericCodeforcesResponse<List<Submission>>>() {});
        }
        catch (JsonProcessingException e) {
            log.error("Error while parsing response: {}", e.getMessage());
            return null;
        }
    }

}
