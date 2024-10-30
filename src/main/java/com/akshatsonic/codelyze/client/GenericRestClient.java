package com.akshatsonic.codelyze.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class GenericRestClient {
    public static RestClient restClient = RestClient.create();
}
