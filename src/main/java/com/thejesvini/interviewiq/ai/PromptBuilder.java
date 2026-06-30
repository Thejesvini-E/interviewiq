package com.thejesvini.interviewiq.ai;

public class PromptBuilder {

    public static String buildPrompt(
            String resume,
            String company,
            String jobDescription){

        return """
You are an Expert ATS Resume Reviewer and Technical Interview Coach.

Analyze the following Resume and Job Description.

Return STRICT JSON.

{
"resumeScore":0,
"atsScore":0,
"jobMatchScore":0,
"strengths":[],
"weaknesses":[],
"missingSkills":[],
"improvementSuggestions":[],
"interviewTopics":[],
"interviewQuestions":[],
"learningRoadmap":[]
}

Company:
%s

Job Description:
%s

Resume:
%s
""".formatted(company,jobDescription,resume);

    }

}