package com.jurisai.pattern.state;

import com.jurisai.agent.LegalAgent;

public class ErrorState implements AgentState {

    @Override
    public void handle(LegalAgent agent) {
        System.out.println("Erro no processamento da pergunta.");
    }
}