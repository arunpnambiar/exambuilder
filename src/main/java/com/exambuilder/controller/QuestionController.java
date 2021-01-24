package com.exambuilder.controller;

import com.exambuilder.model.Exam;
import com.exambuilder.model.Questions;
import com.exambuilder.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping
    @RequestMapping("/v1/private/question/savequestion")
    public Questions createQuestions(@RequestBody Questions question){
        return questionService.createQuestion(question);
    }
    @PostMapping
    @RequestMapping("/v1/private/question/updatetquestion")
    public Questions editQuestions(@RequestBody Questions question){
        return questionService.editQuestion(question);
    }
    @DeleteMapping
    @RequestMapping("/v1/private/question/{id}")
    public String deleteQuestions(@PathVariable String id){
        questionService.deleteQuestion(id);
        return "Sucess";
    }

    @GetMapping
    @RequestMapping("v1/private/question/viewquestions")
    public List<Questions> viewAllQuestions(){
        return questionService.viewAllQuestions();
    }

    @GetMapping
    @RequestMapping("/v1/private/exam/viewquestionbyid/{id}")
    public Questions viewQuestionsById(@PathVariable String id){
        return questionService.viewQuestionById(id).get();
    }
}
