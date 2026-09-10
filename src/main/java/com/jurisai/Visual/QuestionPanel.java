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
                // Atualiza a tela informando que está processando
                painelResposta.atualizarResposta("Processando com Inteligência Artificial (Ollama)... Aguarde.");

                try {
                    // Cria o agente iniciando pelo estado de receber a pergunta
                    com.jurisai.agent.LegalAgent agent = new com.jurisai.agent.LegalAgent(
                        new com.jurisai.pattern.state.ReceivingQuestionState()
                    );
                    
                    // Define a pergunta digitada na interface
                    agent.setQuestion(pergunta);

                    // Executa o fluxo de estados (Recebendo -> Analisando -> Buscando -> Gerando com o Ollama -> Completo)
                    agent.process(); // Receiving -> Analyzing
                    agent.process(); // Analyzing -> SearchingKnowledge
                    agent.process(); // SearchingKnowledge -> GeneratingAnswer (Aqui o Ollama é chamado de verdade!)
                    agent.process(); // GeneratingAnswer -> Completed

                    // Pega a resposta real gerada pelo Llama 3 e joga na tela!
                    String respostaReal = agent.getAnswer();
                    if (respostaReal != null && !respostaReal.isEmpty()) {
                        painelResposta.atualizarResposta(respostaReal);
                    } else {
                        painelResposta.atualizarResposta("O Ollama processou, mas retornou uma resposta vazia.");
                    }

                } catch (Exception ex) {
                    painelResposta.atualizarResposta("Erro ao comunicar com a IA: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }
}