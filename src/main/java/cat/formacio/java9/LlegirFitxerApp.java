package cat.formacio.java9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LlegirFitxerApp {

    public static void main(String[] args) throws IOException {
        List<String> resultat;

        Predicate<String> noConteAlmoaida = l -> !l.contains("#");

        try (Stream<String> linies = Files.lines(Paths.get("src/main/resources/data.txt"))) {
            resultat = linies
                    .dropWhile(noConteAlmoaida)
                    .skip(1)
                    .takeWhile(noConteAlmoaida)
                    .collect(Collectors.toList());
        }

        System.out.println(resultat);
    }
}
