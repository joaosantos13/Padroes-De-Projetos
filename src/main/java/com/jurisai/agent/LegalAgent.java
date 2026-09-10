package com.jurisai.agent;

import com.jurisai.ai.LegalAiService;
import com.jurisai.pattern.state.AgentState;
import com.jurisai.config.SpringContext;

public class LegalAgent {
    
    private AgentState state;
    private String question;
    private String context;
    private String answer;
    private LegalAiService legalAiService;

    // Construtor atualizado com a Ponte do Spring
    public LegalAgent(AgentState state) {
        this.state = state;
        try {
            this.legalAiService = SpringContext.getBean(LegalAiService.class);
        } catch (Exception e) {
            System.out.println("Aviso: Contexto do Spring ainda não inicializado ou LegalAiService não encontrado.");
        }
    }

    public void process() {
        state.handle(this);
    }

    // --- GETTERS E SETTERS RESTAURADOS ---

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

    public LegalAiService getLegalAiService() {
        return legalAiService;
    }

    public void setLegalAiService(LegalAiService legalAiService) {
        this.legalAiService = legalAiService;
    }
}