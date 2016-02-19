/*
 * Luokka tulee kuuntelemaan laskin-toiminnon käyttöliittymän näppäinten klikkauksia.
 */
package fi.jope.gui;

import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import fi.jope.logiikka.Laskin;

public class LaskinKuuntelija implements ActionListener {

    Map<JButton, String> nappaimet;
    JTextField kentta;
    Laskin laskin;

    public LaskinKuuntelija(Laskin laskin, Map nappaimet, JTextField kentta) {
        this.laskin = laskin;
        this.nappaimet = nappaimet;
        this.kentta = kentta;
    }

    public void tyhjennaKentta() {
        kentta.setText("");
    }

    public void asetaTeksti(int numero) {
        kentta.setText("" + kentta.getText() + numero);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String painetunNapinNimi = "";
        double kentanLuku = Double.parseDouble(0 + kentta.getText());

        for (JButton nappi : nappaimet.keySet()) {
            if (nappi == ae.getSource()) {
                painetunNapinNimi = nappaimet.get(nappi);
            }
        }

        switch (painetunNapinNimi) {
            case "nolla":
                asetaTeksti(0);
                break;
            case "yksi":
                asetaTeksti(1);
                break;
            case "kaksi":
                asetaTeksti(2);
                break;
            case "kolme":
                asetaTeksti(3);
                break;
            case "nelonen":
                asetaTeksti(4);
                break;
            case "vitonen":
                asetaTeksti(5);
                break;
            case "kutonen":
                asetaTeksti(6);
                break;
            case "seiska":
                asetaTeksti(7);
                break;
            case "kasi":
                asetaTeksti(8);
                break;
            case "ysi":
                asetaTeksti(9);
                break;
            case "plus":
                laskin.summa(kentanLuku);
                kentta.setText("" + laskin.getArvo());
                break;
            case "miinus":
                break;
            case "kerto":
                break;
            case "jako":
                break;
            case "piste":
                break;
            case "negatiivinen":
                break;
            case "potenssi":
                break;
            case "juuri":
                break;
            case "logaritmi":
                break;
            case "binomi":
                break;
            case "yhtakuin":
                break;
            case "nollaus":
                break;
            default:
                break;
        }
    }
}
