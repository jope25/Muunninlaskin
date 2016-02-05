package fi.jope.logiikka;

import fi.jope.yksikko.Nopeus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NopeusMuunninTest {

    @Test
    public void MSToMPH() {
        NopeusMuunnin ms = new NopeusMuunnin(10, Nopeus.MS);
        ms.nopeusToHaluttuYksikko(Nopeus.MPH);
        assertEquals(22.369, ms.getArvo(), 0.001);
    }
    
    @Test
    public void KmHToSolmu() {
        NopeusMuunnin kmh = new NopeusMuunnin(10, Nopeus.KMH);
        kmh.nopeusToHaluttuYksikko(Nopeus.SOLMU);
        assertEquals(5.3996, kmh.getArvo(), 0.0001);
    }
    
    @Test
    public void JalkaaSToKmH() {
        NopeusMuunnin js = new NopeusMuunnin(10, Nopeus.JALKAAS);
        js.nopeusToHaluttuYksikko(Nopeus.KMH);
        assertEquals(10.973, js.getArvo(), 0.001);
    }
    
    @Test
    public void MPHToJalkaaS() {
        NopeusMuunnin mph = new NopeusMuunnin(10, Nopeus.MPH);
        mph.nopeusToHaluttuYksikko(Nopeus.JALKAAS);
        assertEquals(14.667, mph.getArvo(), 0.001);
    }
    
    @Test
    public void SolmuToMS() {
        NopeusMuunnin solmu = new NopeusMuunnin(10, Nopeus.SOLMU);
        solmu.nopeusToHaluttuYksikko(Nopeus.MS);
        assertEquals(5.1444, solmu.getArvo(), 0.0001);
    }
}
