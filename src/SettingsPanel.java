package src;

// IN-PROJECT DEPENDENCIES
import src.WindowDesign;

// SWING
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.CardLayout;

public class SettingsPanel extends JPanel {

    // ------------- SCREEN SETTINGS -----------------

    final int screenWidth = WindowDesign.screenWidth;
    final int screenHeight = WindowDesign.screenHeight;

    // ------------- SCREEN SETTINGS -----------------

    // ------------- DESIGNAL ELEMENTS -----------------

    final Color compColor = WindowDesign.compColor;
    final Color darkBg = WindowDesign.darkBg;
    final BasicStroke strokeWidth = WindowDesign.strokeWidth;

    // ------------- DESIGNAL ELEMENTS -----------------

    CardLayout cl;
    JPanel cards;

    public SettingsPanel(JPanel cards) {

        this.cards = cards;
        this.cl = (CardLayout) cards.getLayout();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(darkBg);
        this.setDoubleBuffered(true); // TO IMPROVE SETTINGS PERFORMANCE
        this.setLayout(null);

        SwingUtilities.invokeLater(() -> {

            Button back = new Button("Back", 0.3f, 0.1f, this);
            back.scaleBase(0.52f);
            back.addActionListener(e -> cl.show(cards, "Menu"));

            Button mute = new Button("Mute", 0.5f * 2, 0.5f, this/* 200,64 */);
            Button volume = new Button("Volume", 0.5f * 2, 0.5f * 2, this/* 200,64 */);
            Button theme = new Button("Change theme", 0.5f * 2, 0.5f * 3, this/* 200,64 */);
            this.add(back);
            this.add(mute);
            this.add(volume);
            this.add(theme);

        });

    }
}
