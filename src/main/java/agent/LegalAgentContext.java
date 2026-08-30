package agent;

import command.LegalCommand;
import observer.AgentObserver;
import strategy.LegalStrategy;

import java.util.ArrayList;
import java.util.List;

public class LegalAgentContext {

    private AgentState currentState;
    private LegalStrategy currentStrategy;
    private final List<LegalStrategy> strategies;
    private final List<AgentObserver> observers = new ArrayList<>();

    private String userQuery;
    private List<String> retrievedSources = new ArrayList<>();
    private String generatedAnswer;

    public LegalAgentContext(List<LegalStrategy> strategies) {
        this.strategies = strategies;
    }

    public void addObserver(AgentObserver observer) {
        observers.add(observer);
    }

    public void setState(AgentState state) {
        this.currentState = state;
        notifyObserversStateChange(state.getStateName());
        state.handle(this);
    }

    public void processQuestion(String query) {
        try {
            this.userQuery = query;

            // 1. Recebimento da pergunta
            setState(new ReceivingQuestionState());

            // 2. Analise e selecao de estrategia
            setState(new AnalyzingState());
            this.currentStrategy = findStrategy(query);

            // 3. Busca nas fontes juridicas (RAG)
            setState(new SearchingKnowledgeState());
            this.retrievedSources = currentStrategy.retrieveContext(query);

            // 4. Geracao da resposta via IA
            setState(new GeneratingAnswerState());
            this.generatedAnswer = executeAiCall(query, retrievedSources);

            // 5. Finalizacao e notificacao
            setState(new CompletedState());
            notifyAnswerCompleted();

        } catch (Exception e) {
            setState(new ErrorState(e.getMessage()));
            notifyError(e);
        }
    }

    private LegalStrategy findStrategy(String query) {
        for (LegalStrategy strategy : strategies) {
            if (strategy.supports(query)) {
                return strategy;
            }
        }
        throw new RuntimeException("Nenhuma estrategia compativel para o tema.");
    }

    private String executeAiCall(String query, List<String> sources) {
        return "Com base na legislacao consultada: [...] (Aviso: carater puramente informativo).";
    }

    private void notifyObserversStateChange(String stateName) {
        for (AgentObserver obs : observers) {
            obs.onStateChanged(stateName);
        }
    }

    private void notifyAnswerCompleted() {
        for (AgentObserver obs : observers) {
            obs.onAnswerGenerated(this.generatedAnswer, this.retrievedSources);
        }
    }

    private void notifyError(Exception e) {
        for (AgentObserver obs : observers) {
            obs.onError(e.getMessage());
        }
    }

    public String getUserQuery() {
        return userQuery;
    }

    public List<String> getRetrievedSources() {
        return retrievedSources;
    }
}