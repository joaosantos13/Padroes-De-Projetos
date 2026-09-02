package com.jurisai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jurisai.ai.LegalAiService;
import com.jurisai.agent.LegalAgent;
import com.jurisai.pattern.state.ReceivingQuestionState;


@SpringBootApplication
public class JurisAiApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context =
                SpringApplication.run(JurisAiApplication.class, args);

        LegalAiService legalAiService =
                context.getBean(LegalAiService.class);

        LegalAgent agent = new LegalAgent(new ReceivingQuestionState());

        agent.setLegalAiService(legalAiService);

        agent.setQuestion("Quais são meus direitos como consumidor?");

        System.out.println("Estado inicial: "
                + agent.getState().getClass().getSimpleName());

        agent.process();

        System.out.println("Depois de processar: "
                + agent.getState().getClass().getSimpleName());

        agent.process();

        System.out.println("Depois de processar: "
                + agent.getState().getClass().getSimpleName());

        agent.process();

        System.out.println("Depois de processar: "
                + agent.getState().getClass().getSimpleName());

        agent.process();

        System.out.println("Estado final: "
                + agent.getState().getClass().getSimpleName());

        System.out.println("\nRESPOSTA DO LLAMA 3:");
        System.out.println(agent.getAnswer());

        context.close();
    }


    /* Este Bean executa um teste automático ao iniciar a aplicação
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
    }*/
}