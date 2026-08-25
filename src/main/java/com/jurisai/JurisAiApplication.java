package com.jurisai;

import com.jurisai.Visual.AnswerPanel;
import com.jurisai.Visual.ApplicationWindow;
import com.jurisai.Visual.CommandExecutor;
import com.jurisai.Visual.HistoryPanel;
import com.jurisai.Visual.QuestionPanel;
import com.jurisai.Visual.SourcePanel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

    public static void main(String[] args) {
        launch(args);
    }
}