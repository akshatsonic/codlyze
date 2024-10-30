package com.akshatsonic.codelyze.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodeforcesClient {
    private final GenericRestClient restClient;

}
