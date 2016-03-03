/**
 * Luokka kuuntelee binäärimuuntimen käyttöliittymän klikkauksia.
 */
package fi.jope.gui;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import fi.jope.logiikka.Binaarimuunnin;

public class BinaarimuunninKuuntelija implements ActionListener {

    Binaarimuunnin bm;
    List<JButton> nappaimet;
    JTextField kentta;
    String komento;

    public BinaarimuunninKuuntelija(Binaarimuunnin bm, List nappaimet, JTextField kentta) {
        this.bm = bm;
        this.nappaimet = nappaimet;
        this.kentta = kentta;
        this.komento = "";
    }

    private void tyhjennaKentta() {
        kentta.setText("");
    }

    private void asetaTeksti(String lisattava) {
        kentta.setText(kentta.getText() + lisattava);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String kentanLuku;

        if (kentta.getText().contains("Virhe")) {
            kentanLuku = "";
            tyhjennaKentta();
        } else {
            kentanLuku = kentta.getText();
        }

        JButton nappi = (JButton) ae.getSource();
        String napinTeksti = nappi.getText();

        switch (napinTeksti) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                asetaTeksti(napinTeksti);
                break;
            case "AC":
                tyhjennaKentta();
                bm.setArvo(0);
                break;
            case "dec -> bin":
                bm.setArvo(Long.parseLong(kentanLuku));
                bm.desimaalistaBinaariin();
                tyhjennaKentta();
                asetaTeksti("" + bm.getArvo());
                break;
            case "bin -> dec":
                tyhjennaKentta();
                if (!bm.tarkistaBinaari(kentanLuku)) {
                    asetaTeksti("Virhe: ei binääriluku");
                } else {
                    bm.binaaristaDesimaali(kentanLuku);
                    asetaTeksti("" + bm.getArvo());
                }
                break;
            default:
                bm.setArvo(Long.parseLong(kentanLuku));
                tyhjennaKentta();
                break;
        }
    }

}
