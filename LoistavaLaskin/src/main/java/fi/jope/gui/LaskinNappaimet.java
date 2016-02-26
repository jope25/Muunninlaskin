/*
 * Luokka luo LaskinKäyttöliitymään näppäimet ja tallettaa ne HashMappiin.
 */
package fi.jope.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LaskinNappaimet extends JPanel {

    private List<JButton> nappaimet;

    public LaskinNappaimet() {
        super(new GridLayout(6, 4));
        this.nappaimet = new ArrayList();
        luoNappaimet();
    }

    private void luoNappaimet() {
        luoVaativatToiminnot();
        luoSeiskastaYsiinJaPlus();
        luoNelosestaKutoseenJaMiinus();
        luoYkkosestaKolmoseenJaKerto();
        luoNollaPisteMiinusJako();
        luoYhtakuinJaNollaus();
    }

    private void luoSeiskastaYsiinJaPlus() {
        JButton seiska = new JButton("7");
        JButton kasi = new JButton("8");
        JButton ysi = new JButton("9");
        JButton plus = new JButton("+");

        add(seiska);
        add(kasi);
        add(ysi);
        add(plus);

        nappaimet.add(seiska);
        nappaimet.add(kasi);
        nappaimet.add(ysi);
        nappaimet.add(plus);
    }

    private void luoNelosestaKutoseenJaMiinus() {
        JButton nelonen = new JButton("4");
        JButton vitonen = new JButton("5");
        JButton kutonen = new JButton("6");
        JButton miinus = new JButton("-");

        add(nelonen);
        add(vitonen);
        add(kutonen);
        add(miinus);

        nappaimet.add(nelonen);
        nappaimet.add(vitonen);
        nappaimet.add(kutonen);
        nappaimet.add(miinus);
    }

    private void luoYkkosestaKolmoseenJaKerto() {
        JButton yksi = new JButton("1");
        JButton kaksi = new JButton("2");
        JButton kolme = new JButton("3");
        JButton kerto = new JButton("x");

        add(yksi);
        add(kaksi);
        add(kolme);
        add(kerto);

        nappaimet.add(yksi);
        nappaimet.add(kaksi);
        nappaimet.add(kolme);
        nappaimet.add(kerto);
    }

    private void luoNollaPisteMiinusJako() {
        JButton piste = new JButton(".");
        JButton negatiivinen = new JButton("(-)");
        JButton nolla = new JButton("0");
        JButton jako = new JButton("/");

        add(nolla);
        add(negatiivinen);
        add(piste);
        add(jako);

        nappaimet.add(piste);
        nappaimet.add(negatiivinen);
        nappaimet.add(nolla);
        nappaimet.add(jako);
    }

    private void luoVaativatToiminnot() {
        JButton potenssi = new JButton("x^y");
        JButton juuri = new JButton("y√x");
        JButton logaritmi = new JButton("log_x (y)");
        JButton binomi = new JButton("nCr");

        add(potenssi);
        add(juuri);
        add(logaritmi);
        add(binomi);

        nappaimet.add(potenssi);
        nappaimet.add(juuri);
        nappaimet.add(logaritmi);
        nappaimet.add(binomi);
    }

    private void luoYhtakuinJaNollaus() {
        JButton yhtakuin = new JButton("=");
        JButton nollaus = new JButton("AC");

        add(yhtakuin);
        add(nollaus);

        nappaimet.add(yhtakuin);
        nappaimet.add(nollaus);
    }

    public List<JButton> getNappaimet() {
        return nappaimet;
    }
}
