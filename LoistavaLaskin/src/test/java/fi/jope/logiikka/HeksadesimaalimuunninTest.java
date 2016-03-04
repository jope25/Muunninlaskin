package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeksadesimaalimuunninTest {
    
    Heksadesimaalimuunnin hdm;
    
    @Before
    public void setUp() {
        hdm = new Heksadesimaalimuunnin();
    }
    
    @Test
    public void heksastaDesimaaliinToimii() {
        assertEquals(25, hdm.heksadesimaalistaDesimaal("19"));
        assertEquals(1970, hdm.heksadesimaalistaDesimaal("7b2"));
        assertEquals(100000, hdm.heksadesimaalistaDesimaal("186A0"));
    }
    
    @Test
    public void desimaalistaHeksaanToimii() {
        assertEquals("7b", hdm.desimaalistaHeksadesimaali(123));
        assertEquals("1dfb", hdm.desimaalistaHeksadesimaali(7675));
        assertEquals("f095a", hdm.desimaalistaHeksadesimaali(985434));
    }
    
    @Test
    public void tarkistaHeksaToimii() {
        assertTrue(hdm.tarkistaHeksa("123456789abcdef"));   
        assertTrue(!hdm.tarkistaHeksa("/"));
        assertTrue(!hdm.tarkistaHeksa(":"));
        assertTrue(!hdm.tarkistaHeksa("{"));
        assertTrue(!hdm.tarkistaHeksa("_"));
    }
}
