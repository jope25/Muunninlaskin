package fi.jope.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
