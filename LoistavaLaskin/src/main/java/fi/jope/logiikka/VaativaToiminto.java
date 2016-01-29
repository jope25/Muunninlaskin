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
        if (arvo <= 0 || kanta <= 1) {
            return;
        }
        arvo = Math.log10(arvo) / Math.log10(kanta);
    }

    @Override
    public double getArvo() {
        return arvo;
    }

}
