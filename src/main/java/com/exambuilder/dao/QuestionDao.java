package com.exambuilder.dao;

import com.exambuilder.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Long> {
}
