
package fi.jope.gui;

import java.awt.*;
import javax.swing.*;

public class LaskinKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Laskin");
        frame.setPreferredSize(new Dimension(500, 750));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
    }
    
    private JPanel luoNumeroNappaimet() {
        JPanel numerot = new JPanel();
        
        
        return numerot;        
    }
    
}
