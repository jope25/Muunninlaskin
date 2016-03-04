/**
 * Luokka luo ASCII-muuntajan käyttöliittymän.
 */
package fi.jope.gui;

import fi.jope.kuuntelija.ASCIIMuuntajaKuuntelija;
import java.awt.*;
import javax.swing.*;

public class ASCIIMuuntajaKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.frame = new JFrame("ASCII-muuntaja");
        frame.setPreferredSize(new Dimension(350, 125));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField kentta = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton clear = new JButton("Clear");
        JButton asciiToString = new JButton("ASCII -> String");
        JButton stringToAscii = new JButton("String -> ASCII");

        ASCIIMuuntajaKuuntelija amk = new ASCIIMuuntajaKuuntelija(asciiToString,
                stringToAscii, clear, kentta);

        clear.addActionListener(amk);
        asciiToString.addActionListener(amk);
        stringToAscii.addActionListener(amk);

        panel.add(asciiToString);
        panel.add(stringToAscii);
        panel.add(clear);

        container.setLayout(new BorderLayout());
        container.add(kentta, BorderLayout.NORTH);
        container.add(panel);
    }
}
