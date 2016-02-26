/*
 * Luokka muuntaa saadun desimaali- tai binääriluvun toiseen muotoon.
 */
package fi.jope.logiikka;

public class Binaarimuunnin {

    private int arvo;

    public Binaarimuunnin() {
        this.arvo = 0;
    }

    /*
     * Metodi muuntaa luokan attribuutin binäärimuotoon. Jos attribuutti on
     * negatiivinen, metodi ei toistaiseksi tee mitään.
     */
    public void desimaalistaBinaariin() {
        String binaari = "";
        if (arvo == 0 || arvo == 1) {
            return;
        } else if (arvo > 1) {
            while (arvo > 0) {
                int jaannos = arvo % 2;
                binaari = jaannos + binaari;
                arvo /= 2;
            }
            arvo = Integer.parseInt(binaari);
        }
    }

    /*
     * Metodi muuntaa sille annetun string-muotoisen binääriluvun desimaali
     * muotoon ja asettaa sen attribuutin arvoksi.
     */
    public void binaaristaDesimaali(String binaari) {
        if (tarkistaBinaari(binaari)) {
            arvo = 0;
            int exponentti = 0;
            for (int i = binaari.length(); i > 0; i--) {
                if (binaari.charAt(i - 1) == '1') {
                    arvo += Math.pow(2, exponentti);
                }
                exponentti++;
            }
        }
    }

    public boolean tarkistaBinaari(String binaari) {
        for (int i = 0; i < binaari.length(); i++) {
            if (binaari.charAt(i) != '1' && binaari.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int luku) {
        arvo = luku;
    }
}
