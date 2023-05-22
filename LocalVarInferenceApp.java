package cat.formacio.java10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class LocalVarInferenceApp {

    // var ddd; // No permet posar var aquí. Només a dins de mètodes.

    public static void main(String[] args) {

    }

    private void inferenciaVaraibles () {
        Predicate<String> nom = (String s) -> s.length() < 10;

        // Per inferència ja sap que és un String
        Predicate<String> nom2 = s -> s.length() < 10;

        // Això només per a variables locals (només)
        var nomVar = 0;  // Infereix el tipus al var
        nomVar += 1;
    }

    private void inferenciaVaraiblesEnLiterals () throws IOException {
        var esVermell = "true";

        // byte signal = 0;
        var signal = 0;  // Compte -> És un enter

        var signal2 = Byte.valueOf("0");

        int[] numeros = {1, 2};


        for (var i : numeros) {
            System.out.println(i);  // Aquí la veritat que dificulta més la lectura del codi.
        }

        Map<String, List<String>> pelicules = new HashMap<>();

        pelicules.put("COMEDIA", List.of("Comedia1", "comedia2"));
        pelicules.put("ACCIÓ", List.of("Acció1", "Acció2"));

        for (Map.Entry<String, List<String>> entry : pelicules.entrySet()) {
            String genere = entry.getKey();
            List<String> pelis = entry.getValue();
        }

        // Per abreviar i millorar la visibilitat. Si no, no té sentit.
        for (var entry : pelicules.entrySet()) {
            String genere = entry.getKey();
            List<String> pelis = entry.getValue();

        }

        var mevesPelis = new HashSet<String>();

        mevesPelis.add("pelis");

        // Entry with resources
        try (var linies = Files.lines(Paths.get("RUTA"))) {
            System.out.println(linies.count());
        }
    }


    // No es pot posar var com a pas de paràmetres.
        /*
                void prova (var n) {

                }
        */

}
