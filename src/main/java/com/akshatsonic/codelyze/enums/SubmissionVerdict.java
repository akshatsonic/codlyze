package com.akshatsonic.codelyze.enums;

public enum SubmissionVerdict {
    OK,
    COMPILATION_ERROR,
    WRONG_ANSWER,
    RUNTIME_ERROR,
    TIME_LIMIT_EXCEEDED,
    MEMORY_LIMIT_EXCEEDED
}


/*
{
  "status": "OK",
  "result": [
    {
      "id": 157298399,
      "contestId": 1677,
      "creationTimeSeconds": 1652613839,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1677,
        "index": "A",
        "name": "Tokitsukaze and Strange Inequality",
        "type": "PROGRAMMING",
        "points": 500.0,
        "rating": 1600,
        "tags": [
          "brute force",
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1677,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1652020500
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "OK",
      "testset": "TESTS",
      "passedTestCount": 68,
      "timeConsumedMillis": 171,
      "memoryConsumedBytes": 202240000
    },
    {
      "id": 157297949,
      "contestId": 1677,
      "creationTimeSeconds": 1652613624,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1677,
        "index": "A",
        "name": "Tokitsukaze and Strange Inequality",
        "type": "PROGRAMMING",
        "points": 500.0,
        "rating": 1600,
        "tags": [
          "brute force",
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1677,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1652020500
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "TIME_LIMIT_EXCEEDED",
      "testset": "TESTS",
      "passedTestCount": 0,
      "timeConsumedMillis": 1500,
      "memoryConsumedBytes": 202240000
    },
    {
      "id": 157297917,
      "contestId": 1677,
      "creationTimeSeconds": 1652613604,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1677,
        "index": "A",
        "name": "Tokitsukaze and Strange Inequality",
        "type": "PROGRAMMING",
        "points": 500.0,
        "rating": 1600,
        "tags": [
          "brute force",
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1677,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1652020500
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "COMPILATION_ERROR",
      "testset": "TESTS",
      "passedTestCount": 0,
      "timeConsumedMillis": 0,
      "memoryConsumedBytes": 0
    },
    {
      "id": 155877351,
      "contestId": 1668,
      "creationTimeSeconds": 1651699260,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1668,
        "index": "D",
        "name": "Optimal Partition",
        "type": "PROGRAMMING",
        "points": 1500.0,
        "rating": 2100,
        "tags": [
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1668,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1650378900
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "OK",
      "testset": "TESTS",
      "passedTestCount": 101,
      "timeConsumedMillis": 2105,
      "memoryConsumedBytes": 118579200
    },
    {
      "id": 155877343,
      "contestId": 1668,
      "creationTimeSeconds": 1651699234,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1668,
        "index": "D",
        "name": "Optimal Partition",
        "type": "PROGRAMMING",
        "points": 1500.0,
        "rating": 2100,
        "tags": [
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1668,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1650378900
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "COMPILATION_ERROR",
      "testset": "TESTS",
      "passedTestCount": 0,
      "timeConsumedMillis": 0,
      "memoryConsumedBytes": 0
    },
    {
      "id": 155877195,
      "contestId": 1668,
      "creationTimeSeconds": 1651698896,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1668,
        "index": "D",
        "name": "Optimal Partition",
        "type": "PROGRAMMING",
        "points": 1500.0,
        "rating": 2100,
        "tags": [
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1668,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1650378900
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "MEMORY_LIMIT_EXCEEDED",
      "testset": "TESTS",
      "passedTestCount": 7,
      "timeConsumedMillis": 2043,
      "memoryConsumedBytes": 268390400
    },
    {
      "id": 155877100,
      "contestId": 1668,
      "creationTimeSeconds": 1651698706,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1668,
        "index": "D",
        "name": "Optimal Partition",
        "type": "PROGRAMMING",
        "points": 1500.0,
        "rating": 2100,
        "tags": [
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1668,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1650378900
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "MEMORY_LIMIT_EXCEEDED",
      "testset": "TESTS",
      "passedTestCount": 7,
      "timeConsumedMillis": 2277,
      "memoryConsumedBytes": 268390400
    },
    {
      "id": 155876701,
      "contestId": 1668,
      "creationTimeSeconds": 1651697809,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1668,
        "index": "D",
        "name": "Optimal Partition",
        "type": "PROGRAMMING",
        "points": 1500.0,
        "rating": 2100,
        "tags": [
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1668,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1650378900
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "MEMORY_LIMIT_EXCEEDED",
      "testset": "TESTS",
      "passedTestCount": 0,
      "timeConsumedMillis": 374,
      "memoryConsumedBytes": 268390400
    },
    {
      "id": 155876689,
      "contestId": 1668,
      "creationTimeSeconds": 1651697781,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1668,
        "index": "D",
        "name": "Optimal Partition",
        "type": "PROGRAMMING",
        "points": 1500.0,
        "rating": 2100,
        "tags": [
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1668,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1650378900
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "COMPILATION_ERROR",
      "testset": "TESTS",
      "passedTestCount": 0,
      "timeConsumedMillis": 0,
      "memoryConsumedBytes": 0
    },
    {
      "id": 155876667,
      "contestId": 1668,
      "creationTimeSeconds": 1651697737,
      "relativeTimeSeconds": 2147483647,
      "problem": {
        "contestId": 1668,
        "index": "D",
        "name": "Optimal Partition",
        "type": "PROGRAMMING",
        "points": 1500.0,
        "rating": 2100,
        "tags": [
          "data structures",
          "dp"
        ]
      },
      "author": {
        "contestId": 1668,
        "members": [
          {
            "handle": "Fefer_Ivan"
          }
        ],
        "participantType": "PRACTICE",
        "ghost": false,
        "startTimeSeconds": 1650378900
      },
      "programmingLanguage": "C++17 (GCC 7-32)",
      "verdict": "COMPILATION_ERROR",
      "testset": "TESTS",
      "passedTestCount": 0,
      "timeConsumedMillis": 0,
      "memoryConsumedBytes": 0
    }
  ]
}
 */