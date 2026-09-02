# Arquitetura e Planejamento - JurisAI

## 6. Divisão das Atividades

| Membro | Área | Atividades Principais |
| :--- | :--- | :--- |
| Membro 1 | Arquitetura e State | Estrutura geral, classe de contexto do agente e estados (State Pattern). |
| Membro 2 | Spring AI e LLM | Integração com Ollama/Llama 3 e construção dos prompts. |
| Membro 3 | Knowledge Base / RAG | Preparação dos documentos (CF, CDC, LGPD) e busca vetorial. |
| Membro 4 | Strategy | Interface e estratégias de classificação jurídica (Strategy Pattern). |
| Membro 5 | Command | Comandos de busca, geração e histórico (Command Pattern). |
| Membro 6 | Observer | Sistema de eventos e ouvintes de log, GUI e histórico (Observer Pattern). |
| Membro 7 | GUI e Composite | Interface gráfica em JavaFX e estrutura visual (Composite Pattern). |
| Membro 8 | Banco de Dados | Modelagem e persistência de histórico e consultas. |
| Membro 9 | UML e Documentação | Diagramas UML, documentação técnica e apoio na integração. |

---

## 9. Fluxo de Execução do Sistema

1. O usuário digita a dúvida na interface gráfica (GUI).
2. A requisição chega ao Controller e é enviada para o LegalAgent.
3. O agente assume o estado inicial (`ReceivingQuestionState`).
4. O sistema analisa o tema e seleciona a estratégia jurídica adequada (`AnalyzingState` / Strategy).
5. O comando de busca é acionado para consultar os documentos na base de conhecimento (`SearchingKnowledgeState` / Command / RAG).
6. As informações encontradas e a pergunta são enviadas ao Spring AI / Ollama (`GeneratingAnswerState`).
7. O Llama 3 processa a solicitação e gera a resposta com fundamentação e aviso legal.
8. Os observadores são acionados para registrar logs, salvar histórico e atualizar a tela (`CompletedState` / Observer).
9. A interface gráfica exibe a resposta final com as fontes consultadas.