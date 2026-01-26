package src;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Verse Explorers");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // TO FIT THE WINDOW TO A PREFERRED SIZE

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
