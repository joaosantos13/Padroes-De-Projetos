package com.jurisai.pattern.state;

import com.jurisai.agent.LegalAgent;


public class SearchingKnowledgeState implements AgentState {
    


    @Override
    public void handle(LegalAgent agent) {
        agent.setState(new GeneratingAnswerState());
    }
}