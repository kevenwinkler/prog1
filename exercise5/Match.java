public class Match {
	public static void main(String[] args) {
		String p;
		String s;
		String joker = "*";
		// Pruefen, ob zwei Argumente eingegeben wurden
		if (args.length == 2) {
			p = args[0];
			s = args[1];
		} else {
			System.out.println("Bitte 2 Argumente eingeben!");
			return;
		}
		int i;
		for (int t = 0; t < args.length; t++) { // Beide Argumente durchgehen
			for (int h = 0; h < args[t].length(); h++) {
				if (args[t].substring(h,h+1).equals(joker) && t == 0) { // Joker für p abfangen -> keine Zahl aber gueltiges Element
					continue;
				} else
					try {
						Integer.parseInt(args[t].substring(h,h+1)); // Nur Integer erlauben!
					}
					catch (IllegalArgumentException ex) { // Fehlerbehandlung und Abbruch!
			    		System.out.println(args[t] + " ist kein Integer");
			    		return;
					}
			}
		}
		match(p,s);
	}
	
	public static boolean match(String p, String s) {
		boolean value = false;
		int t = 0;
		int v = 0;
		int stern = 0;
		int diff = p.length()-s.length();
		//System.out.println(diff);
		int laenge = Math.max(p.length(),s.length());
		//System.out.println("max. Laenge: "+ laenge);
		for (int i=0; i < p.length(); i++) {
			if (p.charAt(i) == '*') {
				stern++;
			}
		}
		// Array anlegen, welches nur die Zahl 1 enthält
		int[] intArray = new int[laenge]; 
		for (int z = 0; z < laenge; z++) {
			intArray[z] = 1;
		}
		if (p.length()-stern > s.length()) {
			System.out.println(value);
			return value;
		}
		System.out.println("----");
		while (t < 500) {
			System.out.print("D " + v + ": ");
			try {
				if (p.substring(v,v+1).equals(s.substring(t,t+1))) {
					System.out.println("Vergleiche String: " + p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
					intArray[t] = 1;
					System.out.println("Ergebnis: "+ intArray[t]);
					t++;
					v++;
					continue;
				} else if (p.charAt(v) == '*') {
					System.out.println("Vergleiche String: Joker mit " + s.substring(t,t+1) );
					intArray[t] = 1;
					System.out.println("Ergebnis: "+ intArray[t]);
					while (p.charAt(v) == '*') {
						v++;
						System.out.println("Do String: " + p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
					} 
					while (!(p.substring(v,v+1).equals(s.substring(t,t+1)))) {
						t++;
						System.out.println("Do String: " + p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
					}
				} else {
					System.out.println("Vergleiche String: "+ p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
					intArray[t] = 0;
					System.out.println("Ergebnis: " + intArray[t]);
					t++;
					v++;
					continue;
				}
			}
			catch (StringIndexOutOfBoundsException ex) {
				System.out.println("IndexOutOfBounds!");
				break;
			}
		}
		for (int z = 0; z < laenge; z++) {
			if (intArray[z] == 0) {
				value = false;
				break;
			} else {
				value = true;
				continue;
			}
		}
	System.out.println("----");
	System.out.println(value);
	return value;
	}
}