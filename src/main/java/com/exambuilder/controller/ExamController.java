package com.exambuilder.controller;

import com.exambuilder.model.Exam;
import com.exambuilder.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ExamController {
    @Autowired
    ExamService examService;

    @PostMapping
    @RequestMapping("/v1/private/exam/insertexam")
    public Exam createExam(@RequestBody Exam exam){
        return examService.createExam(exam);
    }
    @PostMapping
    @RequestMapping("/v1/private/exam/updatetexam")
    public Exam editExam(@RequestBody Exam exam){
        return examService.editExam(exam);
    }
    @DeleteMapping
    @RequestMapping("/v1/private/exam/{id}")
    public String deleteExam(@PathVariable String id){
        examService.deleteExam(id);
        return "Sucess";
    }

    @GetMapping
    @RequestMapping("/v1/private/exam/viewexam")
    public List<Exam> viewAllExam(){
        return examService.viewAllExam();
    }

    @GetMapping
    @RequestMapping("/v1/private/exam/viewexambyid/{id}")
    public Exam viewExamById(@PathVariable String id){
        return examService.viewExamById(id).get();
    }
}
