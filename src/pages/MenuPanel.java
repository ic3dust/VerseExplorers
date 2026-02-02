package src.pages;

import src.utils.*;

// GRAPHICS
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BasicStroke;

// SWING
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.CardLayout;

public class MenuPanel extends JPanel implements Runnable {

    // ------------- SCREEN SETTINGS -----------------

    final int screenWidth = WindowDesign.screenWidth;
    final int screenHeight = WindowDesign.screenHeight;
    final int compSize = WindowDesign.compSize;

    // ------------- SCREEN SETTINGS -----------------

    // ------------- DESIGNAL ELEMENTS -----------------

    final Color compColor = WindowDesign.compColor;
    final Color darkBg = WindowDesign.darkBg;
    final BasicStroke strokeWidth = WindowDesign.strokeWidth;

    // ------------- DESIGNAL ELEMENTS -----------------

    Thread MenuThread;

    CardLayout cl;
    JPanel cards;

    // MENU PANEL CONSTRUCTOR
    public MenuPanel(JPanel cards) {

        this.cards = cards;
        this.cl = (CardLayout) cards.getLayout();// CASTING TO BE ABLE TO USE METHODS OF CARDLAYOUT

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(darkBg);
        this.setDoubleBuffered(true); // TO IMPROVE MENU PERFORMANCE
        this.setLayout(null);

        // RUN THIS AFTER AFTER THE PANEL IS LAID OUT
        SwingUtilities.invokeLater(() -> {

            Button start = new Button("Start", 0.5f, 0.33f, this);

            Button settings = new Button("Settings", 0.5f, 0.66f, this);
            settings.addActionListener(e -> cl.show(cards, "Settings"));

            Button exit = new Button("Exit", 0.5f, 0.99f, this);

            this.add(start);
            this.add(settings);
            this.add(exit);
            // Button mute = new Button("Start", 0.5f, 0.33f, this);
            // this.add(start);

            DrawShape drawShape = new DrawShape();
            drawShape.setBounds(0, 0, screenWidth, screenHeight);
            add(drawShape);
            setComponentZOrder(drawShape, getComponentCount() - 1);
        });

    }

    public void startMenuThread() {
        MenuThread = new Thread(this); // MENU PANEL IS PASSED TO A THREAD CONSTRUCTOR
        MenuThread.start();
    }

    @Override
    public void run() {
        // MENU LOOP
    }

}
