package com.jurisai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jurisai.entity.Question;
import com.jurisai.repository.QuestionRepository;

@SpringBootApplication
public class JurisAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JurisAiApplication.class, args);
    }

    // Este Bean executa um teste automático ao iniciar a aplicação
    @Bean
    public CommandLineRunner testDatabaseConnection(QuestionRepository questionRepository) {
        return args -> {
            System.out.println("--- INICIANDO TESTE DE BANCO DE DADOS ---");

            // 1. Criando uma pergunta de teste
            Question testQuestion = new Question();
            testQuestion.setText("Como funciona a devolução de produtos por arrependimento?");
            testQuestion.setCategory("Direito do Consumidor");

            // 2. Salvando no banco
            questionRepository.save(testQuestion);
            System.out.println("✅ Pergunta salva com sucesso! ID gerado: " + testQuestion.getId());

            // 3. Buscando a pergunta no banco pela categoria
            var recoveredQuestions = questionRepository.findByCategory("Direito do Consumidor");
            System.out.println("✅ Perguntas encontradas na categoria: " + recoveredQuestions.size());
            
            if (!recoveredQuestions.isEmpty()) {
                System.out.println("Texto da pergunta recuperada: " + recoveredQuestions.get(0).getText());
            }

            System.out.println("--- TESTE FINALIZADO COM SUCESSO ---");
        };
    }
}