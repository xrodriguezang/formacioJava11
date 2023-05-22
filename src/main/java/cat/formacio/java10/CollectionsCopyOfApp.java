package cat.formacio.java10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsCopyOfApp {

    public static void main(String[] args) {

        CollectionsCopyOfApp collectionsCopyOfApp = new CollectionsCopyOfApp();

        collectionsCopyOfApp.llistaCollections();

    }

    private void llistaCollections () {

        List<String> llista = new ArrayList<>();

        llista.add("1");
        llista.add("2");

        // Utilitzant una llista inmodificable
        List<String> llistaUn = Collections.unmodifiableList(llista);

        // Utilitzant copyOf
        List<String> llistaCopy = List.copyOf(llista);


        //llistaUn.add("3"); // Això no ho deixa fer.
        llista.add("3");

        System.out.println(llista);
        System.out.println(llistaUn);
        System.out.println(llistaCopy);
    }

}
