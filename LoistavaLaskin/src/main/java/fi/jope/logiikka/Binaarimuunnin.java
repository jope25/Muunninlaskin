/**
 * Luokka muuntaa saadun desimaali- tai binääriluvun toiseen muotoon.
 */
package fi.jope.logiikka;

public class Binaarimuunnin {

    /**
     * Metodi muuntaa luokana arvon binäärimuotoon.
     *
     * @param arvo muunnettava desimaaliluku
     *
     * @return muunnettu luku kaksikantaisena
     */
    public String desimaalistaBinaariin(long arvo) {
        return Long.toBinaryString(arvo);
    }

    /**
     * Metodi muuntaa sille annetun string-muotoisen binääriluvun desimaali
     * muotoon ja asettaa sen attribuutin arvoksi.
     *
     * @param binaari String muotoinen binääriluku, joka halutaan muuntaa
     * 
     * @return luku muunnettuna
     */
    public long binaaristaDesimaali(String binaari) {
        return Long.parseLong(binaari, 2);
    }

    /**
     * Metodi tarkistaa onko annettu String-muotoinen luku binääriluku.
     *
     * @param binaari Luku, joka halutaan tarkistaa
     * 
     * @return false jos luku ei ole binääriluku, true jos se on
     */
    public boolean tarkistaBinaari(String binaari) {
        for (int i = 0; i < binaari.length(); i++) {
            char c = binaari.charAt(i);
            if (c != '1' && c != '0') {
                return false;
            }
        }
        return true;
    }
   
    /**
     * Metodi tarkistaa onko annettu String-muotoinen luku desimaaliluku.
     *
     * @param desimaali Luku, joka halutaan tarkistaa
     * 
     * @return false jos luku ei ole desimaaliluku, true jos se on
     */
    public boolean tarkistaDesimaali(String desimaali) {
        for (int i = 0; i < desimaali.length(); i++) {
            char c = desimaali.charAt(i);
            if (c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }
}
