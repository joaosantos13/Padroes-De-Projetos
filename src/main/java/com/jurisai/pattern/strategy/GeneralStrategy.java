package com.jurisai.pattern.strategy;

public class GeneralStrategy implements LegalStrategy {
    @Override
    public String executeStrategy() {
        return "Estratégia geral: análise jurídica ampla com revisão de normas aplicáveis.";
    }
}
