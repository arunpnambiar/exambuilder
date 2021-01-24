package com.exambuilder.service;

import com.exambuilder.model.Exam;
import com.exambuilder.model.Questions;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    public Questions createQuestion(Questions question);
    public Questions editQuestion(Questions question);
    public void deleteQuestion(String id);
    public List<Questions> viewAllQuestions();
    public Optional<Questions> viewQuestionById(String id);
}
