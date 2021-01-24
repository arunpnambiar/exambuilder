package com.exambuilder.service;

import com.exambuilder.dao.QuestionDao;
import com.exambuilder.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionDao questionDao;
    @Override
    public Questions createQuestion(Questions question) {
        return questionDao.save(question);
    }

    @Override
    public Questions editQuestion(Questions question) {
        return questionDao.save(question);
    }

    @Override
    public void deleteQuestion(String id) {
        questionDao.deleteById(Long.valueOf(id));
    }

    @Override
    public List<Questions> viewAllQuestions() {
        return questionDao.findAll();
    }

    @Override
    public Optional<Questions> viewQuestionById(String id) {
        return questionDao.findById(Long.valueOf(id));
    }
}
