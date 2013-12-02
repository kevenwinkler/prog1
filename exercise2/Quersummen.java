import java.util.Scanner;
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
	 * @param altquersumme1, altquersumm2, altquersumm3 beinhalten die errechneten Alternierenden Quersummen 
	 * @param i ist ein Schleifenzaehler
	 */
	public static void main(String[] args) {

		int zahl1, zahl2, zahl3;
		int quersumme1 = 0, quersumme2 = 0, quersumme3 = 0;
		int altquersumme1 = 0, altquersumme2 = 0, altquersumme3 = 0;
		int i = 1;
			
		if (args.length > 0) {
			zahl1 = Integer.parseInt(args[0]);
		} else {
			System.out.println("Bitte geben Sie eine natuerliche Zahl ein:");
			Scanner scan = new Scanner(System.in);
			zahl1 = Integer.parseInt(scan.next());
			scan.close();
		} 
		zahl2 = zahl1;
		zahl3 = zahl1;
		
		while (zahl1 > 0) {
		    if (i%2 == 0) {
	                altquersumme1 += zahl1%10;
			altquersumme2 += zahl2%100;
			altquersumme3 += zahl3%1000;
			i++;
		    } else {
			altquersumme1 -= zahl1%10;
			altquersumme2 -= zahl2%100;
			altquersumme3 -= zahl3%1000;
			i++;
	            }
		    quersumme1 += zahl1%10;
		    quersumme2 += zahl2%100;
		    quersumme3 += zahl3%1000;
		    zahl1=zahl1/10;
		    zahl2=zahl2/100;
		    zahl3=zahl3/1000;
		}
		System.out.println("Quersumme erster Stufe: \t\t" + quersumme1);
		System.out.println("Alternierende Quersumme erster Stufe: \t" + altquersumme1);
		System.out.println("Quersumme zweiter Stufe:\t\t" + quersumme2);
		System.out.println("Alternierende Quersumme zweiter Stufe:\t" + altquersumme2);
		System.out.println("Quersumme dritter Stufe:\t\t" + quersumme3);
		System.out.println("Alternierende Quersumme dritter Stufe:\t" + altquersumme3);
	}
}
