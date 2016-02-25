package fi.jope.gui;

import fi.jope.logiikka.Binaarimuunnin;
import java.awt.*;
import javax.swing.*;

public class BinaarimuunninKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Binäärimuunnin");
        frame.setPreferredSize(new Dimension(375, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField kentta = new JTextField("");
        kentta.setPreferredSize(new Dimension(375, 50));
        kentta.setEnabled(false);

        container.setLayout(new BorderLayout());
        container.add(kentta, BorderLayout.NORTH);
    }
}
