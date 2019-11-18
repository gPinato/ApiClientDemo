import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.Map;

public class ClientFactory {

    private static ClientFactory instance;

    private HttpClient client;

    private ClientFactory() {
        this.client = HttpClientBuilder.create().build();
    }

    public static ClientFactory getInstance() {
        if (instance == null) {
            instance = new ClientFactory();
        }

        return instance;
    }


    public ApiClient create(String baseUrl, Map<String, String> customHeaders) {
        return new ApiClient(baseUrl, client, customHeaders);
    }
}
