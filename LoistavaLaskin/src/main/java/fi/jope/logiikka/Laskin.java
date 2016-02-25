/*
 * Metodit määrittelevät nimensä mukaisesti kyseisen laskutoimituksen.
 */
package fi.jope.logiikka;

public class Laskin {

    private double arvo;

    public Laskin() {
        this.arvo = 0;
    }

    public void summa(double luku) {
        arvo += luku;
    }

    public void erotus(double luku) {
        arvo -= luku;
    }

    public void kerto(double luku) {
        arvo *= luku;
    }

    public void jako(double luku) {
        if (luku != 0) {
            arvo /= luku;
        }
    }

    public void potenssi(double monesko) {
        if (arvo != 0 && monesko > 0) {
            arvo = Math.pow(arvo, monesko);
        }
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
        if (k < 0 || n < 0 || n % 1 != 0 || k % 1 != 0) {
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
                if (i <= (n - k)) {
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
