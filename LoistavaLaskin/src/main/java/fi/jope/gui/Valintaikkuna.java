package fi.jope.gui;

import java.awt.*;
import javax.swing.*;

public class Valintaikkuna implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("LoistavaLaskin");
        frame.setPreferredSize(new Dimension(200, 150));
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

        buttonGroup.add(laskin);
        
        ValintaikkunaKuuntelija vik = new ValintaikkunaKuuntelija(laskin, valitse);
        
        laskin.addActionListener(vik);
        valitse.addActionListener(vik);

        container.setLayout(new GridLayout(3, 1));
        container.add(new JLabel("Valitse toiminto:"));
        container.add(laskin);
        container.add(panel, BorderLayout.SOUTH);
    }
}
