/*
 * Luokka muuntaa annetun nopeuden haluttuun yksikköön.
 */

package fi.jope.logiikka;

import fi.jope.yksikko.Nopeus;

public class NopeusMuunnin implements Toiminto {

    private double annettuNopeus;
    private double nopeus;
    private Nopeus annettuYksikko;

    public NopeusMuunnin(double annettuNopeus, Nopeus annettuYksikko) {
        this.annettuYksikko = annettuYksikko;
        this.annettuNopeus = annettuNopeus;
        this.nopeus = vanhaNopeusToKmH(annettuNopeus);
    }

    /*
     * Muuntaa saadun nopeuden km/h:on, jotta muuntaminen haluttuun yksikköön helpottuisi.
     */
    
    private double vanhaNopeusToKmH(double annettuNopeus) {
        if (annettuYksikko == Nopeus.MS) {
            return annettuNopeus * 3.6;
        } else if (annettuYksikko == Nopeus.JALKAAS) {
            return annettuNopeus * 1.0973;
        } else if (annettuYksikko == Nopeus.MPH) {
            return annettuNopeus * 1.6093;
        } else if (annettuYksikko == Nopeus.SOLMU) {
            return annettuNopeus * 1.852;
        }
        
        return annettuNopeus;
    }
    
    /*
     * Muuntaa km/h nopeuden haluttuun yksikköön.
     */
    
    public void nopeusToHaluttuYksikko(Nopeus haluttuYksikko) {
        if (haluttuYksikko == Nopeus.MS) {
            nopeus *= 0.27778;
        } else if (haluttuYksikko == Nopeus.JALKAAS) {
            nopeus *= 0.91134;
        } else if (haluttuYksikko == Nopeus.MPH) {
            nopeus *= 0.62137;
        } else if (haluttuYksikko == Nopeus.SOLMU) {
            nopeus *= 0.53996;
        }
    }

    @Override
    public double getArvo() {
        return this.nopeus;
    }

}
