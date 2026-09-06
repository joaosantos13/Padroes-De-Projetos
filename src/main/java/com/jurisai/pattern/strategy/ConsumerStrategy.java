package com.jurisai.pattern.strategy;

public class ConsumerStrategy implements LegalStrategy {
    @Override
    public String executeStrategy() {
        return "Estratégia de consumo: análise de direitos do consumidor, contratos e CDC.";
    }
}
