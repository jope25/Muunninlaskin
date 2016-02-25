/*
 * Luokka luo LaskinKäyttöliitymään näppäimet ja tallettaa ne HashMappiin.
 */
package fi.jope.gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LaskinNappaimet extends JPanel {

    private Map<JButton, String> nappaimet;

    public LaskinNappaimet() {
        super(new GridLayout(6, 4));
        this.nappaimet = new HashMap();
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

        nappaimet.put(seiska, "seiska");
        nappaimet.put(kasi, "kasi");
        nappaimet.put(ysi, "ysi");
        nappaimet.put(plus, "plus");
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

        nappaimet.put(nelonen, "nelonen");
        nappaimet.put(vitonen, "vitonen");
        nappaimet.put(kutonen, "kutonen");
        nappaimet.put(miinus, "miinus");
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

        nappaimet.put(yksi, "yksi");
        nappaimet.put(kaksi, "kaksi");
        nappaimet.put(kolme, "kolme");
        nappaimet.put(kerto, "kerto");
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

        nappaimet.put(piste, "piste");
        nappaimet.put(negatiivinen, "negatiivinen");
        nappaimet.put(nolla, "nolla");
        nappaimet.put(jako, "jako");
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

        nappaimet.put(potenssi, "potenssi");
        nappaimet.put(juuri, "juuri");
        nappaimet.put(logaritmi, "logaritmi");
        nappaimet.put(binomi, "binomi");
    }

    private void luoYhtakuinJaNollaus() {
        JButton yhtakuin = new JButton("=");
        JButton nollaus = new JButton("AC");

        add(yhtakuin);
        add(nollaus);

        nappaimet.put(yhtakuin, "yhtakuin");
        nappaimet.put(nollaus, "nollaus");
    }

    public Map<JButton, String> getNappaimet() {
        return nappaimet;
    }
}
