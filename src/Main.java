package src;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        JPanel cards = new JPanel(new CardLayout());

        MenuPanel menuPanel = new MenuPanel(cards);
        SettingsPanel settingsPanel = new SettingsPanel(cards);

        cards.add(menuPanel, "Menu");
        cards.add(settingsPanel, "Settings");
        window.add(cards);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        // GamePanel gamePanel = new GamePanel();

        window.pack(); // TO FIT THE WINDOW TO A PREFERRED SIZE

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
