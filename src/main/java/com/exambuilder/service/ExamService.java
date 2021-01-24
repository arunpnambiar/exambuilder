package com.exambuilder.service;

import com.exambuilder.model.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    public Exam createExam(Exam exam);
    public Exam editExam(Exam exam);
    public void deleteExam(String id);
    public List<Exam> viewAllExam();
    public Optional<Exam> viewExamById(String id);
}
