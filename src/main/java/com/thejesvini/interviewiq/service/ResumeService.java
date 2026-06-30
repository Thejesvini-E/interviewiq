package com.thejesvini.interviewiq.service;

import com.thejesvini.interviewiq.entity.Resume;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ResumeService {

    Resume uploadResume(MultipartFile file, Long userId) throws IOException;

    Resume getResume(Long id);

    List<Resume> getAllResumes();

    void deleteResume(Long id);

}