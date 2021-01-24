package com.exambuilder.dao;

import com.exambuilder.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamDao extends JpaRepository<Exam,Long> {
}
