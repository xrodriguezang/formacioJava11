package cat.formacio.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientAsyncApp {

    public static void main(String[] args) {
        HttpClientAsyncApp httpClientAsyncApp = new HttpClientAsyncApp();

        httpClientAsyncApp.provaAsincrona();

    }

    private void provaAsincrona () {

        final var uri = "https://www.boredapi.com/api/activity";

        var httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        var request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        // Es podria deixar en un -var-, però així s'entén molt millor: var futureResult  ...
        CompletableFuture<HttpResponse<String>> futureResult = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Aquest futur, quan estigui fet, llavors en recupero el body (que és un String)
        // Aquí s'està esperant la resposta
        futureResult.thenApply(HttpResponse::body)
                .exceptionally(ex -> "Ops, alguna cosa ha anat malament")  // Si algo va malament
                .thenAccept(System.out::println);                          // Si tot va bé.

        System.out.println("Prova asíncrona");

        // Aquí es retorna el valor del resultat quan està complet
        // HttpResponse response = futureResult.join();
        var response = futureResult.join();  // preguntarà pel future per si ja ha acabat. Té un conjunt d'estats. És queda aquí preguntant.

        System.out.println("Prova asíncrona - ???");

    }
}
