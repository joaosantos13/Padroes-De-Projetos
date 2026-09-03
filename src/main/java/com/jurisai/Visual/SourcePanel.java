package com.jurisai.Visual;


import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SourcePanel implements ComponenteGUI {
    private final Label lblFontes = new Label("Fontes Consultadas: ");

    @Override
    public Node renderizar() {
        VBox box = new VBox(5);
        // Texto azul, tamanho 12px e letras em itálico
        lblFontes.setStyle("-fx-text-fill: #89b4fa; -fx-font-size: 12px; -fx-font-style: italic;");
        box.getChildren().add(lblFontes);
        return box;
    }

    public void atualizarFontes(String fontes) {

        lblFontes.setText("Fontes Consultadas: " + fontes);
    }
}