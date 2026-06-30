package com.thejesvini.interviewiq.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeResponse {

    private Long id;

    private String fileName;

    private String extractedText;

    private String uploadedAt;

    private Long userId;
}