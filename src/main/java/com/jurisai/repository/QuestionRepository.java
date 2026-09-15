package com.jurisai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jurisai.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    List<Question> findByCategory(String category);
    List<Question> findAllByOrderByCreatedAtDesc();
}