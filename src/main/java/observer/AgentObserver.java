package observer;

import java.util.List;

public interface AgentObserver {
    void onStateChanged(String stateName);
    void onAnswerGenerated(String answer, List<String> sources);
    void onError(String errorMessage);
}
