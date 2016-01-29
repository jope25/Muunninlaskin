package fi.jope.logiikka;

public class Perustoiminto implements Toiminto {

    private double arvo;

    public Perustoiminto(double arvo) {
        this.arvo = arvo;
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

    @Override
    public double getArvo() {
        return arvo;
    }

}
