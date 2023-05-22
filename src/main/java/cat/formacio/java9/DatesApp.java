package cat.formacio.java9;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class DatesApp {

    public static void main(String[] args) {
        DatesApp exercicisApp = new DatesApp();

        exercicisApp.contarDiesEntreDuesDates();
        exercicisApp.anysTraspasDesDe1900();


    }

    /**
     *  Contar dies des d'avui fins al dia 2025-09-12
     */
    private void contarDiesEntreDuesDates () {
        LocalDate dataFi = LocalDate.of(2025, 9, 13);
        LocalDate avui = LocalDate.now();

        long numDias = avui.datesUntil(dataFi).count();

        System.out.println("numDias: " + numDias);
    }


    /**
     * Quants anys bisiestos hi han des d'avui fins a 1900.
      */
    private void anysTraspasDesDe1900 () {
        LocalDate avui = LocalDate.now();
        LocalDate mil900 = LocalDate.ofYearDay(1900,1);

        long totalTraspas = mil900
                .datesUntil(avui, Period.ofYears(1))
                .mapToInt(LocalDate::getYear)
                .filter(Year::isLeap)  // is Leap -> any de traspàs.
                .count();

        System.out.println("totalTraspas: " + totalTraspas);
    }

    /**
     * Quants anys bisiestos hi han des d'avui fins a 1900.
     */
    private void anysTraspasDesDe1900_2 () {
        LocalDate avui = LocalDate.now();
        LocalDate mil900 = LocalDate.ofYearDay(1900,1);

        long totalTraspas = mil900
                .datesUntil(avui, Period.ofYears(1))
                .filter(( d -> {
                    return Year.isLeap(d.getYear());
                }))
                .count();

        System.out.println("totalTraspas: " + totalTraspas);
    }

}
