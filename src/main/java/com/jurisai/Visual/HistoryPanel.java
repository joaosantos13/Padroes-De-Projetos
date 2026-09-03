package com.jurisai.Visual;


import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HistoryPanel implements ComponenteGUI {
    private final Label lblStatus = new Label("Histórico de consultas");

    @Override
    public Node renderizar() {
        VBox box = new VBox(5);

        // Título roxo, ajusta o tamanho para 12px e deixa as letras em negrito
        lblStatus.setStyle("-fx-text-fill: #cba6f7; -fx-font-size: 12px; -fx-font-weight: bold;");
        box.getChildren().add(lblStatus); // Coloca o texto do título dentro da caixa
        return box;
    }
}