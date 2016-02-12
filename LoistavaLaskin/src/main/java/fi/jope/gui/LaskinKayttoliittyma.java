/*
 * Jos valintaikkunasta valitaan laskin-toiminto, niin tämä luokka luo sen
 * komponentit ja käynnistää sen käyttöliittymän.
 */

package fi.jope.gui;

import java.awt.*;
import javax.swing.*;

public class LaskinKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Laskin");
        frame.setPreferredSize(new Dimension(375, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JTextField kentta = new JTextField("");
        kentta.setPreferredSize(new Dimension(350, 50));
        kentta.setEnabled(false);
        
        container.setLayout(new BorderLayout());
        container.add(kentta, BorderLayout.NORTH);
        container.add(luoNappaimet());
    }
    
    private JPanel luoNappaimet() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(luoVaativatToiminnot());
        panel.add(seiskastaYsiinJaPlus());
        panel.add(nelosestaKutoseenJaMiinus());
        panel.add(ykkosestaKolmoseenJaKerto());
        panel.add(luoNollaPisteMiinusJako());
        return panel;
    }
    
    private JPanel seiskastaYsiinJaPlus() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        
        JButton seiska = new JButton("7");
        JButton kasi = new JButton("8");
        JButton ysi = new JButton("9");
        JButton plus = new JButton("+");
        
        panel.add(seiska);
        panel.add(kasi);
        panel.add(ysi);
        panel.add(plus);
        
        
        return panel;
    }
    
    private JPanel nelosestaKutoseenJaMiinus() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
       
        JButton nelonen = new JButton("4");
        JButton vitonen = new JButton("5");
        JButton kutonen = new JButton("6");
        JButton miinus = new JButton("-");
        
        panel.add(nelonen);
        panel.add(vitonen);
        panel.add(kutonen);
        panel.add(miinus);
        
        return panel;
    }
    
    private JPanel ykkosestaKolmoseenJaKerto() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        
        JButton yksi = new JButton("1");
        JButton kaksi = new JButton("2");
        JButton kolme = new JButton("3");
        JButton kerto = new JButton("x");
        
        panel.add(yksi);
        panel.add(kaksi);
        panel.add(kolme);
        panel.add(kerto);
        
        return panel;
    }
    
    private JPanel luoNollaPisteMiinusJako() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        
        JButton piste = new JButton(".");
        JButton miinus = new JButton("(-)");
        JButton nolla = new JButton("0");
        JButton jako = new JButton("/");
        
        panel.add(nolla);
        panel.add(miinus);
        panel.add(piste);
        panel.add(jako);
        
        return panel;
    }
    
    private JPanel luoVaativatToiminnot() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        
        JButton potenssi = new JButton("x^y");
        JButton juuri = new JButton("√x");
        JButton logaritmi = new JButton("log_x (y)");
        JButton binomi = new JButton("nCr");
        
        panel.add(potenssi);
        panel.add(juuri);
        panel.add(logaritmi);
        panel.add(binomi);
        
        return panel;
    }
}
