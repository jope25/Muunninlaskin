/**
 * Luokka kuuntelee laskin-toiminnon käyttöliittymän näppäinten klikkauksia.
 */
package fi.jope.kuuntelija;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import fi.jope.logiikka.Laskin;

public class LaskinKuuntelija extends Kuuntelija implements ActionListener {

    Laskin laskin;
    List<JButton> nappaimet;
    List<JButton> toiminnot;
    JTextField kentta;
    String komento;
    JButton piste;
    JButton negatiivinen;

    /**
     * Luodaan laskimen käyttöliittymälle kuuntelija. Parametrien avulla
     * päästään käyttöliittymän näppäimiin käsiksi.
     *
     * @param nappaimet Käyttöliittymän kaikki näppäimet
     * @param toiminnot Käyttöliittymän toiminto näppäimet
     * @param kentta Käyttöliittymän tekstikenttä
     * @param piste Piste näppäin
     * @param negatiivinen Negatiivinen näppäin
     */
    public LaskinKuuntelija(List nappaimet, List toiminnot,
            JTextField kentta, JButton piste, JButton negatiivinen) {
        this.nappaimet = nappaimet;
        this.toiminnot = toiminnot;
        this.kentta = kentta;
        this.piste = piste;
        this.negatiivinen = negatiivinen;
        this.laskin = new Laskin();
        this.komento = "";
    }

    /**
     * Laitetaanko toiminto-näppäimet päälle vai pois.
     *
     * @param poisPaalle Kumpi tehdään - true jos päälle, false jos pois päältä
     */
    public void napitOnOff(boolean poisPaalle) {
        for (JButton jb : toiminnot) {
            jb.setEnabled(poisPaalle);
        }
    }

    private void delPaalle() {
        JButton del = toiminnot.get(9);
        del.setEnabled(true);
    }

    private void toteutaLaskutoiminto(String toiminto, double arvo) {
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
                laskin.jako(arvo);
                break;
            case "x^y":
                laskin.potenssi(arvo);
                break;
            case "y√x":
                laskin.juuri(arvo);
                break;
            case "log_x (y)":
                laskin.logaritmi(arvo);
                break;
            case "nCr":
                if (arvo < 0 || laskin.getArvo() < 0 || laskin.getArvo() % 1 != 0 
                        || arvo % 1 != 0) {
                    asetaTeksti(kentta, "Virhe", true);
                    return;
                } else {
                    laskin.binomikerroin(arvo);
                }
                break;
        }
        asetaTeksti(kentta, "" + laskin.getArvo(), true);
        komento = "";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double kentanLuku = 0;
        String kentanTeksti = kentta.getText();
        if (kentanTeksti.equals("Virhe") || kentanTeksti.equals("NaN")
                || kentanTeksti.equals("Infinity")) {
            tyhjennaKentta(kentta);
        } else if (!kentanTeksti.isEmpty() && !kentanTeksti.equals("-")
                && !kentanTeksti.equals(".")) {
            kentanLuku = Double.parseDouble(kentanTeksti);
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
                asetaTeksti(kentta, napinTeksti, false);
                napitOnOff(true);
                break;
            case ".":
                asetaTeksti(kentta, napinTeksti, false);
                delPaalle();
                break;
            case "(-)":
                asetaTeksti(kentta, "-", false);
                delPaalle();
                break;
            case "=":
                toteutaLaskutoiminto(komento, kentanLuku);
                break;
            case "Clear":
                tyhjennaKentta(kentta);
                laskin.setArvo(0);
                napitOnOff(false);
                komento = "";
                break;
            case "Del":
                asetaTeksti(kentta, kentanTeksti.substring(0, kentanTeksti.length() - 1), true);
                if (kentta.getText().isEmpty()) {
                    napitOnOff(false);
                }
                break;
            default:
                if (!komento.isEmpty()) {
                    asetaTeksti(kentta, "Virhe", true);
                } else {
                    komento = napinTeksti;
                    laskin.setArvo(kentanLuku);
                    tyhjennaKentta(kentta);
                }
                break;
        }
        if (kentta.getText().contains(".")) {
            piste.setEnabled(false);
        } else {
            piste.setEnabled(true);
        }
        if (kentta.getText().isEmpty()) {
            negatiivinen.setEnabled(true);
        } else {
            negatiivinen.setEnabled(false);
        }
        if (kentta.getText().equals("Virhe")) {
            komento = "";
            napitOnOff(false);
            negatiivinen.setEnabled(true);
        }
    }
}
