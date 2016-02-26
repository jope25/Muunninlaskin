package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaariMuunninTest {

    Binaarimuunnin nolla;
    Binaarimuunnin kaksi;
    
    @Before
    public void setUp() {
        nolla = new Binaarimuunnin();
        kaksi = new Binaarimuunnin();
        kaksi.setArvo(2);
    }
    
    @Test
    public void desimaalistaBinaariinToimii() {
        nolla.desimaalistaBinaariin();
        assertEquals(0, nolla.getArvo());

        kaksi.desimaalistaBinaariin();
        assertEquals(10, kaksi.getArvo());
        
        Binaarimuunnin bm = new Binaarimuunnin();
        bm.setArvo(43);
        bm.desimaalistaBinaariin();
        assertEquals(101011, bm.getArvo());
        
        Binaarimuunnin bm2 = new Binaarimuunnin();
        bm2.setArvo(16);
        bm2.desimaalistaBinaariin();
        assertEquals(10000, bm2.getArvo());

    }

    @Test
    public void binaaristaDesimaaliinToimii() {
        nolla.binaaristaDesimaali("1");
        assertEquals(1, nolla.getArvo(), 0);

        nolla.binaaristaDesimaali("1111");
        assertEquals(15, nolla.getArvo(), 0);

        nolla.binaaristaDesimaali("1011101");
        assertEquals(93, nolla.getArvo(), 0);
    }

    @Test
    public void desimaalistaBinaariinVaaraArvo() {
        Binaarimuunnin miinus = new Binaarimuunnin();
        miinus.setArvo(-1);
        miinus.desimaalistaBinaariin();
        assertEquals(-1, miinus.getArvo());
    }

    @Test
    public void tarkistaBinaariMetodiToimii() {
        Binaarimuunnin bm = new Binaarimuunnin();
        assertTrue(!bm.tarkistaBinaari("110011100081111"));
    }
    @Test
    public void binaaristaDesimaaliinVaaraArvo() {
        nolla.binaaristaDesimaali("11100211");
        assertEquals(0, nolla.getArvo(), 0);
    }
}
