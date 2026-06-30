package com.thejesvini.interviewiq.ai;

import com.thejesvini.interviewiq.dto.AnalyzeRequest;
import com.thejesvini.interviewiq.entity.Resume;
import com.thejesvini.interviewiq.service.ResumeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AiController {

    private final GeminiService geminiService;
    private final ResumeService resumeService;

    public AiController(
            GeminiService geminiService,
            ResumeService resumeService){

        this.geminiService=geminiService;
        this.resumeService=resumeService;

    }

    @PostMapping("/analyze")
    public String analyze(
            @RequestBody AnalyzeRequest request){

        Resume resume=
                resumeService.getResume(request.getResumeId());

        return geminiService.analyzeResume(

                resume.getExtractedText(),

                request.getCompany(),

                request.getJobDescription()

        );

    }

}