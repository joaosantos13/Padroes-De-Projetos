package com.jurisai.agent;
import com.jurisai.ai.LegalAiService;
import com.jurisai.pattern.state.AgentState;
public class LegalAgent {
    private AgentState state;
    private String question;
    private String context;
    private String answer;
    private LegalAiService legalAiService;

    public void setQuestion(String question) {
        this.question = question;
    }
    public String getQuestion() {
        return question;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public String getContext() {
        return context;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }   

    public void setState(AgentState state) {
        this.state = state;
    }

    public AgentState getState() {
        return state;
    }
     public void process() {
        state.handle(this);
    }

    public LegalAgent(AgentState state) {
        this.state = state;
    }

    public LegalAiService getLegalAiService() {
    return legalAiService;
}

public void setLegalAiService(LegalAiService legalAiService) {
    this.legalAiService = legalAiService;
}
}

