package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaariMuunninTest {

    Binaarimuunnin bm;
    
    @Before
    public void setUp() {
        bm = new Binaarimuunnin();
    }
    
    @Test
    public void desimaalistaBinaariinToimii() {
        assertEquals("0", bm.desimaalistaBinaariin(0));
        assertEquals("10", bm.desimaalistaBinaariin(2));
        assertEquals("101011", bm.desimaalistaBinaariin(43));
        assertEquals("10000", bm.desimaalistaBinaariin(16));

    }

    @Test
    public void binaaristaDesimaaliinToimii() {
        assertEquals(1, bm.binaaristaDesimaali("1"));
        assertEquals(15, bm.binaaristaDesimaali("1111"));
        assertEquals(93, bm.binaaristaDesimaali("1011101"));
    }

    @Test
    public void tarkistaBinaariMetodiToimii() {
        assertTrue(bm.tarkistaBinaari("11001110001111"));
        assertTrue(!bm.tarkistaBinaari("110011100081111"));
    }
    
    @Test
    public void tarkistaDesimaaliMetodiToimii() {
        assertTrue(bm.tarkistaDesimaali("123456789"));
        assertTrue(!bm.tarkistaDesimaali("1234785a78"));
    }
}
