package agent;

public interface AgentState {
    void handle(LegalAgentContext context);
    String getStateName();
}