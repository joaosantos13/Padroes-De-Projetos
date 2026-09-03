package com.jurisai.Visual;


public class SearchLawCommand implements Command {
    private String query;

    public SearchLawCommand(String query) {
        this.query = query;
    }

    @Override
    public void execute() {
        System.out.println("Busca realizada no banco de leis para o termo: " + query);
    }
}
