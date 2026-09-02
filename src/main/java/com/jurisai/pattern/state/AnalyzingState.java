package com.jurisai.pattern.state;

import com.jurisai.agent.LegalAgent;

public class AnalyzingState implements AgentState {


    @Override
    public void handle(LegalAgent agent) {
        agent.setState(new SearchingKnowledgeState());
    }
}
