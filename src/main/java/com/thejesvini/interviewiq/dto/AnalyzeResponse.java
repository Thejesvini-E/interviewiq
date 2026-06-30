package com.thejesvini.interviewiq.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzeResponse {

    private Integer resumeScore;

    private Integer atsScore;

    private Integer jobMatchScore;

    private List<String> strengths;

    private List<String> weaknesses;

    private List<String> missingSkills;

    private List<String> improvementSuggestions;

    private List<String> interviewTopics;

    private List<String> interviewQuestions;

    private List<String> learningRoadmap;

}