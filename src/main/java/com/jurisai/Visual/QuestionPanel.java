package com.jurisai.Visual;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class QuestionPanel implements ComponenteGUI {
    private final TextArea txtPergunta = new TextArea();
    private final Button btnEnviar = new Button("Enviar Pergunta");

    @Override
    public Node renderizar() {
        VBox box = new VBox(6);

        // Rótulo alinhado com o padrão do AnswerPanel
        Label lbl = new Label("Pergunta:");
        // Título cinza, negrito e 13px
        lbl.setStyle("-fx-text-fill: #a6adc8; -fx-font-weight: bold; -fx-font-size: 13px;");

        txtPergunta.setPromptText("Digite sua dúvida jurídica aqui");
        txtPergunta.setPrefRowCount(3);
        txtPergunta.setWrapText(true);
        // Caixa de texto escuro, letras brancas e bordas arredondadas
        txtPergunta.setStyle(
                "-fx-control-inner-background: #2b2b3b; " +
                        "-fx-text-fill: #ffffff; " +
                        "-fx-font-size: 14px; " +
                        "-fx-border-color: #444466; " +
                        "-fx-border-radius: 6px; " +
                        "-fx-background-radius: 6px;"
        );

        btnEnviar.setMaxWidth(Double.MAX_VALUE);
        // Botão roxo, letras brancas em negrito, espaçamento interno e muda o ponteiro do mouse
        btnEnviar.setStyle(
                "-fx-background-color: #6c5ce7; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 10px; " +
                        "-fx-background-radius: 6px; " +
                        "-fx-cursor: hand;"
        );

        box.getChildren().addAll(lbl, txtPergunta, btnEnviar);
        return box;
    }

    public void configurarAcaoBotao(CommandExecutor executor, AnswerPanel painelResposta) {
        btnEnviar.setOnAction(e -> {
            String pergunta = txtPergunta.getText();
            if (!pergunta.isEmpty()) {
                executor.runCommand(new SearchLawCommand(pergunta)); // Manda procurar as leis relacionadas à pergunta
                executor.runCommand(new SearchJurisprudenceCommand(pergunta)); // Manda procurar decisões judiciais anteriores sobre a dúvida
                executor.runCommand(new GenerateAnswerCommand(pergunta)); // Manda a ia gerar uma resposta
                executor.runCommand(new ShowSourcesCommand("Art. 5º da CF / Art. 335 do CPC")); // Manda exibir os artigos da lei usados como referência
                executor.runCommand(new SaveHistoryCommand(pergunta, "Resposta do OLlama")); // Manda salvar essa consulta e resposta no histórico
                painelResposta.atualizarResposta("Processado via Command: Nenhuma conduta ilícita encontrada para a busca: " + pergunta); // Atualiza o painel
            }
        });
    }
}