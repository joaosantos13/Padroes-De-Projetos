package com.jurisai.Visual;


public class SaveHistoryCommand implements Command {
    private String question;
    private String answer;

    public SaveHistoryCommand(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public void execute() {
        System.out.println("Persistindo o histórico no banco de dados para a pergunta: " + question);
    }
}