package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LampotilaMuunninTest {
    LampotilaMuunnin lm;
    
    @Before
    public void setUp() {
        lm = new LampotilaMuunnin(100);
    }
    
    @Test
    public void celsiusToFahrenheit() {
        lm.celsiusFahrenheit(1);
        assertEquals(212, lm.getArvo(), 0);
    }
    
    @Test
    public void celsiusToKelvin() {
        lm.celsiusKelvin(1);
        assertEquals(373.15, lm.getArvo(), 0.01);
    }
    
    @Test
    public void KelvinToFahrenheit() {
        lm.kelvinFahrenheit(1);
        assertEquals(-279.67, lm.getArvo(), 0.01);
    }
    
    @Test
    public void FahrenheitToKelvin() {
        lm.kelvinFahrenheit(0);
        assertEquals(310.93, lm.getArvo(), 0.01);
    }
    
    @Test
    public void FahrenheitToCelsius() {
        lm.celsiusFahrenheit(0);
        assertEquals(37.78, lm.getArvo(), 0.01);
    }
    
    @Test
    public void KelvinToCelsius() {
        lm.celsiusKelvin(0);
        assertEquals(-173.15, lm.getArvo(), 0.01);
    }
}
