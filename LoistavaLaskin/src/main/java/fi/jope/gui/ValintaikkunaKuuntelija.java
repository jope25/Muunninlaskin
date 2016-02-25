/*
 * Luokkaa kuuntelee Valintaikkunan käyttöliittymää.
 */
package fi.jope.gui;

import java.awt.event.*;
import javax.swing.*;

public class ValintaikkunaKuuntelija implements ActionListener {

    private JRadioButton laskin;
    private JRadioButton bm;
    private JButton valitse;

    public ValintaikkunaKuuntelija(JRadioButton laskin, JRadioButton bm, JButton valitse) {
        this.laskin = laskin;
        this.bm = bm;
        this.valitse = valitse;
    }

    /*
     * Metodi käynnistää valitun toiminnon käyttöliittymän.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.valitse) {
            if (laskin.isSelected()) {
                SwingUtilities.invokeLater(new LaskinKayttoliittyma());
            } else if (bm.isSelected()) {
                SwingUtilities.invokeLater(new BinaarimuunninKayttoliittyma());
            }
        }
    }

}
