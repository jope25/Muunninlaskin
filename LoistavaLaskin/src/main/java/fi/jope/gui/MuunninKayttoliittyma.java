/**
 * Luokka luo binäärimuuntimen käyttöliittymän.
 */
package fi.jope.gui;

import fi.jope.nappaimet.MuunninNappaimet;
import fi.jope.kuuntelija.MuunninKuuntelija;
import java.awt.*;
import javax.swing.*;

public class MuunninKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.frame = new JFrame("Lukumuuntaja");
        frame.setPreferredSize(new Dimension(450, 400));
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField kentta = new JTextField("");
        kentta.setPreferredSize(new Dimension(450, 50));
        kentta.setEnabled(false);
        kentta.setDisabledTextColor(Color.BLACK);

        MuunninNappaimet mn = new MuunninNappaimet();
        MuunninKuuntelija mk = new MuunninKuuntelija(kentta, mn.getToiminnot());

        mk.napitOnOff(false);

        for (JButton nappi : mn.getNappaimet()) {
            nappi.addActionListener(mk);
        }

        container.setLayout(new BorderLayout());
        container.add(kentta, BorderLayout.NORTH);
        container.add(mn);
    }
}
