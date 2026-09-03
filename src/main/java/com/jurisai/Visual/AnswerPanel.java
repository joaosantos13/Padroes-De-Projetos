package com.jurisai.Visual;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class AnswerPanel implements ComponenteGUI {

    // Caixa onde será exibida a resposta
    private final TextArea txtResposta = new TextArea();

    @Override
    public Node renderizar() {

        VBox box = new VBox(6);

        Label lbl = new Label("Resposta da IA:");

        // Estilo do título
        lbl.setStyle(
                "-fx-text-fill: #a6adc8; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 13px;"
        );

        // Configura a caixa de resposta
        txtResposta.setEditable(false);
        txtResposta.setPromptText(
                "A resposta aparecerá aqui"
        );

        txtResposta.setPrefRowCount(5);
        txtResposta.setWrapText(true);

        // Estilo da caixa de resposta
        txtResposta.setStyle(
                "-fx-control-inner-background: #181825; " +
                "-fx-text-fill: #a6e3a1; " +
                "-fx-font-size: 13px; " +
                "-fx-border-color: #313244; " +
                "-fx-border-radius: 6px; " +
                "-fx-background-radius: 6px;"
        );

        box.getChildren().addAll(
                lbl,
                txtResposta
        );

        return box;
    }

    public void atualizarResposta(String texto) {
        txtResposta.setText(texto);
    }
}