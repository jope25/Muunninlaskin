/*
 * Luokkaa kuuntelee Valintaikkunan käyttöliittymää.
 */
package fi.jope.gui;

import java.awt.event.*;
import javax.swing.*;

public class ValintaikkunaKuuntelija implements ActionListener {

    private JRadioButton laskin;
    private JButton valitse;

    public ValintaikkunaKuuntelija(JRadioButton laskin, JButton valitse) {
        this.laskin = laskin;
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
            }
        }
    }

}
