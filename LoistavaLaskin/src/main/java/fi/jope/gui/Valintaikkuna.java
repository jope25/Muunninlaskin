/*
 * Luokka luo ja käynnistää valintaikkunan, jossa valitaan haluttu toiminto.
 */
package fi.jope.gui;

import java.awt.*;
import javax.swing.*;

public class Valintaikkuna implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("LoistavaLaskin");
        frame.setPreferredSize(new Dimension(200, 175));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JPanel panel = new JPanel();

        JButton valitse = new JButton("Valitse");
        panel.add(valitse);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton laskin = new JRadioButton("Laskin");
        JRadioButton bm = new JRadioButton("Binäärimuunnin");

        buttonGroup.add(laskin);
        buttonGroup.add(bm);

        ValintaikkunaKuuntelija vik = new ValintaikkunaKuuntelija(laskin, bm, valitse);

        laskin.addActionListener(vik);
        bm.addActionListener(vik);
        valitse.addActionListener(vik);

        container.setLayout(new GridLayout(4, 1));
        container.add(new JLabel("Valitse toiminto:"));
        container.add(laskin);
        container.add(bm);
        container.add(panel, BorderLayout.SOUTH);
    }
}
