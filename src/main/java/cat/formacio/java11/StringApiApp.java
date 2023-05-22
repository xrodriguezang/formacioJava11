package cat.formacio.java11;

public class StringApiApp {

    public static void main(String[] args) {

        StringApiApp stringApiApp = new StringApiApp();

        stringApiApp.provaString();
        stringApiApp.provaString2();

    }

    private void provaString() {
        System.out.println("Hash: " + "#".repeat(5));
        System.out.println("     ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println("     ".trim().isBlank());
        System.out.println("".equals("     ".trim()));
        System.out.println("    ".isBlank());  // Si és empty o només conté espais en blanc.
    }

    private void provaString2() {
        System.out.println(Character.isWhitespace('\u2001'));
        System.out.println("|" + "    Hello   \u2001".trim() + "|");  // No netega el \u2001.
        System.out.println("|" + "    Hello   \u2001".strip() + "|");  // Aquest sí ho fa bé.
        var multiplesLinies = "\nHola,"  + "\nquè" +  "\ntal" + "\nestàs?";

        // multiplesLinies.split("\\R"); // En Java8
        multiplesLinies.lines().forEach(System.out::println);

    }

}
