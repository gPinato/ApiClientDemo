import java.io.IOException;
import java.util.Map;

public class Streamer {

    private ApiClient consolidationClient;
    private ApiClient enrichmentClient;

    public Streamer() {
        ClientFactory factory = ClientFactory.getInstance();

        consolidationClient = factory.create("http://consolidation.net/", Map.of("consolidation", "header"));
        enrichmentClient = factory.create("http://consolidation.net/", Map.of("enrichment", "header"));

    }

    public void stream() throws IOException {
        consolidationClient.post("/consolidate", "myPayload");
    }
}
