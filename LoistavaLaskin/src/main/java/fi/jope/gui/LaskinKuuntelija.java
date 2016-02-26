/**
 * Luokka kuuntelee laskin-toiminnon käyttöliittymän näppäinten klikkauksia.
 */
package fi.jope.gui;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import fi.jope.logiikka.Laskin;

public class LaskinKuuntelija implements ActionListener {

    Laskin laskin;
    List<JButton> nappaimet;
    JTextField kentta;
    String komento;

    public LaskinKuuntelija(Laskin laskin, List nappaimet, JTextField kentta) {
        this.laskin = laskin;
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

    private void toteutaLaskutoiminto(String toiminto, double arvo) {
        String virheIlmoitus = "";
        
        switch (toiminto) {
            case "+":
                laskin.summa(arvo);
                break;
            case "-":
                laskin.erotus(arvo);
                break;
            case "x":
                laskin.kerto(arvo);
                break;
            case "/":
                if (arvo == 0) {
                    virheIlmoitus = "Virhe: nollalla jako";
                } else {
                    laskin.jako(arvo);
                }
                break;
            case "x^y":
                if (laskin.getArvo() == 0) {
                    virheIlmoitus = "Virhe: nolla kantalukuna";
                }
                laskin.potenssi(arvo);
                break;
            case "y√x":
                laskin.juuri(arvo);
                break;
            case "log_x (y)":
                laskin.logaritmi(arvo);
                break;
            case "nCr":
                laskin.binomikerroin(arvo);
                break;
            default:
                break;
        }
        if (!virheIlmoitus.equals("")) {
            asetaTeksti(virheIlmoitus);
        } else {
            asetaTeksti("" + laskin.getArvo());
        }
        komento = "";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double kentanLuku;

        if (kentta.getText().contains("Virhe")) {
            kentanLuku = 0;
            tyhjennaKentta();
        } else {
            try {
                kentanLuku = Double.parseDouble(0 + kentta.getText());
            } catch (Exception e) {
                tyhjennaKentta();
                asetaTeksti("Virhe: liikaa desimaalipilkkuja");
                kentanLuku = 0;
                return;
            }
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
            case ".":
                asetaTeksti(napinTeksti);
                break;
            case "(-)":
                break;
            case "=":
                tyhjennaKentta();
                toteutaLaskutoiminto(komento, kentanLuku);
                break;
            case "AC":
                tyhjennaKentta();
                laskin.setArvo(0);
                break;
            default:
                komento = napinTeksti;
                laskin.setArvo(kentanLuku);
                tyhjennaKentta();
                break;
        }
    }
}
