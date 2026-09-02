package com.jurisai;

import com.jurisai.Visual.AnswerPanel;
import com.jurisai.Visual.ApplicationWindow;
import com.jurisai.Visual.CommandExecutor;
import com.jurisai.Visual.HistoryPanel;
import com.jurisai.Visual.QuestionPanel;
import com.jurisai.Visual.SourcePanel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SpringBootApplication
public class JurisAiApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Cria o executor que vai processar os comandos
        // e perguntas do usuário
        CommandExecutor executor = new CommandExecutor();

        // Cria a estrutura da janela principal
        ApplicationWindow janelaPrincipal = new ApplicationWindow();

        // Cria o painel da pergunta
        QuestionPanel painelPergunta = new QuestionPanel();

        // Cria o painel da resposta
        AnswerPanel painelResposta = new AnswerPanel();

        // Conecta o painel de pergunta ao executor
        // e ao painel de resposta
        painelPergunta.configurarAcaoBotao(
                executor,
                painelResposta
        );

        // Adiciona o painel de pergunta
        janelaPrincipal.adicionarComponente(painelPergunta);

        // Adiciona o painel de resposta
        janelaPrincipal.adicionarComponente(painelResposta);

        // Adiciona o painel de fontes
        janelaPrincipal.adicionarComponente(
                new SourcePanel()
        );

        // Adiciona o painel de histórico
        janelaPrincipal.adicionarComponente(
                new HistoryPanel()
        );

        // Monta a cena principal
        Scene scene = new Scene(
                (VBox) janelaPrincipal.renderizar(),
                600,
                500
        );

        // Configura a janela
        primaryStage.setTitle(
                "JurisAI - Assistente Jurídico"
        );

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void init() {
        SpringApplication.run(JurisAiApplication.class);
    }

   public static void main(String[] args) {
        Application.launch(JurisAiApplication.class, args);
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