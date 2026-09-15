package com.jurisai.pattern.state;

import com.jurisai.agent.LegalAgent;
import com.jurisai.pattern.strategy.PlannerStrategy;
import com.jurisai.pattern.strategy.ReactPlanner;

public class AnalyzingState implements AgentState {
    
    @Override
    public void handle(LegalAgent agent) {
        // Instancia a estratégia avançada (ReAct)
        PlannerStrategy strategy = new ReactPlanner();

        // O planejador assume o controle, consulta o LLM e define o próximo estado
        strategy.executePlan(agent);
    }
}