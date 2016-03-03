package fi.jope.logiikka;

public class ASCIIMuuntaja {

    public String kirjaimistaASCII(String sana) {
        String ascii = "";
        for (int i = 0; i < sana.length(); i++) {
            char c = sana.charAt(i);
            int merkkiNumerona = (int) c;
            if (i == sana.length() - 1) {
                ascii += merkkiNumerona;
            } else {
                ascii += merkkiNumerona + " ";
            }
        }
        return ascii;
    }

    public String ASCIIstaKirjaimet(String ascii) {
        String sana = "";
        for (int i = 0; i < ascii.length(); i++) {
            char eka = ascii.charAt(i);
            if (eka == '0') {
                return "Virhe: ethän laita turhia etunollia";
            }
            i++;
            if (i == ascii.length()) {
                return "Virhe: virheellinen ASCII";
            }
            char toka = ascii.charAt(i);
            int numero = Integer.parseInt("" + eka + toka);
            if ((numero >= 48 && numero <= 57)
                    || (numero >= 65 && numero <= 90)
                    || (numero >= 97 && numero <= 99)) {
                sana += Character.toString((char) numero);
            } else if (numero >= 10 && numero <= 12) {
                i++;
                char kolmas = ascii.charAt(i);
                numero = Integer.parseInt("" + eka + toka + kolmas);
                sana += Character.toString((char) numero);
            }
        }
        return sana;
    }
    
    private boolean tarkistaASCII(String ascii) {
        
        return true;
    }
    
    private boolean tarkistaSana(String sana) {
        
        return true;
    }
}
