/**
 * Käynnistää ohjelman ja valintaikkunan.
 */
package fi.jope.loistavalaskin;

import fi.jope.gui.Valintaikkuna;
import javax.swing.SwingUtilities;

public class Main {

    /**
     * Käynnistää ohjelman.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Valintaikkuna());
    }
}
