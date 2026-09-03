package com.jurisai.Visual;


public class GenerateAnswerCommand implements Command {
    private String question;

    public GenerateAnswerCommand(String question) {
        this.question = question;
    }

    @Override
    public void execute() {
        System.out.println("Enviando a pergunta ao OLlama via Spring AI: " + question);
    }
}
