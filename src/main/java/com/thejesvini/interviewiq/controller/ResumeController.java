package com.thejesvini.interviewiq.controller;

import com.thejesvini.interviewiq.entity.Resume;
import com.thejesvini.interviewiq.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/upload/{userId}")
    public ResponseEntity<Resume> uploadResume(
            @RequestParam("file") MultipartFile file,
            @PathVariable Long userId) throws IOException {

        return ResponseEntity.ok(
                resumeService.uploadResume(file, userId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResume(@PathVariable Long id) {

        return ResponseEntity.ok(
                resumeService.getResume(id)
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllResumes() {

        return ResponseEntity.ok(
                resumeService.getAllResumes()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResume(@PathVariable Long id) {

        resumeService.deleteResume(id);

        return ResponseEntity.ok("Resume deleted successfully");
    }
}