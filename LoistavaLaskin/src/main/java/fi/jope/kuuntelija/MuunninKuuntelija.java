/**
 * Luokka kuuntelee binäärimuuntimen käyttöliittymän klikkauksia.
 */
package fi.jope.kuuntelija;

import java.awt.event.*;
import javax.swing.*;
import fi.jope.logiikka.Binaarimuunnin;
import fi.jope.logiikka.Heksadesimaalimuunnin;
import java.util.*;

public class MuunninKuuntelija extends Kuuntelija implements ActionListener {

    Binaarimuunnin bm;
    Heksadesimaalimuunnin hdm;
    JTextField kentta;
    List<JButton> toiminnot;

    /**
     * Luodaan Lukumuuntimen käyttöliittymä. Parametrien avulla päästään
     * tekstikenttään ja toiminto-näppäimiin käsiksi.
     *
     * @param kentta Lukumuuntimen käyttöliittymän tekstikenttä
     * @param toiminnot Lukumuuntimen käyttöliittymän toiminto-nappaimet
     */
    public MuunninKuuntelija(JTextField kentta, List<JButton> toiminnot) {
        this.kentta = kentta;
        this.toiminnot = toiminnot;
        this.bm = new Binaarimuunnin();
        this.hdm = new Heksadesimaalimuunnin();
    }

    /**
     * Laitetaanko toiminto-näppäimet päälle vai pois.
     *
     * @param paallePois Kumpi tehdään - true jos päälle, false jos pois päältä
     */
    public void napitOnOff(boolean paallePois) {
        for (JButton nappi : toiminnot) {
            nappi.setEnabled(paallePois);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String kentanLuku;
            if (kentta.getText().contains("Virhe")) {
                kentanLuku = "";
                tyhjennaKentta(kentta);
            } else {
                kentanLuku = kentta.getText();
            }

            if (kentanLuku.isEmpty()) {
                napitOnOff(false);
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
                case "a":
                case "b":
                case "c":
                case "d":
                case "e":
                case "f":
                    asetaTeksti(kentta, napinTeksti, false);
                    napitOnOff(true);
                    break;
                case "Clear":
                    tyhjennaKentta(kentta);
                    napitOnOff(false);
                    break;
                case "Del":
                    asetaTeksti(kentta, kentanLuku.substring(0, kentanLuku.length() - 1), true);
                    if (kentta.getText().isEmpty()) {
                        napitOnOff(false);
                    }
                    break;
                case "dec->bin":
                    if (!bm.tarkistaDesimaali(kentanLuku)) {
                        asetaTeksti(kentta, "Virhe: ei ole desimaaliluku", true);
                    } else {
                        String s = bm.desimaalistaBinaariin(Long.parseLong(kentanLuku));
                        asetaTeksti(kentta, s, true);
                    }
                    break;
                case "bin->dec":
                    if (!bm.tarkistaBinaari(kentanLuku)) {
                        asetaTeksti(kentta, "Virhe: ei binääriluku", true);
                    } else {
                        long l = bm.binaaristaDesimaali(kentanLuku);
                        asetaTeksti(kentta, "" + l, true);
                    }
                    break;
                case "dec->hex":
                    if (!hdm.tarkistaDesimaali(kentanLuku)) {
                        asetaTeksti(kentta, "Virhe: ei ole desimaaliluku", true);
                    } else {
                        String s = hdm.desimaalistaHeksadesimaali(Long.parseLong(kentanLuku));
                        asetaTeksti(kentta, s, true);
                    }
                    break;
                case "hex->dec":
                    if (!hdm.tarkistaHeksa(kentanLuku)) {
                        asetaTeksti(kentta, "Virhe: ei heksadesimaali", true);
                    } else {
                        long l = hdm.heksadesimaalistaDesimaal(kentanLuku);
                        asetaTeksti(kentta, "" + l, true);
                    }
                    break;
            }
            if (kentta.getText().contains("Virhe")) {
                napitOnOff(false);
            }
        } catch (Exception e) {
            asetaTeksti(kentta, "Virhe: liian pitkä syöte/tulos", true);
        }
    }

}
