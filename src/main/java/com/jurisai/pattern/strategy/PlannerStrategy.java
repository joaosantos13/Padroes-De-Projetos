package com.jurisai.pattern.strategy; 

import com.jurisai.agent.LegalAgent;

public interface PlannerStrategy {
    void executePlan(LegalAgent agent);
}