package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ASCIIMuuntajaTest {
        
    ASCIIMuuntaja a;
    
    @Before
    public void setUp() {
        a = new ASCIIMuuntaja();
    }
    
    @Test
    public void kirjaimistaASCII() {
        assertEquals("97 115 99 105 105", a.kirjaimistaASCII("ascii"));
        assertEquals("65 83 67 73 73", a.kirjaimistaASCII("ASCII"));
    }
    
    @Test
    public void ASCIIstaKirjaimet() {
        assertEquals("ASCII", a.ASCIIstaKirjaimet("6583677373"));
        assertEquals("ascii", a.ASCIIstaKirjaimet("9711599105105"));
    }
}
