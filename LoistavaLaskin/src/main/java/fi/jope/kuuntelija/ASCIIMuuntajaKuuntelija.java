/**
 * Luokka kuuntelee ASCII-muuntaja käyttöliittyän toimintaa.
 */
package fi.jope.kuuntelija;

import fi.jope.logiikka.ASCIIMuuntaja;
import java.awt.event.*;
import javax.swing.*;

public class ASCIIMuuntajaKuuntelija extends Kuuntelija implements ActionListener {

    private ASCIIMuuntaja am;
    private JButton asciiToString;
    private JButton stringToAscii;
    private JButton clear;
    private JTextField kentta;

    /**
     * Konstruktori luo kuuntelijan. Parametrien avulla päästän käyttöliittymän
     * elementeihin käsiksi.
     *
     * @param asciiToString Näppäi, jolla muunnetaan ASCII-luku merkkijonoksi
     * @param stringToAscii Näppäin, jolla muunnetaan merkkijono ASCII-luvuksi
     * @param clear Näppäin, jolla tyhjennetään tekstieknttä
     * @param kentta Käyttöliittymän tekstikenttä
     */
    public ASCIIMuuntajaKuuntelija(JButton asciiToString,
            JButton stringToAscii, JButton clear, JTextField kentta) {
        this.asciiToString = asciiToString;
        this.stringToAscii = stringToAscii;
        this.clear = clear;
        this.kentta = kentta;
        this.am = new ASCIIMuuntaja();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String kentanTeksti = kentta.getText();
            if (ae.getSource() == asciiToString) {
                if (!am.tarkistaDesimaali(kentanTeksti)) {
                    asetaTeksti(kentta, "Virhe: virheellinen desimaali (ethän ole laittanut välilyöntejä)", true);
                } else {
                    asetaTeksti(kentta, am.asciiToMerkki(kentanTeksti), true);
                }
            } else if (ae.getSource() == stringToAscii) {
                asetaTeksti(kentta, am.merkkiToASCII(kentanTeksti), true);
            } else {
                tyhjennaKentta(kentta);
            }
        } catch (Exception e) {
            asetaTeksti(kentta, "Virhe: liian pitkä syöte", true);
        }
    }
}
