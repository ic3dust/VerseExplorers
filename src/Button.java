package src;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.GradientPaint;
import java.awt.BasicStroke;
import java.awt.FontMetrics;
import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class Button extends JButton {

    final Color BTNtext = Color.decode("#C5F1E6");
    final Color gradTop = Color.decode("#165F4D");
    final Color gradBot = Color.decode("#56D7B7");
    // final Color shadow = new Color(0, 0, 0, 80);
    int hoverGrow = 10;
    private int btnW, btnH;
    private final int dfBtnW, dfBtnH;

    private float scale = 1.0f;
    private float textScale = 1.0f;
    private float targetScale = 1.0f; // ANIMATION EXTENT
    private float targetTextScale = 1.0f; // TEXT ANIMATION EXTENT
    final float smoothing = 0.5f; // ANIMATION SPEED
    Rectangle baseBounds;

    // DEFAULT: new Button("Start", 0.5f, 0.33f, this); <-- NO width AND height =
    // DEFAULT width AND height
    public Button(String placeholder, float px, float py, JPanel panel) {
        this(placeholder, px, py, panel, 200, 64);
    }

    public Button(String placeholder, float px, float py, JPanel panel, int width, int height) {

        super(placeholder);

        this.btnW = width;
        this.btnH = height;
        this.dfBtnW = width;
        this.dfBtnH = height;

        int x = (int) (px * panel.getWidth()) / 2;
        int y = (int) (py * panel.getHeight()) / 2;

        setBounds(
                (int) (x - btnW / 2),
                (int) (y - btnH / 2),
                (int) (btnW),
                (int) (btnH));
        baseBounds = getBounds();

        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        setFont(new Font("Tahoma", Font.PLAIN, 16));
        setForeground(BTNtext);

        installHoverAnimation();
        animate();
    }

    public void scaleBase(float factor) {
        btnW = (int) (dfBtnW * factor);
        btnH = (int) (dfBtnH * factor);

        baseBounds = new Rectangle(
                baseBounds.x + (baseBounds.width - btnW) / 2,
                baseBounds.y + (baseBounds.height - btnH) / 2,
                btnW,
                btnH

        );

    }

    private void installHoverAnimation() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                targetScale += 0.05f;
                targetTextScale += 0.05f;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                targetScale = 1.0f;
                targetTextScale = 1.0f;

            }
        });
    }

    private void animate() {
        Timer timer = new Timer(16, e -> {

            scale += (targetScale - scale) * smoothing;
            textScale += (targetTextScale - textScale) * smoothing;

            int w = (int) (baseBounds.width * scale);
            int h = (int) (baseBounds.height * scale);

            int x = baseBounds.x + (baseBounds.width - w) / 2;
            int y = baseBounds.y + (baseBounds.height - h) / 2;

            setBounds(x, y, w, h);
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();
        int cornerRadius = 16;
        // g2.setColor(shadow);
        // NOT FILL g2.fillRoundRect(3, 4, width - 6, height - 6, cornerRadius,
        // cornerRadius);

        GradientPaint gradient = new GradientPaint(
                0, 0, gradTop,
                0, getHeight(), gradBot);

        g2.setPaint(gradient);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // FONT
        Font scaledFont = getFont().deriveFont(getFont().getSize2D() * textScale);
        g2.setFont(scaledFont);

        FontMetrics fm = g2.getFontMetrics(scaledFont);
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();// ASCENT - HEIGHT FROM BASELINE TO TOP OF THE TEXT
        // CENTER THE TEXT
        int x = (width - textWidth) / 2;
        int y = (height + textHeight) / 2;
        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);
        // FONT

        g2.dispose();

        super.paintComponent(g2);
    }
}
