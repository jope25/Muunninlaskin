/**
 * Luokka luo binäärimuuntimen käyttöliittymän.
 */
package fi.jope.gui;

import fi.jope.logiikka.Binaarimuunnin;
import java.awt.*;
import javax.swing.*;

public class BinaarimuunninKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Binäärimuunnin");
        frame.setPreferredSize(new Dimension(350, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField kentta = new JTextField("");
        kentta.setPreferredSize(new Dimension(275, 50));
        kentta.setEnabled(false);

        BinaarimuunninNappaimet bmn = new BinaarimuunninNappaimet();
        BinaarimuunninKuuntelija lk = new BinaarimuunninKuuntelija(new Binaarimuunnin(), 
                bmn.getNappaimet(), kentta);

        for (JButton nappi : bmn.getNappaimet()) {
            nappi.addActionListener(lk);
        }

        container.setLayout(new BorderLayout());
        container.add(kentta, BorderLayout.NORTH);
        container.add(bmn);
    }
}
