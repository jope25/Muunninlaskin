/*
 * Jos valintaikkunasta valitaan laskin-toiminto, niin tämä luokka luo sen
 * komponentit ja käynnistää sen käyttöliittymän.
 */
package fi.jope.gui;

import java.awt.*;
import javax.swing.*;
import fi.jope.logiikka.Laskin;

public class LaskinKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Laskin");
        frame.setPreferredSize(new Dimension(375, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField kentta = new JTextField("");
        kentta.setPreferredSize(new Dimension(375, 50));
        kentta.setEnabled(false);

        LaskinNappaimet ln = new LaskinNappaimet();
        LaskinKuuntelija lk = new LaskinKuuntelija(new Laskin(), ln.getNappaimet(), kentta);

        for (JButton nappi : ln.getNappaimet()) {
            nappi.addActionListener(lk);
        }

        container.setLayout(new BorderLayout());
        container.add(kentta, BorderLayout.NORTH);
        container.add(ln);
    }
}
