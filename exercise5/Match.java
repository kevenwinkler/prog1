/**
 * Die Klasse Match vergleicht zwei uebergebene Zahlenwerte von 0 bis 9.
 * 
 * 
  @author Keven Winkler 4434993 Gruppe 2c
*/
public class Match {
    /**
    @param args benoetigt zwei Zahlen-Werte als Strings; d.h. im Falle eines Jokers Anfuehrungszeichen benutzen
    */
    public static void main(String[] args) {
        String p, s, joker = "*";
        boolean value = false;
        /**
        if-Anweisung ueberprueft, ob zwei Argumente eingegeben worden
        */
        if (args.length == 2) {
            p = args[0];
            s = args[1];
        } else {
            System.out.println("Bitte zwei Argumente eingeben! Es sollte sich dabei um Strings handeln!");
            returnMatch(value);
            return;
        }
        /**
        if-Anweisung ueberprueft, ob beide Argumente leer sind
        */
        if (p.length() == 0 && s.length() == 0) {
            value = true;
            returnMatch(value); // Hilfsmethode aufrufen, die lediglich den value zurueckgibt
            return;
        } else {
            for (int t = 0; t < args.length; t++) { // Beide Argumente durchgehen
                for (int h = 0; h < args[t].length(); h++) {
                    // Joker fuer p abfangen -> keine Zahl aber gueltiges Element
                    if (args[t].substring(h, h + 1).equals(joker) && t == 0) { 
                        continue;
                    } else {
                        // Nur Integer erlauben!
                        try { 
                            Integer.parseInt(args[t].substring(h, h + 1)); 
                        } catch (IllegalArgumentException e1) { // Fehlerbehandlung und Abbruch!
                            System.out.println("IllegalArgumentException: " + e1.toString());
                            System.out.println("'" + args[t] + "'" + " ist kein Integer");
                            returnMatch(value);
                            return;
                        }
                    }
                }
            }
            match(p, s); // match-Methode aufrufen
        }
    }
    /**
     * returnMatch ist eine Hilfsklasse, die true oder false ausgibt
     * 
      @param value ist true oder false
      @return gibt true oder false aus
    */
    public static boolean returnMatch(boolean value) {
        System.out.println("----");
        System.out.println(value);
        System.out.println("----");
        return value;
    }
    /**
      Die Methode match vergleicht die uebergebenen Argumente
      
      @param p ist der erste uebergebene Wert
      @param s ist der zweite uebergebene Wert
    */
    public static boolean match(String p, String s) {
        boolean value = false;
        int t = 0;
        int v = 0;
        int star = 0;
        int maxlength = Math.max(p.length(), s.length());
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                star++;
            }
        }
        // Sonderfaelle behandeln!
        if (p.length() < s.length() && star == 0) {
            return returnMatch(value);
        }
        if (p.length() - star > s.length()) {
            return returnMatch(value);
        }
        // Array anlegen, welches nur die Zahl 1 enthaelt
        int[] intArray = new int[maxlength];
        for (int z = 0; z < maxlength; z++) {
            intArray[z] = 1;
        }
        while (true) {
            //System.out.print("D " + v + ": ");
            try {
                if (p.substring(v, v + 1).equals(s.substring(t, t + 1))) {
                    //System.out.println("Vergleiche String: " + p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
                    intArray[t] = 1;
                    //System.out.println("Ergebnis: "+ intArray[t]);
                    t++;
                    v++;
                    continue;
                } else if (p.charAt(v) == '*') {
                    //System.out.println("Vergleiche String: Joker mit " + s.substring(t,t+1) );
                    intArray[t] = 1;
                    //System.out.println("Ergebnis: "+ intArray[t]);
                    while (p.charAt(v) == '*') {
                        v++;
                        //System.out.println("Do String: " + p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
                    }
                    while (!(p.substring(v, v + 1).equals(s.substring(t, t + 1)))) {
                        t++;
                        //System.out.println("Do String: " + p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
                    }
                } else {
                    //System.out.println("Vergleiche String: "+ p.substring(v,v+1)+ " und " + s.substring(t,t+1) );
                    intArray[t] = 0;
                    //System.out.println("Ergebnis: " + intArray[t]);
                    t++;
                    v++;
                    continue;
                }
            } catch (StringIndexOutOfBoundsException e2) {
                //System.out.println("IndexOutOfBoundsException:" + e2.toString());
                break;
            }
        }
        for (int z = 0; z < maxlength; z++) {
            if (intArray[z] == 0) {
                value = false;
                break;
            } else {
                value = true;
                continue;
            }
        }
        return returnMatch(value);
    }
}
