package com.akshatsonic.codelyze.service;

import com.akshatsonic.codelyze.client.CodeforcesClient;
import com.akshatsonic.codelyze.client.PinotClient;
import com.akshatsonic.codelyze.dto.codeforces.GenericCodeforcesResponse;
import com.akshatsonic.codelyze.dto.codeforces.PinotCodeforcesSubmission;
import com.akshatsonic.codelyze.dto.codeforces.Submission;
import com.akshatsonic.codelyze.enums.CodeforcesResponseStatus;
import com.akshatsonic.codelyze.enums.SubmissionVerdict;
import com.akshatsonic.codelyze.exceptions.ClientErrorException;
import com.akshatsonic.codelyze.kafka.CodeforcesKafkaProducer;
import com.akshatsonic.codelyze.mapper.codeforces.SubmissionMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.pinot.client.ResultSet;
import org.apache.pinot.client.ResultSetGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionsService {
    private final CodeforcesClient codeforcesClient;
    private final CodeforcesKafkaProducer codeforcesKafkaProducer;
    private final SubmissionMapper submissionMapper;
    private final ObjectMapper objectMapper;
    private final PinotClient pinotClient;

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

    public List<PinotCodeforcesSubmission> querySubmissions(String query) throws JsonProcessingException {
        ResultSetGroup resultSetGroup =  pinotClient.executeQuery(query);
        List<PinotCodeforcesSubmission> pinotCodeforcesSubmissions = new ArrayList<>();
        for(int i = 0; i < resultSetGroup.getResultSet(0).getRowCount(); i++) {
            ResultSet resultSet = resultSetGroup.getResultSet(0);
            PinotCodeforcesSubmission pinotCodeforcesSubmission = PinotCodeforcesSubmission.builder()
                    .creationTimeSeconds(resultSet.getLong(i,0))
                    .contestId(resultSet.getString(i,1))
                    .handle(resultSet.getString(i,2))
                    .id(resultSet.getLong(i,3))
                    .points(resultSet.getFloat(i,4))
                    .problemRating(resultSet.getLong(i,5))
                    .problemTags(objectMapper.readValue(resultSet.getString(i, 6), new TypeReference<List<String>>() {}))
                    .problemType(resultSet.getString(i,7))
                    .programmingLanguage(resultSet.getString(i,8))
                    .verdict(SubmissionVerdict.valueOf(resultSet.getString(i,9)))
                            .build();
            pinotCodeforcesSubmissions.add(pinotCodeforcesSubmission);
        }
        return pinotCodeforcesSubmissions;
    }
}
