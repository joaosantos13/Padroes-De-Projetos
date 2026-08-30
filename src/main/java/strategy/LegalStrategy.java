package strategy;

import java.util.List;

public interface LegalStrategy {
    boolean supports(String query);
    List<String> retrieveContext(String query);
}