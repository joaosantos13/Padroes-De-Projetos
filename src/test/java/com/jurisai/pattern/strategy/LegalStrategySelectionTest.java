package com.jurisai.pattern.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class LegalStrategySelectionTest {

    @Test
    void shouldSelectConstitutionalStrategyForConstitutionalQuestions() {
        LegalStrategySelector selector = new LegalStrategySelector();

        LegalStrategy strategy = selector.selectStrategy("Quero saber sobre direitos fundamentais e constituição");

        assertNotNull(strategy);
        assertEquals("ConstitutionalStrategy", strategy.getClass().getSimpleName());
        assertEquals(
            "Estratégia constitucional: análise de direitos fundamentais, normas e princípios da Constituição.",
            strategy.executeStrategy());
    }

    @Test
    void shouldSelectConsumerStrategyForConsumerProtectionQuestions() {
        LegalStrategySelector selector = new LegalStrategySelector();

        LegalStrategy strategy = selector.selectStrategy("Há cobrança indevida em contrato de consumo e direito do consumidor");

        assertNotNull(strategy);
        assertEquals("ConsumerStrategy", strategy.getClass().getSimpleName());
        assertEquals(
            "Estratégia de consumo: análise de direitos do consumidor, contratos e CDC.",
            strategy.executeStrategy());
    }

    @Test
    void shouldSelectPrivacyStrategyForDataProtectionQuestions() {
        LegalStrategySelector selector = new LegalStrategySelector();

        LegalStrategy strategy = selector.selectStrategy("Como a LGPD trata o tratamento de dados pessoais e consentimento");

        assertNotNull(strategy);
        assertEquals("PrivacyStrategy", strategy.getClass().getSimpleName());
        assertEquals(
            "Estratégia de privacidade: análise de LGPD, dados pessoais e consentimento.",
            strategy.executeStrategy());
    }
}
