/**
 * Luokka määrittelee laskufunktiot.
 */
package fi.jope.logiikka;

public class Laskin {

    private double arvo;

    public Laskin() {
        this.arvo = 0;
    }

    /**
     * Laskee yhteen laskimen arvon ja annetun luvun.
     *
     * @param luku Summattava luku
     */
    public void summa(double luku) {
        arvo += luku;
    }

    /**
     * Vähentää laskimen arvosta annetun luvun.
     *
     * @param luku Vähennettävä luku
     */
    public void erotus(double luku) {
        arvo -= luku;
    }

    /**
     * Kertoo laskimen arvon annetulla luvulla.
     * 
     * @param luku Kerrottava luku
     */
    public void kerto(double luku) {
        arvo *= luku;
    }
/**
 * Jakaa laskimen arvon annetulla luvulla.
 * 
 * @param luku Luku, jolla jaetaan
 */
    public void jako(double luku) {
        if (luku != 0) {
            arvo /= luku;
        }
    }
/**
 * Laskimen arvo lasketaan potenssiin annettu arvo.
 * 
 * @param monesko Annettava eksponentti
 */
    public void potenssi(double monesko) {
        if (arvo != 0 && monesko > 0) {
            arvo = Math.pow(arvo, monesko);
        }
    }
/**
 * Laskimen arvosta lasketaan annettu juuri.
 * 
 * @param juuri Monesko juuri
 */
    public void juuri(double juuri) {
        if (arvo == 0 && juuri <= 0) {
            return;
        } else if (arvo < 0 || juuri == 0) {
            return;
        }
        arvo = Math.pow(arvo, 1.0 / juuri);
    }
/**
 * Laskimen arvolla lasketaan annetun kantainen logaritmi.
 * 
 * @param kanta Logaritmille annettava kanta
 */
    public void logaritmi(double kanta) {
        if (arvo > 0 && kanta != 1 && kanta > 0) {
            arvo = Math.log10(arvo) / Math.log10(kanta);
        }
    }
/**
 * Metodi määrittelee binomikertoimen, joka lasketaan laskimen arvon ja annetun arvon kanssa.
 * 
 * @param k Annettava luku
 */
    public void binomikerroin(double k) {
        if (k < 0 || arvo < 0 || arvo % 1 != 0 || k % 1 != 0) {
            return;
        }
        if (k == 0 || arvo == k) {
            arvo = 1;
        } else if (k > 0 && arvo > k) {
            int a = 1;
            int b = 1;
            int c = 1;

            for (int i = 1; i <= arvo; i++) {
                a *= i;
                if (i <= k) {
                    b *= i;
                }
                if (i <= (arvo - k)) {
                    c *= i;
                }
            }
            arvo = a / (b * c);
        }
    }

    public double getArvo() {
        return arvo;
    }

    public void setArvo(double arvo) {
        this.arvo = arvo;
    }
}
