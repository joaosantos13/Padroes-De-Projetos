package com.jurisai.pattern.strategy;

public class ConstitutionalStrategy implements LegalStrategy {
    @Override
    public String executeStrategy() {
        return "Estratégia constitucional: análise de direitos fundamentais, normas e princípios da Constituição.";
    }
}
