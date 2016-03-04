/**
 * Luokka muuntaa saadun desimaali- tai heksdesimaaliluvun toiseen muotoon.
 */
package fi.jope.logiikka;

public class Heksadesimaalimuunnin extends Muunnin {

    /**
     * Metodi muuntaa sille annetun string-muotoisen heksadesimaaliluvun ja
     * palauttaa sen desimaalimuotoisena.
     *
     * @param hd String-muotoinen heksadesimaali, joka halutaan muuntaa
     * @return luku muunnettuna
     */
    public long heksadesimaalistaDesimaal(String hd) {
        return Long.parseLong(hd, 16);
    }

    /**
     * Metodi muuntaa annetun arvon heksadesimaalimuotoon.
     *
     * @param desimaali muunnettava desimaaliluku
     * @return muunnettu luku 16-kantaisena
     */
    public String desimaalistaHeksadesimaali(long desimaali) {
        return Long.toHexString(desimaali);
    }

    /**
     * Metodi tarkistaa onko annettu String-muotoinen luku heksadesimaali.
     *
     * @param hd Luku, joka halutaan tarkistaa
     * @return false jos luku ei ole heksadesimaali, true jos se on
     */
    public boolean tarkistaHeksa(String hd) {
        if (hd.isEmpty()) {
            return false;
        }
        for (int i = 0; i < hd.length(); i++) {
            char c = hd.charAt(i);
            if (c < 48 || c > 102 || (c < 97 && c > 57)) {
                return false;
            }
        }
        return true;
    }
}
