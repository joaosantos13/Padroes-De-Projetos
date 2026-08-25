package com.jurisai.Visual;


public class SearchJurisprudenceCommand implements Command {
    private String query;

    public SearchJurisprudenceCommand(String query) {
        this.query = query;
    }

    @Override
    public void execute() {
        System.out.println("Busca realizada na jurisprudência para o termo: " + query);
    }
}