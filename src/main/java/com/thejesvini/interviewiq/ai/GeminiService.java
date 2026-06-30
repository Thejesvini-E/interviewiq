package com.thejesvini.interviewiq.ai;

import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    public String analyzeResume(
            String resume,
            String company,
            String jobDescription){

        return PromptBuilder.buildPrompt(
                resume,
                company,
                jobDescription
        );

    }

}