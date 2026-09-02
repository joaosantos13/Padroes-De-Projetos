

import com.jurisai.agent.LegalAgent;
import com.jurisai.pattern.state.AnalyzingState;
import com.jurisai.pattern.state.CompletedState;
import com.jurisai.pattern.state.ErrorState;
import com.jurisai.pattern.state.GeneratingAnswerState;
import com.jurisai.pattern.state.ReceivingQuestionState;
import com.jurisai.pattern.state.SearchingKnowledgeState;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class LegalAgentStateTest {

    @Test
    void deveIrParaAnalyzingQuandoPerguntaForValida() {

        LegalAgent agent = new LegalAgent(new ReceivingQuestionState());

        agent.setQuestion("Quais são meus direitos como consumidor?");

        agent.process();

        assertInstanceOf(AnalyzingState.class, agent.getState());
    }

    @Test
    void deveIrParaErrorQuandoPerguntaForVazia() {

        LegalAgent agent = new LegalAgent(new ReceivingQuestionState());

        agent.setQuestion("");

        agent.process();

        assertInstanceOf(ErrorState.class, agent.getState());
    }

    @Test
void devePercorrerFluxoCompletoDosEstados() {

    LegalAgent agent = new LegalAgent(new ReceivingQuestionState());

    agent.setQuestion("Quais são meus direitos como consumidor?");

    agent.process();
    assertInstanceOf(AnalyzingState.class, agent.getState());

    agent.process();
    assertInstanceOf(SearchingKnowledgeState.class, agent.getState());

    agent.process();
    assertInstanceOf(GeneratingAnswerState.class, agent.getState());

    agent.process();
    assertInstanceOf(CompletedState.class, agent.getState());

    // ordem = Receiving → Analyzing → SearchingKnowledge → GeneratingAnswer → Completed
    // e se em qualquer lugar que der erro ele vai para o ErrorState
}
}
