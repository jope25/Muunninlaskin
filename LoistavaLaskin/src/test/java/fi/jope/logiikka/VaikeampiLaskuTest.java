package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VaikeampiLaskuTest {

    Laskin l;
    Laskin desimaali;
    Laskin nolla;
    Laskin miinus;

    @Before
    public void setUp() {
        l = new Laskin();
        l.setArvo(8);
        desimaali = new Laskin();
        desimaali.setArvo(10);
        nolla = new Laskin();
        miinus = new Laskin();
        miinus.setArvo(-3);
    }

    @Test
    public void potenssiToimii() {
        l.potenssi(2);
        desimaali.potenssi(0.5);
        nolla.potenssi(1);
        assertEquals(64, l.getArvo(), 0);
        assertEquals(3.16, desimaali.getArvo(), 0.01);
        assertEquals(0, nolla.getArvo(), 0);
    }

    @Test
    public void juuriToimii() {
        l.juuri(3);
        desimaali.juuri(1.25);

        assertEquals(2, l.getArvo(), 0);
        assertEquals(6.31, desimaali.getArvo(), 0.01);
    }

    @Test
    public void logaritmiToimii() {
        Laskin sata = new Laskin();
        sata.setArvo(100);
        sata.logaritmi(10);
        l.logaritmi(2);

        assertEquals(2, sata.getArvo(), 0);
        assertEquals(3, l.getArvo(), 0);
    }

//    @Test
//    public void potenssiVirheellisetArvot() {
//        nolla.potenssi(0);
//        nolla.potenssi(-1);
//
//        assertEquals(0, nolla.getArvo(), 0);
//    }
//
//    @Test
//    public void juuriVirheellisetArvot() {
//        nolla.juuri(0);
//        nolla.juuri(-1);
//        nolla.juuri(3);
//        l.juuri(0);
//        miinus.juuri(2);
//
//        assertEquals(0, nolla.getArvo(), 0);
//        assertEquals(8, l.getArvo(), 0);
//        assertEquals(-3, miinus.getArvo(), 0);
//    }
//
//    @Test
//    public void logaritmiVirheellisetArvot() {
//        Laskin kaksi = new Laskin();
//        kaksi.setArvo(2);
//        nolla.logaritmi(10);
//        miinus.logaritmi(2);
//        kaksi.logaritmi(1);
//        l.logaritmi(-1);
//
//        assertEquals(0, nolla.getArvo(), 0);
//        assertEquals(-3, miinus.getArvo(), 0);
//        assertEquals(2, kaksi.getArvo(), 0);
//        assertEquals(8, l.getArvo(), 0);
//    }

    @Test
    public void binomikerroinToimii() {
        l.binomikerroin(3);
        assertEquals(56, l.getArvo(), 0);

        l.binomikerroin(0);
        assertEquals(1, l.getArvo(), 0);
        l.setArvo(3);
        l.binomikerroin(3);
        assertEquals(1, l.getArvo(), 0);
    }

    @Test
    public void binomikerroinVirheellisetArvot() {
        l.setArvo(1.5);
        l.binomikerroin(1);
        assertEquals(1.5, l.getArvo(), 0);
        
        l.setArvo(2);
        l.binomikerroin(1.5);
        assertEquals(2, l.getArvo(), 0);
        
        l.setArvo(-2);
        l.binomikerroin(0);
        assertEquals(-2, l.getArvo(), 0);
        
        l.setArvo(5);
        l.binomikerroin(-2);
        assertEquals(5, l.getArvo(), 0); 
    }
}
