package com.jurisai.pattern.state;

import com.jurisai.agent.LegalAgent;

public class CompletedState implements AgentState {

    @Override
    public void handle(LegalAgent agent) {
        System.out.println("Processamento concluído.");
    }
}
