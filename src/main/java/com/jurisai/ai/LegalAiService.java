package com.jurisai.ai;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.client.ChatClient;
@Service
public class LegalAiService {

    private final ChatClient chatClient;
    public LegalAiService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generateAnswer(String question){
       return chatClient
                .prompt()
                .system("""
                        Você é o JurisAI, um assistente de conhecimento jurídico.

                        Sua função é fornecer respostas claras e objetivas
                        sobre questões jurídicas.

                        Utilize apenas as informações fornecidas no contexto
                        quando um contexto estiver disponível.

                        Não invente leis, artigos, decisões judiciais ou fontes.

                        Suas respostas possuem finalidade exclusivamente
                        informativa e não substituem orientação jurídica
                        profissional.
                        """)
                .user(question)
                .call()
                .content();
    }
}
