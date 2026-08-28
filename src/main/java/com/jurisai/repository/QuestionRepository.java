package com.jurisai.repository;

import com.jurisai.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    // Método personalizado para buscar perguntas por categoria
    List<Question> findByCategory(String category);
}