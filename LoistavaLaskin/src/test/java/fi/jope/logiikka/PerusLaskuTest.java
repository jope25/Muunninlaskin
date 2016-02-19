package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerusLaskuTest {

    Laskin pt;
    Laskin desimaali;

    @Before
    public void setUp() {
        pt = new Laskin();
        pt.setArvo(5);
        desimaali = new Laskin();
        desimaali.setArvo(3);
    }

    @Test
    public void summaToimii() {
        pt.summa(3);
        desimaali.summa(1.55);

        assertEquals(8, pt.getArvo(), 0);
        assertEquals(4.55, desimaali.getArvo(), 0.01);
    }

    @Test
    public void erotusToimii() {
        pt.erotus(3);
        desimaali.erotus(2.67);

        assertEquals(2, pt.getArvo(), 0);
        assertEquals(0.33, desimaali.getArvo(), 0.01);
    }

    @Test
    public void kertoToimii() {
        pt.kerto(2);
        desimaali.kerto(1.3);

        assertEquals(10, pt.getArvo(), 0);
        assertEquals(3.9, desimaali.getArvo(), 0.1);
    }

    @Test
    public void jakoToimii() {
        pt.jako(5);
        desimaali.jako(2.25);

        assertEquals(1, pt.getArvo(), 0);
        assertEquals(1.33, desimaali.getArvo(), 0.01);
    }

    @Test
    public void nollallaEiVoiJakaa() {
        pt.jako(0);

        assertEquals(5, pt.getArvo(), 0);
    }

    @Test
    public void miinusLaskutToimii() {
        Laskin miinus1 = new Laskin();
        miinus1.setArvo(-2);
        Laskin miinus2 = new Laskin();
        miinus2.setArvo(7);
        pt.summa(-6);
        desimaali.erotus(-2.5);
        miinus1.kerto(-4);
        miinus2.jako(-7);

        assertEquals(-1, pt.getArvo(), 0);
        assertEquals(5.5, desimaali.getArvo(), 0.1);
        assertEquals(8, miinus1.getArvo(), 0);
        assertEquals(-1, miinus2.getArvo(), 0);
    }
}
