package com.jurisai.pattern.strategy;

import java.util.Locale;

public class LegalStrategySelector {

    public LegalStrategy selectStrategy(String legalQuestion) {
        if (legalQuestion == null || legalQuestion.isBlank()) {
            return new GeneralStrategy();
        }

        String question = legalQuestion.toLowerCase(Locale.ROOT);

        if (question.contains("constitui")
                || question.contains("direitos fundamentais")
                || question.contains("constitucional")
                || question.contains("supremo")) {
            return new ConstitutionalStrategy();
        }

        if (question.contains("cdc")
                || question.contains("consumidor")
                || question.contains("contrato")
                || question.contains("cobrança")
                || question.contains("indevida")) {
            return new ConsumerStrategy();
        }

        if (question.contains("lgpd")
                || question.contains("dados pessoais")
                || question.contains("privacidade")
                || question.contains("consentimento")
                || question.contains("tratamento de dados")) {
            return new PrivacyStrategy();
        }

        return new GeneralStrategy();
    }
}
