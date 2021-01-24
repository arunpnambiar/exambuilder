package com.exambuilder.dao;

import com.exambuilder.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<Subject,Long> {
}
