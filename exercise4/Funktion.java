/**
 * @author  Keven Winkler 4434993 Gruppe 2c
 * 
*/
public abstract class Funktion {
    double x;
    double eps;
    int i = 0;
    abstract double f();
    abstract double g();
    abstract double t();
    static Funktion[] test123 = new Funktion[10];
    /**
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        test123[0] = new Newton(1.0 , 0.00000001 );
        test123[0].newton();
        test123[1] = new Tabelle(-2.0 , 0.1 , 2.0 , -20.0 , -6.0, 30.0);
        test123[1].tabelle();
        test123[2] = new Parabel(0.5 , 0.00000001 , 1.0 , 3.0 , -5.0);
        test123[3] = new ParabelTabelle(0.5 , 0.1 , 1.0 , 3.0 , -5.0);
        test123[2].newton();
        test123[3].tabelle();
        // Wertetabelle hat einen Vorzeichenwechsel bei -1.3 auf -1.2 -> Nullstelle
        // Wertetabelle hat einen Vorzeichenwechsel bei 1.1 auf 1.2 -> Nullstelle
        // Wertetabelle hat einen Vorzeichenwechsel bei 10.1 auf 10.2 -> Nullstelle
        test123[4] = new Newton(-2 , 0.00000001);
        test123[5] = new Newton(1 , 0.00000001);
        test123[6] = new Newton(50 , 0.00000001);
        test123[4].newton();
        test123[5].newton();
        test123[6].newton();
    }
    public void newton() {
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
    public void tabelle() {
        System.out.println();
        System.out.println("WERTETABELLE");
        do {
            double var1 = this.f();
            System.out.printf("x:%5.1f", this.x);
            System.out.printf("  |  y:%9.3f\n", var1);
            this.x = this.x + this.t();
            this.i++;
        } 
        while (this.i <= 130);
    }
}
class Newton extends Funktion {
    public Newton(double x, double eps) {
        this.x = x;
        this.eps = eps;
    }
    public double f() {
        return 2 * x * x * x - 20 * x * x - 6 * x + 30; 
    }
    public double g() {
        return 6 * x * x - 40 * x - 6; 
    }
    public double t() {
        return x; 
    }
}
class Parabel extends Funktion {
    double a;
    double b;
    double c;
    public Parabel(double x, double eps, double a, double b, double c) {
        this.x = x;
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
    public double t() {
        return x; 
    }
}
class Tabelle extends Funktion {
    double a;
    double b;
    double c;
    double d;
    Tabelle(double x, double eps, double a, double b, double c, double d) {
        this.x = x;
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
        return x; 
    }
    public double t() {
        return eps;
    }
}
class ParabelTabelle extends Funktion {
    double a;
    double b;
    double c;
    double d;
    ParabelTabelle(double x, double eps, double a, double b, double c) {
        this.x = x;
        this.eps = eps;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double f() {
        return this.a * x * x + this.b * x + this.c;
    }
    public double g() {
        return x; 
    }
    public double t() {
        return eps; 
    }
}
