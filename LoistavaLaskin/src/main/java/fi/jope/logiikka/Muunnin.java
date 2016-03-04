/**
 * Luokka määrittelee metodin, jota sekä Binääri- että Heksadesimaalimuunnin
 * käyttävät.
 */
package fi.jope.logiikka;

public abstract class Muunnin {

    /**
     * Metodi tarkistaa onko annettu String-muotoinen luku desimaaliluku.
     *
     * @param desimaali Luku, joka halutaan tarkistaa
     * @return false jos luku ei ole desimaaliluku, true jos se on
     */
    public boolean tarkistaDesimaali(String desimaali) {
        if (desimaali.isEmpty()) {
            return false;
        }
        for (int i = 0; i < desimaali.length(); i++) {
            char c = desimaali.charAt(i);
            if (c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }
}
