/**
 * Die Klasse Funktion beinhaltet die abstraken Methoden zur Errechnung der Nullstellen 
 * und Erstellung der Funktionsdurchlauf-Tabellen. �ber die main-Methode wird das Programm gestartet,
 * die Konstruktoren erzeugt und die Rechenparameter �bergeben.
 * 
 * @author Keven Winkler 4434993 Gruppe 2c
 * 
*/
public abstract class Funktion {
    /**
     * @param args wird nicht verwendet
     */
    double x, eps, xmax;
    int i = 0;
    abstract double f();
    abstract double g();
    abstract double e();
    static Funktion[] rechnen = new Funktion[10];
    
    public void tabelle() {
        System.out.println();
        System.out.println("WERTETABELLE");
        do {
            double var1 = this.f();
            System.out.printf("x:%5.1f", this.x);
            System.out.printf("  |  y:%9.3f\n", var1);
            this.x = this.x + this.e(); 
        } 
        while (this.x <= this.xmax);
    }
    
    public void newton(double s) {
        this.x = s;
        System.out.println();
        System.out.println("Startwert: " + this.x);
        do {
            this.x = this.x - this.f() / this.g();
            System.out.printf("x:%12.8f", this.x);
            System.out.printf("  |  y:%12.8f\n", this.f());
            this.i++;
            if (this.i == 25) {
                System.out.println("max. Iterationsanzahl erreicht, keine Loesung gefunden!");
                return;
            }
        }
        while (Math.abs(this.f()) > this.eps && this.i < 25);
        System.out.println("Eine Nullstelle ist naeherungsweise: " + this.x);
    } 
    
    public static void main(String[] args) {
        // Tabelle/Parabel (x-Wert[= Startwert], maximaler x-Wert, eps, a, b, c, d)
        rechnen[0] = new Tabelle(1.0 , 0 , 0.00000001 , 2 , -20 , -6, 30);
        rechnen[0].newton(1.0);
        rechnen[1] = new Tabelle(-2.0 , 12.0 , 0.1 , 2.0 , -20.0 , -6.0, 30.0);
        rechnen[1].tabelle();
        rechnen[2] = new Parabel(0.5 , 0 , 0.00000001 , 1.0 , 3.0 , -5.0);
        rechnen[2].newton(0.5);
        rechnen[3] = new Parabel(0.5 , 12.0 , 0.1 , 1.0 , 3.0 , -5.0);
        rechnen[3].tabelle();
        /* 
         * Wertetabelle hat einen Vorzeichenwechsel bei -1.3 auf -1.2 -> Nullstelle
           Wertetabelle hat einen Vorzeichenwechsel bei 1.1 auf 1.2 -> Nullstelle
           Wertetabelle hat einen Vorzeichenwechsel bei 10.1 auf 10.2 -> Nullstelle 
         */
        rechnen[4] = new Tabelle(-2 , 0 , 0.00000001 , 2 , -20 , -6, 30);
        rechnen[4].newton(-2);
        rechnen[5] = new Tabelle(1 , 0 , 0.00000001 , 2 , -20 , -6, 30);
        rechnen[5].newton(1);
        rechnen[6] = new Tabelle(50 , 0 , 0.00000001 , 2 , -20 , -6, 30);
        rechnen[6].newton(50);
    } 
}
/**
 * Die Konstruktor-Klasse Parabel mit f(x) = ax� + bx + c
 * 
*/
class Parabel extends Funktion {
    double a, b, c;
    public Parabel(double x, double xmax, double eps, double a, double b, double c) {
        this.x = x;
        this.xmax = xmax;
        this.eps = eps;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double f() {
        return this.a * x * x + this.b * x + this.c; 
    }
    public double g() {
        return 2 * this.a * x + this.b; 
    }
    public double e() {
        return eps;
    }
}
/**
 * Die Konstruktor-Klasse Tabelle mit f(x) = ax� + bx� + cx + d
 * 
*/
class Tabelle extends Funktion {
    double a, b, c, d;
    Tabelle(double x, double xmax, double eps, double a, double b, double c, double d) {
        this.x = x;
        this.xmax = xmax;
        this.eps = eps;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public double f() {
        return this.a * x * x * x + this.b * x * x + this.c * x + this.d;
    }
    public double g() {
        return this.a * 3 * x * x + this.b * 2 * x + this.c;
    }
    public double e() {
    	return eps;
    }
}

