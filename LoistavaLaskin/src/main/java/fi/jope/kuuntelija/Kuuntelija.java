/**
 * Luokka määrittelee kaksi metodia, joilla käsitellään kuuntelijan käyttöliitymän
 * tekstikenttää.
 */
package fi.jope.kuuntelija;

import javax.swing.JTextField;

public abstract class Kuuntelija {

    protected void tyhjennaKentta(JTextField kentta) {
        kentta.setText("");
    }

    protected void asetaTeksti(JTextField kentta, String lisattava, boolean tyhjennaEnsin) {
        if (tyhjennaEnsin) {
            kentta.setText(lisattava);
        } else {
            kentta.setText(kentta.getText() + lisattava);
        }
    }
}
