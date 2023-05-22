package cat.formacio.java11;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class NewHttpClientApiApp {

    public static void main(String[] args) throws IOException, InterruptedException {

        NewHttpClientApiApp newHttpClientApiApp = new NewHttpClientApiApp();

        newHttpClientApiApp.httpClientTest();

    }

    private void httpClientTest () throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder().build();

        Map<String, String> dades = new HashMap<>();

        dades.put("username", "abc");
        dades.put("password", "123");

        HttpRequest request = HttpRequest.newBuilder()
                            .POST(offFormData(dades))
                            .uri(URI.create("https://httpbin.org/post"))
                            .header("Content-Type", "application/x-www-form-urlencoded")
                            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

    }

    public static HttpRequest.BodyPublisher offFormData (Map <String, String> data) {
        var builder = new StringBuilder();

        for (var entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
                builder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
                builder.append("=");
                builder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            }
        }

        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

}
