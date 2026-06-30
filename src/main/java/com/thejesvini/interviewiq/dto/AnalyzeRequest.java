package com.thejesvini.interviewiq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalyzeRequest {

    private Long resumeId;

    private String company;

    private String jobDescription;

}