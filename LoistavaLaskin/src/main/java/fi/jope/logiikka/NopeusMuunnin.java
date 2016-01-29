package fi.jope.logiikka;

public class NopeusMuunnin implements Toiminto {

    private double nopeus;
    
    public NopeusMuunnin(double nopeus) {
        this.nopeus = nopeus;
    }
    
    
    
    @Override
    public double getArvo() {
        return this.nopeus;
    }

}
