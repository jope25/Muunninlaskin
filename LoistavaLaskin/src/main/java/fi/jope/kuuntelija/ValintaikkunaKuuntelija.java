/**
 * Luokkaa kuuntelee Valintaikkunan käyttöliittymää.
 */
package fi.jope.kuuntelija;

import fi.jope.gui.*;
import java.awt.event.*;
import javax.swing.*;

public class ValintaikkunaKuuntelija implements ActionListener {

    private JRadioButton laskin;
    private JRadioButton muuntaja;
    private JRadioButton ascii;
    private JButton valitse;

    /**
     * Luodaan Valintaikkunan kuuntelija. Parametrien avulla päästään
     * valintoihin käsiksi.
     *
     * @param laskin Käyttöliittymän laskin-näppäin
     * @param muuntaja Käyttöliittymän lukumuunnin-näppäin
     * @param ascii Käyttöliittymän ASCII-muunnin -näppäin
     * @param valitse Käyttöliittymän valitse-näppäin
     */
    public ValintaikkunaKuuntelija(JRadioButton laskin, JRadioButton muuntaja,
            JRadioButton ascii, JButton valitse) {
        this.laskin = laskin;
        this.muuntaja = muuntaja;
        this.ascii = ascii;
        this.valitse = valitse;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.valitse) {
            if (laskin.isSelected()) {
                SwingUtilities.invokeLater(new LaskinKayttoliittyma());
            } else if (muuntaja.isSelected()) {
                SwingUtilities.invokeLater(new MuunninKayttoliittyma());
            } else if (ascii.isSelected()) {
                SwingUtilities.invokeLater(new ASCIIMuuntajaKayttoliittyma());
            }
        }
    }

}
