/**
 * Luokka luo valintaikkunan, jossa valitaan haluttu toiminto.
 */
package fi.jope.gui;

import fi.jope.kuuntelija.ValintaikkunaKuuntelija;
import java.awt.*;
import javax.swing.*;

public class Valintaikkuna implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.frame = new JFrame("LoistavaLaskin");
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JPanel panel = new JPanel();

        JButton valitse = new JButton("Valitse");
        panel.add(valitse);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton laskin = new JRadioButton("Laskin");
        JRadioButton muuntaja = new JRadioButton("Lukumuuntaja");
        JRadioButton ascii = new JRadioButton("ASCII-muuntaja");

        buttonGroup.add(laskin);
        buttonGroup.add(muuntaja);
        buttonGroup.add(ascii);

        ValintaikkunaKuuntelija vik = new ValintaikkunaKuuntelija(laskin, muuntaja, ascii,
                valitse);

        laskin.addActionListener(vik);
        muuntaja.addActionListener(vik);
        ascii.addActionListener(vik);
        valitse.addActionListener(vik);

        container.setLayout(new GridLayout(5, 1));
        container.add(new JLabel("Valitse toiminto:"));
        container.add(laskin);
        container.add(muuntaja);
        container.add(ascii);
        container.add(panel, BorderLayout.SOUTH);
    }
}
