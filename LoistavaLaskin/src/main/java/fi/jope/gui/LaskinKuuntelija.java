/*
 * Luokka tulee kuuntelemaan laskin-toiminnon käyttöliittymän näppäinten klikkauksia.
 */
package fi.jope.gui;

import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import fi.jope.logiikka.Laskin;

public class LaskinKuuntelija implements ActionListener {

    Laskin laskin;
    Map<JButton, String> nappaimet;
    JTextField kentta;
    String komento;
    boolean toteutaKomento;

    public LaskinKuuntelija(Laskin laskin, Map nappaimet, JTextField kentta) {
        this.laskin = laskin;
        this.nappaimet = nappaimet;
        this.kentta = kentta;
        this.komento = "";
        this.toteutaKomento = false;
    }

    private void tyhjennaKentta() {
        kentta.setText("");
    }

    private void asetaTeksti(int numero) {
        kentta.setText("" + kentta.getText() + numero);
    }

    private void toteutaLaskutoiminto(String toiminto, double arvo) {
        switch (toiminto) {
            case "+":
                laskin.summa(arvo);
                kentta.setText("" + laskin.getArvo());
                break;
            case "-":
                laskin.erotus(arvo);
                kentta.setText("" + laskin.getArvo());
                break;
            case "x":
                laskin.kerto(arvo);
                kentta.setText("" + laskin.getArvo());
                break;
            case "/":
                if (arvo == 0) {
                    kentta.setText("Virhe: Nollalla jako");
                } else {
                    laskin.jako(arvo);
                    kentta.setText("" + laskin.getArvo());
                }
                break;
            case "x^y":
                if (laskin.getArvo() == 0) {
                    kentta.setText("Virhe: Nolla kantalukuna");
                }
                laskin.potenssi(arvo);
                kentta.setText("" + laskin.getArvo());
                break;
            case "√x":
                break;
            case "log_x (y)":
                break;
            case "nCr":
                break;
            default:
                break;
        }
        komento = "";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double kentanLuku;

        if (kentta.getText().contains("Virhe")) {
            kentanLuku = 0;
        } else {
            kentanLuku = Double.parseDouble(0 + kentta.getText());
        }

        JButton nappi = (JButton) ae.getSource();
        String napinTeksti = nappi.getText();

        switch (napinTeksti) {
            case "0":
                asetaTeksti(0);
                break;
            case "1":
                asetaTeksti(1);
                break;
            case "2":
                asetaTeksti(2);
                break;
            case "3":
                asetaTeksti(3);
                break;
            case "4":
                asetaTeksti(4);
                break;
            case "5":
                asetaTeksti(5);
                break;
            case "6":
                asetaTeksti(6);
                break;
            case "7":
                asetaTeksti(7);
                break;
            case "8":
                asetaTeksti(8);
                break;
            case "9":
                asetaTeksti(9);
                break;
            case ".":
                break;
            case "(-)":
                break;
            case "=":
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
