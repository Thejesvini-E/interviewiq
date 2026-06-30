package com.thejesvini.interviewiq.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAnalysisResponse {

    private Integer resumeScore;

    private Integer atsScore;

    private List<String> strengths;

    private List<String> missingSkills;

    private List<String> improvements;

    private List<String> interviewQuestions;

    private List<String> learningRoadmap;
}