import com.jurisai.JurisAiApplication;
import com.jurisai.ai.LegalAiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JurisAiApplication.class)
public class LegalAiServiceTest {

    @Autowired
    private LegalAiService legalAiService;

    @Test
    void deveGerarRespostaComLlama() {

        String pergunta = "Quais são meus direitos básicos como consumidor?";

        String resposta = legalAiService.generateAnswer(pergunta);

        System.out.println("\n==============================");
        System.out.println("PERGUNTA:");
        System.out.println(pergunta);

        System.out.println("\nRESPOSTA DO LLAMA 3:");
        System.out.println(resposta);

        System.out.println("==============================\n");
    }
}