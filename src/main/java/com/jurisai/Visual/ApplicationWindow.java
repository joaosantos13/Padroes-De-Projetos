package com.jurisai.Visual;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;

public class ApplicationWindow implements ComponenteGUI {
    private final List<ComponenteGUI> componentes = new ArrayList<>();

    public void adicionarComponente(ComponenteGUI componente) {
        componentes.add(componente);
    }

    @Override
    public Node renderizar() {
        VBox layoutPrincipal = new VBox(15);
        layoutPrincipal.setPadding(new Insets(20)); // Define uma margem de segurança de 20 pixels nas bordas internas para nada ficar colado nas paredes da janela

        // Fundo da janela com azul
        layoutPrincipal.setStyle("-fx-background-color: #1e1e2e;");

        for (ComponenteGUI c : componentes) {
            // Desenha a peça atual e coloca ela dentro da caixa organizadora principal
            layoutPrincipal.getChildren().add(c.renderizar());
        }
        // Entrega a janela completa com todas as peças organizadas e prontas para aparecer
        return layoutPrincipal;
    }
}