package com.thejesvini.interviewiq.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeUploadResponse {

    private String message;

    private Long resumeId;

    private String fileName;

}