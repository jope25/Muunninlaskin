package fi.jope.logiikka;

public class ASCIIMuuntaja {

    /**
     * Metodi muuntaa annettavan merkkijonon ASCII numeroina.
     *
     * @param merkkijono Merkkijono, joka halutaan muuntaa
     * @return ASCII numero
     */
    public String merkkiToASCII(String merkkijono) {
        String ascii = "";
        for (int i = 0; i < merkkijono.length(); i++) {
            char c = merkkijono.charAt(i);
            int merkkiNumerona = (int) c;
            if (i == merkkijono.length() - 1) {
                ascii += merkkiNumerona;
            } else {
                ascii += merkkiNumerona + " ";
            }
        }
        return ascii;
    }

    /**
     * Metodi muuntaa ASCII numeron merkkijonoksi. Jos numero on virheellinen,
     * metodi palauttaa virheilmoituksen.
     *
     * @param ascii Muunnettava ASCII numero
     * @return numero muunnettu merkkijonoksi
     */
    public String ASCIIToMerkki(String ascii) {
        String sana = "";
        if (!tarkistaASCII(ascii)) {
            return "Virhe: virheellinen ASCII";
        }
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
            int asciiNumero = Integer.parseInt("" + eka + toka);
            if ((asciiNumero >= 48 && asciiNumero <= 57)
                    || (asciiNumero >= 65 && asciiNumero <= 90)
                    || (asciiNumero >= 97 && asciiNumero <= 99)) {
                sana += Character.toString((char) asciiNumero);
            } else if (i == ascii.length() - 1) {
                return "Virhe: virheellinen ASCII";
            } else if (asciiNumero >= 10 && asciiNumero <= 12) {
                i++;
                char kolmas = ascii.charAt(i);
                asciiNumero = Integer.parseInt("" + eka + toka + kolmas);
                sana += Character.toString((char) asciiNumero);
            }
        }
        return sana;
    }

    private boolean tarkistaASCII(String ascii) {
        for (int i = 0; i < ascii.length(); i++) {
            char c = ascii.charAt(i);
            boolean b = false;
            for (int j = 48; j <= 57; j++) {
                if (c == j) {
                    b = true;
                }
            }
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
