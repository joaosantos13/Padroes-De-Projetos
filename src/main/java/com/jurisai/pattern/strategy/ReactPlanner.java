package com.jurisai.pattern.strategy;

import com.jurisai.agent.LegalAgent;
import com.jurisai.pattern.state.GeneratingAnswerState;
import com.jurisai.pattern.state.SearchingKnowledgeState;

public class ReactPlanner implements PlannerStrategy {

    @Override
    public void executePlan(LegalAgent agent) {
        System.out.println("[Estratégia] ReAct Planner: Pedindo para a IA raciocinar sobre a pergunta...");

        try {
            // Passo 1: REASON (Raciocinar)
            // Criamos um "meta-prompt" pedindo para a IA decidir qual ferramenta usar
            String promptRaciocinio = "Você é o cérebro de um agente jurídico. Analise a seguinte dúvida do usuário: '" 
                                    + agent.getQuestion() + "'. "
                                    + "Responda APENAS com a palavra 'BUSCAR' se você precisar consultar a base de leis e jurisprudências para responder, "
                                    + "ou responda APENAS 'DIRETO' se for uma pergunta simples que não exige consulta. "
                                    + "Não escreva mais nada além de uma dessas duas palavras.";

            // Chama o Ollama rapidamente para tomar a decisão
            String decisaoIa = agent.getLegalAiService().generateAnswer(promptRaciocinio).toLowerCase();
            System.out.println("Raciocínio da IA (Ollama): Decidiu usar o caminho -> " + decisaoIa);

            // Passo 2: ACT (Agir)
            // O sistema muda de estado com base na decisão autônoma da IA
            if (decisaoIa.contains("buscar")) {
                agent.setState(new SearchingKnowledgeState());
            } else {
                agent.setState(new GeneratingAnswerState());
            }

        } catch (Exception e) {
            System.out.println("Erro na comunicação para raciocínio. Usando fallback de resposta direta.");
            agent.setState(new GeneratingAnswerState());
        }
    }
}