package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaariMuunninTest {

    @Test
    public void desimaalistaBinaariinToimii() {
        Binaarimuunnin nolla = new Binaarimuunnin(0);
        Binaarimuunnin kaksi = new Binaarimuunnin(2);
        Binaarimuunnin bm = new Binaarimuunnin(43);
        Binaarimuunnin bm2 = new Binaarimuunnin(16);

        assertEquals("0", nolla.desimaalistaBinaariin());
        assertEquals("10", kaksi.desimaalistaBinaariin());
        assertEquals("101011", bm.desimaalistaBinaariin());
        assertEquals("10000", bm2.desimaalistaBinaariin());

    }

    @Test
    public void binaaristaDesimaaliinToimii() {
        Binaarimuunnin bm = new Binaarimuunnin(0);

        bm.binaaristaDesimaali("1");
        assertEquals(1, bm.getArvo(), 0);

        bm.binaaristaDesimaali("1111");
        assertEquals(15, bm.getArvo(), 0);

        bm.binaaristaDesimaali("1011101");
        assertEquals(93, bm.getArvo(), 0);
    }

    @Test
    public void desimaalistaBinaariinVaaraArvo() {
        Binaarimuunnin miinus = new Binaarimuunnin(-1);
        assertEquals("", miinus.desimaalistaBinaariin());
    }

    @Test
    public void binaaristaDesimaaliinVaaraArvo() {
        Binaarimuunnin nolla = new Binaarimuunnin(0);
        nolla.binaaristaDesimaali("11100211");
        assertEquals(0, nolla.getArvo(), 0);
    }
}
