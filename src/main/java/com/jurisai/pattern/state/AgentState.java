package com.jurisai.pattern.state;

import com.jurisai.agent.LegalAgent;

public interface AgentState {

    void handle(LegalAgent agent);
}
