/**
 * Käynnistää ohjelman ja valintaikkunan.
 */
package fi.jope.gui;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Valintaikkuna());
    }
}
