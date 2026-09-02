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
}