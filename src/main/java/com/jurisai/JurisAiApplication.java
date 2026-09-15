package com.jurisai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jurisai.Visual.AnswerPanel;
import com.jurisai.Visual.ApplicationWindow;
import com.jurisai.Visual.CommandExecutor;
import com.jurisai.Visual.HistoryPanel;
import com.jurisai.Visual.QuestionPanel;
import com.jurisai.Visual.SourcePanel;
import com.jurisai.agent.LegalAgent;
import com.jurisai.ai.LegalAiService;
import com.jurisai.pattern.state.ReceivingQuestionState;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SpringBootApplication
public class JurisAiApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void start(Stage primaryStage) {

        CommandExecutor executor = new CommandExecutor();

        ApplicationWindow janelaPrincipal = new ApplicationWindow();

        QuestionPanel painelPergunta = new QuestionPanel();

        AnswerPanel painelResposta = new AnswerPanel();

        painelPergunta.configurarAcaoBotao(
                executor,
                painelResposta
        );

        janelaPrincipal.adicionarComponente(painelPergunta);

        janelaPrincipal.adicionarComponente(painelResposta);

        janelaPrincipal.adicionarComponente(
                new SourcePanel()
        );

        janelaPrincipal.adicionarComponente(
                new HistoryPanel()
        );

        Scene scene = new Scene(
                (VBox) janelaPrincipal.renderizar(),
                600,
                500
        );

        primaryStage.setTitle(
                "JurisAI - Assistente Jurídico"
        );

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() {
        context = SpringApplication.run(JurisAiApplication.class);
    }

    @Override
    public void stop() {
        if (context != null) {
            context.close();
        }
    }

    public static void main(String[] args) {
        Application.launch(JurisAiApplication.class, args);
    }

    public void testarAgente() {

        LegalAiService legalAiService =
                context.getBean(LegalAiService.class);

        LegalAgent agent =
                new LegalAgent(new ReceivingQuestionState());

        agent.setLegalAiService(legalAiService);

        agent.setQuestion(
                "Quais são meus direitos como consumidor?"
        );

        System.out.println(
                "Estado inicial: "
                + agent.getState().getClass().getSimpleName()
        );

        agent.process();

        System.out.println(
                "Depois de processar: "
                + agent.getState().getClass().getSimpleName()
        );

        agent.process();

        System.out.println(
                "Depois de processar: "
                + agent.getState().getClass().getSimpleName()
        );

        agent.process();

        System.out.println(
                "Depois de processar: "
                + agent.getState().getClass().getSimpleName()
        );

        agent.process();

        System.out.println(
                "Estado final: "
                + agent.getState().getClass().getSimpleName()
        );

        System.out.println("\nRESPOSTA DO LLAMA 3:");
        System.out.println(agent.getAnswer());
    }

}