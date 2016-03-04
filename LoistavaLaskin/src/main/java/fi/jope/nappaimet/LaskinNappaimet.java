/**
 * Luokka luo LaskinKäyttöliitymään näppäimet ja tallettaa ne ArrayListiin.
 */
package fi.jope.nappaimet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LaskinNappaimet extends JPanel {

    private List<JButton> nappaimet;
    private List<JButton> toiminnot;

    /**
     * Samalla kun JPanel ja sen näppäimet luodaan, niin luodaan kaksi
     * ArrayListiä, joiden avulla päästään näppäimiin käsiksi.
     */
    public LaskinNappaimet() {
        super(new GridLayout(6, 4, 5, 5));
        this.nappaimet = new ArrayList();
        this.toiminnot = new ArrayList();
        luoJaLisaaNappaimet();
    }

    private void luoJaLisaaNappaimet() {
        lisaaNappain(new JButton("x^y"), true);
        lisaaNappain(new JButton("y√x"), true);
        lisaaNappain(new JButton("log_x (y)"), true);
        lisaaNappain(new JButton("nCr"), true);
        lisaaNappain(new JButton("7"), false);
        lisaaNappain(new JButton("8"), false);
        lisaaNappain(new JButton("9"), false);
        lisaaNappain(new JButton("+"), true);
        lisaaNappain(new JButton("4"), false);
        lisaaNappain(new JButton("5"), false);
        lisaaNappain(new JButton("6"), false);
        lisaaNappain(new JButton("-"), true);
        lisaaNappain(new JButton("1"), false);
        lisaaNappain(new JButton("2"), false);
        lisaaNappain(new JButton("3"), false);
        lisaaNappain(new JButton("x"), true);
        lisaaNappain(new JButton("."), false);
        lisaaNappain(new JButton("(-)"), false);
        lisaaNappain(new JButton("0"), false);
        lisaaNappain(new JButton("/"), true);
        lisaaNappain(new JButton("="), false);
        lisaaNappain(new JButton("Clear"), true);
        lisaaNappain(new JButton("Del"), true);
    }

    private void lisaaNappain(JButton jb, boolean lisaaToimintoihin) {
        nappaimet.add(jb);
        add(jb);
        if (lisaaToimintoihin) {
            toiminnot.add(jb);
        }
    }

    public List<JButton> getNappaimet() {
        return nappaimet;
    }

    public List<JButton> getToiminnot() {
        return toiminnot;
    }

    public JButton getPiste() {
        return nappaimet.get(16);
    }

    public JButton getNegatiivinen() {
        return nappaimet.get(17);
    }
}
