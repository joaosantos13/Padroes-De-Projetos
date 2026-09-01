package com.jurisai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jurisai.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    // Método personalizado para buscar perguntas por categoria
    List<Question> findByCategory(String category);
    List<Question> findAllByOrderByCreatedAtDesc();
}