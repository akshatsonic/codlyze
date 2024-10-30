package com.akshatsonic.codelyze.service;

import com.akshatsonic.codelyze.client.CodeforcesClient;
import com.akshatsonic.codelyze.client.GenericRestClient;
import com.akshatsonic.codelyze.dto.GenericCodeforcesResponse;
import com.akshatsonic.codelyze.dto.Submission;
import com.akshatsonic.codelyze.enums.CodeforcesResponseStatus;
import com.akshatsonic.codelyze.exceptions.ClientErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionsService {
    private final CodeforcesClient codeforcesClient;

    public List<Submission> syncSubmissions(String handle, int page) {
        GenericCodeforcesResponse<List<Submission>> codeforcesResponse =  codeforcesClient.getSubmissions(handle, page);
        if(CodeforcesResponseStatus.OK.equals(codeforcesResponse.getStatus())){
            return codeforcesResponse.getResult();
        } else {
            throw new ClientErrorException(codeforcesResponse.getComment());
        }
    }
}
