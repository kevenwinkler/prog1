import java.util.Scanner;

public class DateDifference {
    /**
        Die Klasse DateDifference gibt die Anzahl der Tage zwischen zwei in der Konsole eingegebenr Daten aus.
        @author Keven Winkler, Martikel-Nr.: 4434993, Gruppe 2c
    */

    public static void main(String[] args) {
    /**
        @param day1, day2, month1, month2, year1, year2 erfassen die eingegebenen Daten
        @param insert1, insert2 speichern die Eingaben als String, um Sie auf "/" zu untersuchen
     */

        int day1, day2, month1, month2, year1, year2; 
 
        System.out.print("Geben Sie das erste Datum ein:\t");
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("[\\s.\\-/]+");  // Nutzen der useDelimiter-Methode um Eingabe zu filtern, falls Datum anders eingegeben wird: 22.01.2013; 22-01-2013; etc.

        day1 = scan.nextInt();             // day1 nimmt den Wert des ersten Integer-Wertes an
        month1 = scan.nextInt();           // month1 nimmt den Wert des zweiten Integer-Wertes an
        year1 = scan.nextInt();            // year1 nimmt den Wert des dritten Integer-Wertes an

        System.out.print("Geben Sie das zweite Datum ein:\t");

        day2 = scan.nextInt();             // day2 nimmt den Wert des ersten Integer-Wertes an
        month2 = scan.nextInt();           // month2 nimmt den Wert des zweiten Integer-Wertes an
        year2 = scan.nextInt();            // year2 nimmt den Wert des dritten Integer-Wertes an
  
        scan.close(); // Eingabe schlie�en; hier optional
        int diff = calculateDays(year2, month2, day2) - calculateDays(year1, month1, day1); // subtrahiert die Tage des ersten Datums von den Tagen des zweiten Datums
        System.out.println("Tage: " + Math.abs(diff)); // gibt das Ergebnis als Betrag aus, um negatives Ergebnis zu vermeiden
    }

    public static int calculateDays(int year, int month, int day) {
    /**
        Die Methode calculateDays kalkuliert die Anzahl der Tage bis zum �bergebenen Datum.

        @param dayTillMonth ist ein integer array, dass der Berechnung der vergangenen Tagen zwischen den Monaten dient.
        @return Es wird die Anzahl der Tage unter Beruecksichtigung der Schaltjahre bis zum �bergebenen Datum zurueckgegeben.
    */

        int[] dayTillMonth = {0, 31, 61, 92, 122, 153, 184, 214, 245, 275, 306, 337}; // Speichert die Anzahl der Tage vom 1. M�rz bis zum 1. Tag des uebergebenen Monats; bspw. vom 1.3. bis 1.4. = 31 Tage, etc. 

        if (month < 3) {  // Wenn der uebergebene Monat ein Januar oder ein Februar ist ...
            month += 9;  // ... addiere 9 Monate zu dem Monat, sodass der Januar der 10. Monat und Februar der 11. Monat waere ...
            year -= 1;   // ... verringer ausserdem das Jahr um 1; jetzt ist Februar der letzte Monat des Jahres, was das Rechnen mit Schaltjahren vereinfacht
        } else {         // Wenn der uebergebene Monat zwischen Maerz und Dezember liegt ...
            month -= 3;  // ... ziehe drei Monate ab; dann ist Maerz der 0. Monat und Dezember der 9. Monat
        }
        /*
           "return" gibt Anzahl der Tage wieder bis zum uebergebenen Datum wieder: 
           Alle Tage bis zum Ende letzten Jahres bzw. uebergebenes Jahr - 1 (year * 365) + Schaltjahre (year/4 - year/100 + year/400) 
           + Tage seit Anfang des Jahres bis zum uebergebenen Monat (dayTillMonth[month]) + uebergebenen Monatstag
        */
        return year * 365 + year / 4 - year / 100 + year / 400 + dayTillMonth[month] + day; 
    }	
}