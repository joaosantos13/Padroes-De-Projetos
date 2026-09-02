package com.jurisai.pattern.state;

import com.jurisai.agent.LegalAgent;

public class GeneratingAnswerState implements AgentState {

    @Override
    public void handle(LegalAgent agent) {

        if (agent.getLegalAiService() != null) {

            String resposta = agent.getLegalAiService()
                    .generateAnswer(agent.getQuestion());

            agent.setAnswer(resposta);
        }

        agent.setState(new CompletedState());
    }
}