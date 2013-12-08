/**
   Die Klasse Quersummen errechnet die Quersummen und die Alternierende Quersummen 1. bis 3. Ordnung,
   der uebergebenen Zahl aus.

   @author Keven Winkler, Martikel-Nr.: 4434993, Gruppe 2c
*/
public class Quersummen {
    /**
    * @param args erfasst die uebergebene Zahl
    * @param zahl1, zahl2, zahl3 beinhalten die uebergebene Zahl als Integer-Wert
    * @param quersumme1, quersumme2, quersumme3 beinhalten die errechneten Quersummen 
    * @param altQuersumme1, altQuersumme2, altQuersumme3 beinhalten die errechneten Alternierenden Quersummen 
    * @param i ist ein Zaehler fuer die if-Anweisung
    */
    public static void main(String[] args) {

        int zahl1 = Integer.parseInt(args[0]), zahl2 = zahl1, zahl3 = zahl1;
        int quersumme1 = 0, quersumme2 = 0, quersumme3 = 0;
        int altQuersumme1 = 0, altQuersumme2 = 0, altQuersumme3 = 0;
        int i = 0;

        while (zahl1 > 0) {
            if (i % 2 == 0) {
                altQuersumme1 += zahl1 % 10;
                altQuersumme2 += zahl2 % 100;
                altQuersumme3 += zahl3 % 1000;
                i++;
            } else {
                altQuersumme1 -= zahl1 % 10;
                altQuersumme2 -= zahl2 % 100;
                altQuersumme3 -= zahl3 % 1000;
                i++;
            }
            quersumme1 += zahl1 % 10;
            quersumme2 += zahl2 % 100;
            quersumme3 += zahl3 % 1000;
            zahl1 = zahl1 / 10;
            zahl2 = zahl2 / 100;
            zahl3 = zahl3 / 1000;
        }

        System.out.println("\t\tQuersumme erster Stufe: \t" + quersumme1);
        System.out.println("  Alternierende Quersumme erster Stufe: \t" + altQuersumme1);
        System.out.println("\t\tQuersumme zweiter Stufe:\t" + quersumme2);
        System.out.println("  Alternierende Quersumme zweiter Stufe:\t" + altQuersumme2);
        System.out.println("\t\tQuersumme dritter Stufe:\t" + quersumme3);
        System.out.println("  Alternierende Quersumme dritter Stufe:\t" + altQuersumme3);
    }
}
