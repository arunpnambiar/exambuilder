package com.exambuilder.service;

import com.exambuilder.dao.ExamDao;
import com.exambuilder.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService{
    @Autowired
    ExamDao examDao;

    @Override
    public Exam createExam(Exam exam) {
        return examDao.save(exam);
    }

    @Override
    public Exam editExam(Exam exam) {
        return examDao.save(exam);
    }

    @Override
    public void deleteExam(String id) {
        examDao.deleteById(Long.valueOf(id));
    }

    @Override
    public List<Exam> viewAllExam() {
        return examDao.findAll();
    }

    @Override
    public Optional<Exam> viewExamById(String id) {
        return examDao.findById(Long.valueOf(id));
    }
}
