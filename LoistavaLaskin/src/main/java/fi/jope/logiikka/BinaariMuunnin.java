package fi.jope.logiikka;

public class BinaariMuunnin implements Toiminto {

    private int luku;

    public BinaariMuunnin(int luku) {
        this.luku = luku;
    }

    public String desimaalistaBinaariin() {
        String binaari = "";
        if (luku == 0 || luku == 1) {
            return binaari + luku;
        } else if (luku > 1 && luku % 1 == 0) {
            while (luku > 0) {
                int jaannos = luku % 2;
                binaari = jaannos + binaari;
                luku /= 2;
            }
        }
        return binaari;
    }
    
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
    
    @Override
    public double getArvo() {
        return this.luku;
    }
}
