/**
 * Luokka luo binäärimuuntimen käyttöliitymän näppäimet ja tallettaa ne ArrayListiin.
 */
package fi.jope.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BinaarimuunninNappaimet extends JPanel {

    private List<JButton> nappaimet;

    public BinaarimuunninNappaimet() {
        super(new GridLayout(5, 3));
        this.nappaimet = new ArrayList();
        luoNappaimet();
    }

    private void luoNappaimet() {
        luoSeiskastaYsiin();
        luoNelosestaKutoseen();
        luoYkkosestaKolmoseen();
        luoNollaNollaus();
        luoMuuntoNappaimet();
    }

    private void luoSeiskastaYsiin() {
        JButton seiska = new JButton("7");
        JButton kasi = new JButton("8");
        JButton ysi = new JButton("9");

        add(seiska);
        add(kasi);
        add(ysi);

        nappaimet.add(seiska);
        nappaimet.add(kasi);
        nappaimet.add(ysi);
    }

    private void luoNelosestaKutoseen() {
        JButton nelonen = new JButton("4");
        JButton vitonen = new JButton("5");
        JButton kutonen = new JButton("6");

        add(nelonen);
        add(vitonen);
        add(kutonen);

        nappaimet.add(nelonen);
        nappaimet.add(vitonen);
        nappaimet.add(kutonen);
    }

    private void luoYkkosestaKolmoseen() {
        JButton yksi = new JButton("1");
        JButton kaksi = new JButton("2");
        JButton kolme = new JButton("3");

        add(yksi);
        add(kaksi);
        add(kolme);

        nappaimet.add(yksi);
        nappaimet.add(kaksi);
        nappaimet.add(kolme);
    }

    private void luoNollaNollaus() {
        JButton nolla = new JButton("0");
        JButton nollaus = new JButton("AC");

        add(nollaus);
        add(nolla);

        nappaimet.add(nolla);
        nappaimet.add(nollaus);
    }
    
    private void luoMuuntoNappaimet() {
        JButton binToDec = new JButton("bin -> dec");
        JButton decToBin = new JButton("dec -> bin");
        
        add(binToDec);
        add(decToBin);
        
        nappaimet.add(binToDec);
        nappaimet.add(decToBin);
    }

    public List<JButton> getNappaimet() {
        return nappaimet;
    }
}
