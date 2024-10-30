package com.akshatsonic.codelyze.client;

import com.akshatsonic.codelyze.exceptions.ClientErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Log4j2
public class GenericRestClient {
    public static RestClient restClient = RestClient.create();
    private final ObjectMapper objectMapper;

    public <T> T getResult(
            String url,
            MultiValueMap<String, String> httpHeaders,
            Class<T> tClass
    ) {
        try {

            try {
                RestClient.ResponseSpec responseSpec = restClient.get()
                        .uri(url)
                        .headers(headers -> {
                            headers.addAll(httpHeaders);
                        })
                        .retrieve();

                return responseSpec.body(tClass);
            } catch (HttpClientErrorException e) {
                if(tClass == String.class) {
                    return (T) e.getResponseBodyAsString();
                }
                return objectMapper.readValue(e.getResponseBodyAsString(), tClass);
            }
        } catch (JsonProcessingException e) {
            log.error("Error while parsing response: {}", e.getMessage());
            return null;
        }
    }
}
