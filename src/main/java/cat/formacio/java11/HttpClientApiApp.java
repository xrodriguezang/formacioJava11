package cat.formacio.java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientApiApp {

    public static void main(String[] args) throws IOException {

        HttpClientApiApp httpClientApiApp = new HttpClientApiApp();

        httpClientApiApp.testHttpClient();

    }

    private void testHttpClient() throws IOException {

        final var uri = "https://www.boredapi.com/api/activity";

        var url = new URL(uri);

        var httpUrlConnection = (HttpURLConnection) url.openConnection();

        httpUrlConnection.setRequestMethod("GET");

        if (httpUrlConnection.getResponseCode() == HttpURLConnection.HTTP_OK ) {
            System.out.println(readResponse(httpUrlConnection.getInputStream()));
        } else {
            System.out.println("Alguna cosa ha anat malament!");
        }
    }

    private static String readResponse(InputStream inputStream) throws IOException {
        var content = new StringBuilder();
        var line = "";

        try (var bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
        }

        return content.toString();
    }


}
