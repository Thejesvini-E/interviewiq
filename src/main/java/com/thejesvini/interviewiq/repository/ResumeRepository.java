package com.thejesvini.interviewiq.repository;

import com.thejesvini.interviewiq.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}