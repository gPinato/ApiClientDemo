import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Map;

public class ApiClient {

    private String baseUrl;
    private HttpClient client;
    private Map<String, String> customHeaders;

    ApiClient(String baseUrl, HttpClient client, Map<String, String> customHeaders) {
        this.baseUrl = baseUrl;
        this.client = client;
        this.customHeaders = customHeaders;
    }

    public HttpResponse post(String path, String body) throws IOException {
        HttpUriRequest request = RequestBuilder.post(baseUrl + path)
                .setEntity(new StringEntity(body, ContentType.APPLICATION_JSON))
                .build();

        injectHeaders(request);
        return client.execute(request);
    }

    public HttpResponse get(String path) throws IOException {
        HttpUriRequest request = RequestBuilder.get(baseUrl + path)
                .build();

        injectHeaders(request);
        return client.execute(request);
    }


    private void injectHeaders(HttpRequest request) {
        request.addHeader("one", "two");
        customHeaders.forEach(request::addHeader);
    }
}
