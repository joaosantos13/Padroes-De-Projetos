package com.jurisai.Visual;


public class ShowSourcesCommand implements Command {
    private String documentSource;

    public ShowSourcesCommand(String documentSource) {
        this.documentSource = documentSource;
    }

    @Override
    public void execute() {
        System.out.println("Exibindo fonte jurídica consultada: " + documentSource);
    }
}