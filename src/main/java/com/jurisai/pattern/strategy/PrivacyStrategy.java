package com.jurisai.pattern.strategy;

public class PrivacyStrategy implements LegalStrategy {
    @Override
    public String executeStrategy() {
        return "Estratégia de privacidade: análise de LGPD, dados pessoais e consentimento.";
    }
}
