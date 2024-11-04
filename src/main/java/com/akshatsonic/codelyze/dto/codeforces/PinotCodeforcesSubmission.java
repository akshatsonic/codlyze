package com.akshatsonic.codelyze.dto.codeforces;

import com.akshatsonic.codelyze.enums.SubmissionVerdict;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PinotCodeforcesSubmission {
    private Long id;
    private String contestId;
    private String problemType;
    private Long problemRating;
    private List<String> problemTags;
    private String handle;
    private String programmingLanguage;
    private SubmissionVerdict verdict;
    private Float points;
    private Long creationTimeSeconds;
}

/*
  {
    "schemaName": "submissions",
    "enableColumnBasedNullHandling": true,
    "dimensionFieldSpecs": [
      {
        "name": "id",
        "dataType": "LONG",
        "notNull": true
      },
      {
        "name": "contestId",
        "dataType": "STRING",
        "defaultNullValue": "null"
      },
      {
        "name": "problemType",
        "dataType": "STRING",
        "defaultNullValue": "null"
      },
      {
        "name": "problemRating",
        "dataType": "LONG"
      },
      {
        "name": "problemTags",
        "dataType": "STRING",
        "singleValueField": false,
        "defaultNullValue": "null"
      },
      {
        "name": "handle",
        "dataType": "STRING",
        "notNull": true
      },
      {
        "name": "programmingLanguage",
        "dataType": "STRING"
      },
      {
          "name": "verdict",
          "dataType": "STRING"
      }
    ],
    "metricFieldSpecs": [
      {
        "name": "points",
        "dataType": "FLOAT",
        "notNull": true
      }
    ],
    "primaryKeyColumns": ["id"],
    "dateTimeFieldSpecs": [
      {
        "name": "creationTimeSeconds",
        "dataType": "LONG",
        "format": "1:SECONDS:EPOCH",
        "granularity": "1:SECONDS"
      }
    ]
  }
 */