/**
 * Luokka muuntaa saadun ASCII-luvun merkkijonoksi tai toisinpäin.
 */
package fi.jope.logiikka;

public class ASCIIMuuntaja extends Muunnin {

    /**
     * Metodi muuntaa annettavan merkkijonon ASCII numeroina.
     *
     * @param merkkijono Merkkijono, joka halutaan muuntaa
     * @return ASCII numero
     */
    public String merkkiToASCII(String merkkijono) {
        if (!tarkistaMerkkijono(merkkijono)) {
            return "Virhe: virheellinen merkkijono";
        }
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
    public String asciiToMerkki(String ascii) {
        String sana = "";
        int pituus = ascii.length();
        if (!tarkistaDesimaali(ascii)) {
            return "Virhe: virheellinen ASCII";
        }
        for (int i = 0; i < pituus; i++) {
            char eka = ascii.charAt(i);
            if (eka == '0') {
                return "Virhe: ethän laita turhia etunollia";
            }
            i++;
            if (i == pituus) {
                return "Virhe: virheellinen ASCII";
            }
            char toka = ascii.charAt(i);
            int asciiNumero = Integer.parseInt("" + eka + toka);

            if (asciiNumero >= 32 && asciiNumero <= 126) {
                sana += Character.toString((char) asciiNumero);
            } else if (i == pituus - 1) {
                return "Virhe: virheellinen ASCII";
            } else if (asciiNumero >= 10 && asciiNumero <= 12) {
                i++;
                char kolmas = ascii.charAt(i);
                asciiNumero = Integer.parseInt("" + eka + toka + kolmas);
                if (asciiNumero <= 126) {
                    sana += Character.toString((char) asciiNumero);
                } else {
                    return "Virhe: virheellinen ASCII (ei ole printattava)";
                }
            }
        }
        return sana;
    }

    private boolean tarkistaMerkkijono(String merkkijono) {
        for (int i = 0; i < merkkijono.length(); i++) {
            char c = merkkijono.charAt(i);
            if (c < 32 || c > 126) {
                return false;
            }
        }
        return true;
    }
}
