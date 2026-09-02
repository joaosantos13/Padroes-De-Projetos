package com.jurisai.pattern.state;
import com.jurisai.agent.LegalAgent;
public class ReceivingQuestionState implements AgentState {
    @Override
    public void handle(LegalAgent agent) {
        if(agent.getQuestion() == null || agent.getQuestion().isBlank()) {
            agent.setState(new ErrorState());
        }else{
            agent.setState(new AnalyzingState());
            }
            
        }
       
    }

