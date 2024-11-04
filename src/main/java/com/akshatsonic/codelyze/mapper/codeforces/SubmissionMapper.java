package com.akshatsonic.codelyze.mapper.codeforces;

import com.akshatsonic.codelyze.dto.codeforces.PinotCodeforcesSubmission;
import com.akshatsonic.codelyze.dto.codeforces.Submission;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    @Mapping(source = "problem.tags", target = "problemTags")
    @Mapping(source = "problem.type", target = "problemType")
    @Mapping(source = "problem.rating", target = "problemRating")
    @Mapping(expression = "java(handleArg)", target = "handle")
    @Mapping(source="problem.points", target="points")
    PinotCodeforcesSubmission toPinotCodeforcesSubmission(Submission submission, @Context String handleArg);
}
