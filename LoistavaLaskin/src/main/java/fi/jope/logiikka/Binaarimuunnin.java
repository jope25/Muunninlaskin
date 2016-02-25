/*
 * Luokka muuntaa saadun desimaali- tai binääriluvun toiseen muotoon.
 */
package fi.jope.logiikka;

public class Binaarimuunnin {

    private int luku;

    public Binaarimuunnin(int luku) {
        this.luku = luku;
    }

    /*
     * Metodi muuntaa luokan attribuutin binäärimuotoon. Jos attribuutti on
     * negatiivinen, metodi ei toistaiseksi tee mitään.
     */
    public String desimaalistaBinaariin() {
        String binaari = "";
        if (luku == 0 || luku == 1) {
            return binaari + luku;
        } else if (luku > 1) {
            while (luku > 0) {
                int jaannos = luku % 2;
                binaari = jaannos + binaari;
                luku /= 2;
            }
        }
        return binaari;
    }

    /*
     * Metodi muuntaa sille annetun string-muotoisen binääriluvun desimaali
     * muotoon ja asettaa sen attribuutin arvoksi.
     */
    public void binaaristaDesimaali(String binaari) {
        for (int i = 0; i < binaari.length(); i++) {
            if (binaari.charAt(i) != '1' && binaari.charAt(i) != '0') {
                return;
            }
        }
        luku = 0;
        int exponentti = 0;
        for (int i = binaari.length(); i > 0; i--) {
            if (binaari.charAt(i - 1) == '1') {
                luku += Math.pow(2, exponentti);
            }
            exponentti++;
        }
    }

    public int getArvo() {
        return luku;
    }
}
