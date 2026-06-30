package com.thejesvini.interviewiq.service.impl;

import com.thejesvini.interviewiq.entity.Resume;
import com.thejesvini.interviewiq.entity.User;
import com.thejesvini.interviewiq.repository.ResumeRepository;
import com.thejesvini.interviewiq.repository.UserRepository;
import com.thejesvini.interviewiq.service.ResumeService;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    public ResumeServiceImpl(ResumeRepository resumeRepository,
                             UserRepository userRepository) {
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Resume uploadResume(MultipartFile file, Long userId) throws IOException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        File folder = new File("uploads");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filePath = "uploads/" + file.getOriginalFilename();

        file.transferTo(new File(filePath));

        PDDocument document = Loader.loadPDF(new File(filePath));

        PDFTextStripper stripper = new PDFTextStripper();

        String extractedText = stripper.getText(document);

        document.close();

        Resume resume = Resume.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .filePath(filePath)
                .extractedText(extractedText)
                .user(user)
                .build();

        return resumeRepository.save(resume);
    }

    @Override
    public Resume getResume(Long id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));
    }

    @Override
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    @Override
    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }
}