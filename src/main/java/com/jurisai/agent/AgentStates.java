package agent;

class ReceivingQuestionState implements AgentState {
    public void handle(LegalAgentContext context) {}
    public String getStateName() { return "RECEIVING_QUESTION"; }
}

class AnalyzingState implements AgentState {
    public void handle(LegalAgentContext context) {}
    public String getStateName() { return "ANALYZING"; }
}

class SearchingKnowledgeState implements AgentState {
    public void handle(LegalAgentContext context) {}
    public String getStateName() { return "SEARCHING_KNOWLEDGE"; }
}

class GeneratingAnswerState implements AgentState {
    public void handle(LegalAgentContext context) {}
    public String getStateName() { return "GENERATING_ANSWER"; }
}

class CompletedState implements AgentState {
    public void handle(LegalAgentContext context) {}
    public String getStateName() { return "COMPLETED"; }
}

class ErrorState implements AgentState {
    private final String error;

    public ErrorState(String error) {
        this.error = error;
    }

    public void handle(LegalAgentContext context) {}
    public String getStateName() { return "ERROR: " + error; }
}