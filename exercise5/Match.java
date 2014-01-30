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
	}
	
	public static boolean match(String p, String s ) {
		return false;
	}
}