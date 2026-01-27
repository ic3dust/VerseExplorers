package src;

// 3D AND 2D VECTORS CONSTRUCTORS
import src.Vec3;
import src.Vec2;

//  IMPORT IN-PROJECT DEPENDENCIES 
import src.CubePointCoords;
import src.WindowDesign;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// GRAPHICS
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.BasicStroke;

// SWING
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.CardLayout;

public class MenuPanel extends JPanel implements Runnable {

    // ------------- SCREEN SETTINGS -----------------

    final int screenWidth = WindowDesign.screenWidth;
    final int screenHeight = WindowDesign.screenHeight;
    // final int compSize = WindowDesign.compSize;

    // ------------- SCREEN SETTINGS -----------------

    // ------------- DESIGNAL ELEMENTS -----------------

    final Color compColor = WindowDesign.compColor;
    final Color darkBg = WindowDesign.darkBg;
    final BasicStroke strokeWidth = WindowDesign.strokeWidth;

    // ------------- DESIGNAL ELEMENTS -----------------

    // 3D -------------------------------------- 3D

    // IF INCREASED - FASTER ANIMATION SPEED
    float animationSpeed = 0.05f;
    // SEEN ON AN ASYMMETRICAL OBJECT
    float angle = 0f;
    float cameraDistance = 1.0f;

    // 3D -------------------------------------- 3D

    // 1000 MS = 1 S, WE NEED 60 FRAMES PER 1000 MS = 1000/60 ~= 16.67 FRAMES(DELAY)
    int delay = 17;

    // ------------- 3D SCREEN -----------------

    // RETURNS VIRTUAL POINTS (2D PROJECTION FOR A "3D" OBJECT)
    public Vec2 screen(float x, float y, float z) {

        float zCamera = z += cameraDistance;

        // THE FARTHER CORNERS APPEAR SMALLER ( AS ZCAMERA INCREASES, SX/SY -
        // DECREASES[PROPORTION X*1/ZCAMERA])
        float sx = x / zCamera;
        float sy = y / zCamera;

        return new Vec2(
                (sx + 1) * 0.5f * screenWidth,
                (1 - sy) * 0.5f * screenHeight);
    }

    // ------------- 3D SCREEN -----------------

    // VIRTUAL CUBE POINTS
    private Vec3[] points = {

            // FRONT FACE(Z = 0.5)
            CubePointCoords.ppp,
            CubePointCoords.Npp,
            CubePointCoords.pNp,
            CubePointCoords.NNp,

            // BACK FACE (Z = -0.5)
            CubePointCoords.ppN,
            CubePointCoords.NpN,
            CubePointCoords.pNN,
            CubePointCoords.NNN,
    };

    // LINES BETWEEN FACES
    int[][] edges = {
            { 0, 1 }, { 1, 3 }, { 3, 2 }, { 2, 0 }, // FRONT FACE
            { 4, 5 }, { 5, 7 }, { 7, 6 }, { 6, 4 }, // BACK FACE
            { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 } // INTERCONNECTIONS
    };

    Thread MenuThread;

    CardLayout cl;
    JPanel cards;

    // MENU PANEL CONSTRUCTOR
    public MenuPanel(JPanel cards) {

        this.cards = cards;
        this.cl = (CardLayout) cards.getLayout();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(darkBg);
        this.setDoubleBuffered(true); // TO IMPROVE MENU PERFORMANCE
        this.setLayout(null);

        // FIRE A TIMER EVERY delay MILLISECONDS
        Timer timer = new Timer(delay, e -> {

            // TO CYCLE

            angle += animationSpeed;
            // ANGLE GOES FROM 0 TO 2π AND "RESTARTS"
            if (angle > 2 * Math.PI) {
                angle -= 2 * Math.PI;
            }
            repaint();

            // TO CYCLE
        });
        timer.start();

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
        });

    }

    /*
     * BUILDING THE ACTUAL CANVAS POINT
     * public void point(Graphics2D g, int x, int y) {
     * g.setColor(compColor);
     * g.fillRect(
     * x - compSize / 2,
     * y - compSize / 2,
     * compSize,
     * compSize); // MOVE TOP AND LEFT BY THE SIZE OF
     * // SQUAREWIDTH/HEIGHT : 2 TO CENTER THE
     * // CENTER POINT OF THE SQUARE(-0.5 width
     * // extent, -0.5 height extent)
     * }
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// CLEAR THE PANEL AND INITIALIZE THE GRAPHICS OBJECT
        Graphics2D g2 = (Graphics2D) g; // CAST GRAPHICS OBJECT INTO A GRAPHICS2D OBJECT

        float c = (float) Math.cos(angle);
        float s = (float) Math.sin(angle);

        Vec2[] screenPoints = new Vec2[points.length];// DYNAMIC ARRAY LENGTH ORIENTATION

        for (int i = 0; i < points.length; i++) {

            Vec3 p = points[i];

            // ROTATED COORDS - Y AXIS STATIC
            float x2 = p.x * c - p.z * s;
            float z2 = p.x * s + p.z * c;

            screenPoints[i] = screen(x2, p.y, z2);// PROJECT THOSE ROTATED POINTS AND STATIC Y ONTO 2D SCREEN SPACE
        }

        g2.setColor(compColor);
        // DRAW LINE OF : CONNECTIONS {0,1} -> POINT 0.X,Y TO POINT 1.X,Y ...
        for (int[] edge : edges) {
            Vec2 p1 = screenPoints[edge[0]];
            Vec2 p2 = screenPoints[edge[1]];
            g2.setStroke(strokeWidth);
            g2.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
        }

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
