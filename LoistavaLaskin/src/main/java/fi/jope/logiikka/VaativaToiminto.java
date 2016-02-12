/*
 * Luokka määrittelee hieman vaativammat toiminnot. Jokainen metodi suorittaa 
 * nimensä mukaisen laskutoiminnon ja muokkaa attribuuttia sen mukaisesti.
 */

package fi.jope.logiikka;

public class VaativaToiminto implements Toiminto {

    private double arvo;

    public VaativaToiminto(double arvo) {
        this.arvo = arvo;
    }

    public void potenssi(double monesko) {
        if (arvo == 0 && monesko <= 0) {
            return;
        }
        arvo = Math.pow(arvo, monesko);
    }

    public void juuri(double juuri) {
        if (arvo == 0 && juuri <= 0) {
            return;
        } else if (arvo < 0 || juuri == 0) {
            return;
        }
        arvo = Math.pow(arvo, 1.0 / juuri);
    }

    public void logaritmi(int kanta) {
        if (arvo > 0 && kanta > 1) {
            arvo = Math.log10(arvo) / Math.log10(kanta);
        }
    }

    public void binomikerroin(double n, double k) {
        if (k < 0 || n < 0 || n%1 != 0 || k%1 != 0) {
            return;
        }
        if (k == 0 || n == k) {
            arvo = 1;
        } else if (k > 0 && n > k) {
            int a = 1;
            int b = 1;
            int c = 1;

            for (int i = 1; i <= n; i++) {
                a *= i;
                if (i <= k) {
                    b *= i;
                }
                if (i <= (n-k)) {
                    c *= i;
                }
            }
            arvo = a/(b*c);
        }
    }

    @Override
    public double getArvo() {
        return arvo;
    }

}
