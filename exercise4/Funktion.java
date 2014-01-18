// import java.util.Scanner;

public abstract class Funktion {

	/**
	 * @param args
	 */
	double xmin, xmax, abstand;
	public abstract double f(double x);
	public abstract double g(double x);
	public void tabelle () {
		
		for (double x = xmin; x <= xmax; x = x + abstand) {
			System.out.println("f(" + java.lang.Math.round( x * 100 ) / 100. + ") = " + f(x));
			}
		} 

	public void newton (double s) { 	}
}

class Parabel extends Funktion {
	
	int a, b, c;
	double xmin, xmax, abstand;
	
	public double f(double x) {
		//return x*x*a+b*x+c;
		return x*x*x*a + b*x*x + c*x + 30;
	}
	
	public double g(double x) {
		return 2*a*x+b;
	}
	
	Parabel(double xmin,double xmax,double abstand, int a, int b, int c) {
		// Funktion.xmin = this.xmin;
		this.xmin = xmin;
		this.xmax = xmax;
		this.abstand = abstand;
		this.a = a;
		this.b = b;
		this.c = c;
		/*Funktion.xmin = this.xmin;
		Funktion.xmax = this.xmax;
		Funktion.abstand = this.abstand;*/
	}
	
	public static void main(String[] args) {
		
		Parabel para = new Parabel(1.0,2.0,0.1,2,-20,-6);
		para.tabelle();

	}
}


