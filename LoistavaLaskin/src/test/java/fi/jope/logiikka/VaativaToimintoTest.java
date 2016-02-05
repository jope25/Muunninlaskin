package fi.jope.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VaativaToimintoTest {

    VaativaToiminto vt;
    VaativaToiminto desimaali;
    VaativaToiminto nolla;
    VaativaToiminto miinus;

    @Before
    public void setUp() {
        vt = new VaativaToiminto(8);
        desimaali = new VaativaToiminto(10);
        nolla = new VaativaToiminto(0);
        miinus = new VaativaToiminto(-3);
    }

    @Test
    public void potenssiToimii() {
        vt.potenssi(2);
        desimaali.potenssi(0.5);

        assertEquals(64, vt.getArvo(), 0);
        assertEquals(3.16, desimaali.getArvo(), 0.01);
    }

    @Test
    public void juuriToimii() {
        vt.juuri(3);
        desimaali.juuri(1.25);

        assertEquals(2, vt.getArvo(), 0);
        assertEquals(6.31, desimaali.getArvo(), 0.01);
    }

    @Test
    public void logaritmiToimii() {
        VaativaToiminto sata = new VaativaToiminto(100);
        sata.logaritmi(10);
        vt.logaritmi(2);

        assertEquals(2, sata.getArvo(), 0);
        assertEquals(3, vt.getArvo(), 0);
    }

    @Test
    public void potenssiVirheellisetArvot() {
        nolla.potenssi(0);
        nolla.potenssi(-1);

        assertEquals(0, nolla.getArvo(), 0);
    }

    @Test
    public void juuriVirheellisetArvot() {
        nolla.juuri(0);
        nolla.juuri(-1);
        nolla.juuri(3);
        vt.juuri(0);
        miinus.juuri(2);

        assertEquals(0, nolla.getArvo(), 0);
        assertEquals(8, vt.getArvo(), 0);
        assertEquals(-3, miinus.getArvo(), 0);
    }

    @Test
    public void logaritmiVirheellisetArvot() {
        VaativaToiminto kaksi = new VaativaToiminto(2);

        nolla.logaritmi(10);
        miinus.logaritmi(2);
        kaksi.logaritmi(1);
        vt.logaritmi(-1);

        assertEquals(0, nolla.getArvo(), 0);
        assertEquals(-3, miinus.getArvo(), 0);
        assertEquals(2, kaksi.getArvo(), 0);
        assertEquals(8, vt.getArvo(), 0);
    }
    
    @Test
    public void binomikerroinToimii() {
        vt.binomikerroin(vt.getArvo(), 3);
        assertEquals(56, vt.getArvo(), 0);
        
        vt.binomikerroin(5, 0);
        assertEquals(1, vt.getArvo(), 0);
        
        vt.binomikerroin(3, 3);
        assertEquals(1, vt.getArvo(), 0);
    }
    
    @Test
    public void binomikerroinVirheellisetArvot() {
        vt.binomikerroin(1.5, 1);
        vt.binomikerroin(2, 1.5);
        vt.binomikerroin(-2, 0);
        vt.binomikerroin(5, -2);
        
        assertEquals(8, vt.getArvo(), 0);
    }
}
