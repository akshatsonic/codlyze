package com.akshatsonic.codelyze.service;

import com.akshatsonic.codelyze.client.CodeforcesClient;
import com.akshatsonic.codelyze.dto.codeforces.GenericCodeforcesResponse;
import com.akshatsonic.codelyze.dto.codeforces.PinotCodeforcesSubmission;
import com.akshatsonic.codelyze.dto.codeforces.Submission;
import com.akshatsonic.codelyze.enums.CodeforcesResponseStatus;
import com.akshatsonic.codelyze.exceptions.ClientErrorException;
import com.akshatsonic.codelyze.kafka.CodeforcesKafkaProducer;
import com.akshatsonic.codelyze.mapper.codeforces.SubmissionMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionsService {
    private final CodeforcesClient codeforcesClient;
    private final CodeforcesKafkaProducer codeforcesKafkaProducer;
    private final SubmissionMapper submissionMapper;
    private final ObjectMapper objectMapper;

    public void syncSubmissions(String handle) throws JsonProcessingException {
        GenericCodeforcesResponse<List<Submission>> codeforcesResponse = codeforcesClient.getSubmissions(handle);
        if(CodeforcesResponseStatus.OK.equals(codeforcesResponse.getStatus())){
            for (Submission submission : codeforcesResponse.getResult()) {
                PinotCodeforcesSubmission pinotCodeforcesSubmission = submissionMapper.toPinotCodeforcesSubmission(submission, handle);
                codeforcesKafkaProducer.sendMessage(objectMapper.writeValueAsString(pinotCodeforcesSubmission));
            }
        } else {
            throw new ClientErrorException(codeforcesResponse.getComment());
        }
    }
}
