# JurisAI — Knowledge Assistant Jurídico

> **Aviso Legal:** Esta aplicação possui caráter estritamente informativo e **não substitui orientação jurídica profissional**.

## ⚖️ Visão Geral
O **JurisAI** é um assistente de conhecimento jurídico desenvolvido em Java e Spring Boot. Ele utiliza **Spring AI**, **Ollama** e o modelo **Llama 3** para responder dúvidas legais com base em fontes documentais confiáveis (ex: Constituição Federal, CDC, LGPD).

## 🛠️ Tecnologias
- Java 17+
- Spring Boot & Spring AI
- Ollama & Llama 3
- JavaFX (GUI)
- Maven
- Banco de Dados Relacional

## 🧩 Design Patterns Aplicados
- **State Pattern:** Controle do ciclo de vida e estados do agente.
- **Strategy Pattern:** Seleção da estratégia de análise jurídica adequada.
- **Command Pattern:** Encapsulamento das ações do agente (buscas, geração, salvamento).
- **Observer Pattern:** Notificação de eventos para GUI, logs e histórico.
- **Composite Pattern:** Estruturação hierárquica dos componentes da interface gráfica.

## 🚀 Como Executar
1. Instale e inicie o Ollama com o Llama 3:
   ```bash
   ollama run llama3
   ```
2. Clone o repositório e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
