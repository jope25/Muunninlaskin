/**
 * Luokka luo laskin-toiminnon käyttöliittymän.
 */
package fi.jope.gui;

import fi.jope.nappaimet.LaskinNappaimet;
import fi.jope.kuuntelija.LaskinKuuntelija;
import java.awt.*;
import javax.swing.*;

public class LaskinKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.frame = new JFrame("Laskin");
        frame.setPreferredSize(new Dimension(375, 400));
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField kentta = new JTextField("");
        kentta.setPreferredSize(new Dimension(375, 50));
        kentta.setEnabled(false);
        kentta.setDisabledTextColor(Color.BLACK);

        LaskinNappaimet ln = new LaskinNappaimet();
        LaskinKuuntelija lk = new LaskinKuuntelija(ln.getNappaimet(), ln.getToiminnot(),
                kentta, ln.getPiste(), ln.getNegatiivinen());

        lk.napitOnOff(false);

        for (JButton nappi : ln.getNappaimet()) {
            nappi.addActionListener(lk);
        }

        container.setLayout(new BorderLayout());
        container.add(kentta, BorderLayout.NORTH);
        container.add(ln);
    }
}
