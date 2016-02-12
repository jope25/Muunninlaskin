/*
 * Luokka on vielä kesken, mutta se tulee muuttamaan annetun aikayksikön
 * haluttuun aikayksikköön.
 */


package fi.jope.logiikka;

import fi.jope.yksikko.Aika;

public class Aikamuunnin implements Toiminto {
    private double aika;
    
    public Aikamuunnin() {
        
    }
    
    @Override
    public double getArvo() {
        return this.aika;
    }
    
}
