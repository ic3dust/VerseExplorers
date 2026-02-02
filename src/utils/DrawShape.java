package src.utils;

import src.utils.Vec2;
import src.utils.Vec3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.Timer;
import javax.swing.JPanel;

public class DrawShape extends JPanel {

    // ------------- SCREEN SETTINGS -----------------

    final int screenWidth = WindowDesign.screenWidth;
    final int screenHeight = WindowDesign.screenHeight;
    final int compSize = WindowDesign.compSize;

    // ------------- SCREEN SETTINGS -----------------

    // ------------- DESIGNAL ELEMENTS -----------------

    final Color compColor = WindowDesign.compColor;
    final BasicStroke strokeWidth = WindowDesign.strokeWidth;

    // ------------- DESIGNAL ELEMENTS -----------------

    // VIRTUAL CUBE POINTS
    private Vec3[] points = {

            /*
             * // FRONT FACE(Z = 0.5)
             * ShapeVertices.ppp,
             * ShapeVertices.Npp,
             * ShapeVertices.pNp,
             * ShapeVertices.NNp,
             * 
             * // BACK FACE (Z = -0.5)
             * ShapeVertices.ppN,
             * ShapeVertices.NpN,
             * ShapeVertices.pNN,
             * ShapeVertices.NNN,
             */

            ShapeVertices.v0,
            ShapeVertices.v1,
            ShapeVertices.v2,
            ShapeVertices.v3,
            ShapeVertices.v4,
            ShapeVertices.v5,
            ShapeVertices.v6,
            ShapeVertices.v7,
            ShapeVertices.v8,
            ShapeVertices.v9,
            ShapeVertices.v10,
            ShapeVertices.v11,
            ShapeVertices.v12,
            ShapeVertices.v13,
            ShapeVertices.v14,
            ShapeVertices.v15,
            ShapeVertices.v16,
            ShapeVertices.v17,
            ShapeVertices.v18,
            ShapeVertices.v19,
            ShapeVertices.v20,
            ShapeVertices.v21,
            ShapeVertices.v22,
            ShapeVertices.v23,
            ShapeVertices.v24,
            ShapeVertices.v25,
            ShapeVertices.v26,
            ShapeVertices.v27,
            ShapeVertices.v28,
            ShapeVertices.v29,
            ShapeVertices.v30,
            ShapeVertices.v31,
            ShapeVertices.v32,
            ShapeVertices.v33,
            ShapeVertices.v34,
            ShapeVertices.v35,
            ShapeVertices.v36,
            ShapeVertices.v37,
            ShapeVertices.v38,
            ShapeVertices.v39,
            ShapeVertices.v40,
            ShapeVertices.v41,
            ShapeVertices.v42,
            ShapeVertices.v43,
            ShapeVertices.v44,
            ShapeVertices.v45,
            ShapeVertices.v46,
            ShapeVertices.v47,
            ShapeVertices.v48,
            ShapeVertices.v49,
            ShapeVertices.v50,
            ShapeVertices.v51,
            ShapeVertices.v52,
            ShapeVertices.v53,
            ShapeVertices.v54,
            ShapeVertices.v55,
            ShapeVertices.v56,
            ShapeVertices.v57,
            ShapeVertices.v58,
            ShapeVertices.v59,
            ShapeVertices.v60,
            ShapeVertices.v61,
            ShapeVertices.v62,
            ShapeVertices.v63,
            ShapeVertices.v64,
            ShapeVertices.v65,
            ShapeVertices.v66,
            ShapeVertices.v67,
            ShapeVertices.v68,
            ShapeVertices.v69,
            ShapeVertices.v70,
            ShapeVertices.v71,
            ShapeVertices.v72,
            ShapeVertices.v73,
            ShapeVertices.v74,
            ShapeVertices.v75,
            ShapeVertices.v76,
            ShapeVertices.v77,
            ShapeVertices.v78,
            ShapeVertices.v79,
            ShapeVertices.v80,
            ShapeVertices.v81,
            ShapeVertices.v82,
            ShapeVertices.v83,
            ShapeVertices.v84,
            ShapeVertices.v85,
            ShapeVertices.v86,
            ShapeVertices.v87,
            ShapeVertices.v88,
            ShapeVertices.v89,
            ShapeVertices.v90,
            ShapeVertices.v91,
            ShapeVertices.v92,
            ShapeVertices.v93,
            ShapeVertices.v94,
            ShapeVertices.v95,
            ShapeVertices.v96,
            ShapeVertices.v97,
            ShapeVertices.v98,
            ShapeVertices.v99,
            ShapeVertices.v100,
            ShapeVertices.v101,
            ShapeVertices.v102,
            ShapeVertices.v103,
            ShapeVertices.v104,
            ShapeVertices.v105,
            ShapeVertices.v106,
            ShapeVertices.v107,
            ShapeVertices.v108,
            ShapeVertices.v109,
            ShapeVertices.v110,
            ShapeVertices.v111,
            ShapeVertices.v112,
            ShapeVertices.v113,
            ShapeVertices.v114,
            ShapeVertices.v115,
            ShapeVertices.v116,
            ShapeVertices.v117,
            ShapeVertices.v118,
            ShapeVertices.v119,
            ShapeVertices.v120,
            ShapeVertices.v121,
            ShapeVertices.v122,
            ShapeVertices.v123,
            ShapeVertices.v124,
            ShapeVertices.v125,
            ShapeVertices.v126,
            ShapeVertices.v127,
            ShapeVertices.v128,
            ShapeVertices.v129,
            ShapeVertices.v130,
            ShapeVertices.v131,
            ShapeVertices.v132,
            ShapeVertices.v133,
            ShapeVertices.v134,
            ShapeVertices.v135,
            ShapeVertices.v136,
            ShapeVertices.v137,
            ShapeVertices.v138,
            ShapeVertices.v139,
            ShapeVertices.v140,
            ShapeVertices.v141,
            ShapeVertices.v142,
            ShapeVertices.v143,
            ShapeVertices.v144,
            ShapeVertices.v145,
            ShapeVertices.v146,
            ShapeVertices.v147,
            ShapeVertices.v148,
            ShapeVertices.v149,
            ShapeVertices.v150,
            ShapeVertices.v151,
            ShapeVertices.v152,
            ShapeVertices.v153,
            ShapeVertices.v154,
            ShapeVertices.v155,
            ShapeVertices.v156,
            ShapeVertices.v157,
            ShapeVertices.v158,
            ShapeVertices.v159,
            ShapeVertices.v160,
            ShapeVertices.v161,
            ShapeVertices.v162,
            ShapeVertices.v163,
            ShapeVertices.v164,
            ShapeVertices.v165,
            ShapeVertices.v166,
            ShapeVertices.v167,
            ShapeVertices.v168,
            ShapeVertices.v169,
            ShapeVertices.v170,
            ShapeVertices.v171,
            ShapeVertices.v172,
            ShapeVertices.v173,
            ShapeVertices.v174,
            ShapeVertices.v175,
            ShapeVertices.v176,
            ShapeVertices.v177,
            ShapeVertices.v178,
            ShapeVertices.v179,
            ShapeVertices.v180,
            ShapeVertices.v181,
            ShapeVertices.v182,
            ShapeVertices.v183,
            ShapeVertices.v184,
            ShapeVertices.v185,
            ShapeVertices.v186,
            ShapeVertices.v187,
            ShapeVertices.v188,
            ShapeVertices.v189,
            ShapeVertices.v190,
            ShapeVertices.v191,
            ShapeVertices.v192,
            ShapeVertices.v193,
            ShapeVertices.v194,
            ShapeVertices.v195,
            ShapeVertices.v196,
            ShapeVertices.v197,
            ShapeVertices.v198,
            ShapeVertices.v199,
            ShapeVertices.v200,
            ShapeVertices.v201,
            ShapeVertices.v202,
            ShapeVertices.v203,
            ShapeVertices.v204,
            ShapeVertices.v205,
            ShapeVertices.v206,
            ShapeVertices.v207,
            ShapeVertices.v208,
            ShapeVertices.v209,
            ShapeVertices.v210,
            ShapeVertices.v211,
            ShapeVertices.v212,
            ShapeVertices.v213,
            ShapeVertices.v214,
            ShapeVertices.v215,
            ShapeVertices.v216,
            ShapeVertices.v217,
            ShapeVertices.v218,
            ShapeVertices.v219,
            ShapeVertices.v220,
            ShapeVertices.v221,
            ShapeVertices.v222,
            ShapeVertices.v223,
            ShapeVertices.v224,
            ShapeVertices.v225,
            ShapeVertices.v226,
            ShapeVertices.v227,
            ShapeVertices.v228,
            ShapeVertices.v229,
            ShapeVertices.v230,
            ShapeVertices.v231,
            ShapeVertices.v232,
            ShapeVertices.v233,
            ShapeVertices.v234,
            ShapeVertices.v235,
            ShapeVertices.v236,
            ShapeVertices.v237,
            ShapeVertices.v238,
            ShapeVertices.v239,
            ShapeVertices.v240,
            ShapeVertices.v241,
            ShapeVertices.v242,
            ShapeVertices.v243

    };
    // LINES BETWEEN FACES
    /*
     * int[][] edges = {
     * { 0, 1 }, { 1, 3 }, { 3, 2 }, { 2, 0 }, // FRONT FACE
     * { 4, 5 }, { 5, 7 }, { 7, 6 }, { 6, 4 }, // BACK FACE
     * { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 } // INTERCONNECTIONS
     * };
     */

    // FOR LINES BETWEEN FACES
    int[][] edges = {
            { 0, 1 },
            { 0, 54 },
            { 52, 54 },
            { 1, 52 },
            { 1, 68 },
            { 67, 68 },
            { 0, 67 },
            { 40, 145 },
            { 145, 162 },
            { 40, 162 },
            { 185, 237 },
            { 237, 242 },
            { 185, 242 },
            { 2, 3 },
            { 2, 4 },
            { 4, 5 },
            { 3, 5 },
            { 3, 6 },
            { 6, 10 },
            { 9, 10 },
            { 9, 12 },
            { 12, 69 },
            { 15, 69 },
            { 15, 16 },
            { 16, 25 },
            { 25, 165 },
            { 108, 165 },
            { 76, 108 },
            { 76, 98 },
            { 78, 98 },
            { 78, 96 },
            { 80, 96 },
            { 80, 94 },
            { 88, 94 },
            { 88, 89 },
            { 89, 90 },
            { 90, 101 },
            { 100, 101 },
            { 85, 100 },
            { 84, 85 },
            { 82, 84 },
            { 82, 154 },
            { 111, 154 },
            { 110, 111 },
            { 110, 114 },
            { 74, 114 },
            { 74, 116 },
            { 72, 116 },
            { 72, 119 },
            { 118, 119 },
            { 118, 122 },
            { 70, 122 },
            { 70, 124 },
            { 104, 124 },
            { 104, 126 },
            { 126, 152 },
            { 129, 152 },
            { 128, 129 },
            { 128, 132 },
            { 132, 137 },
            { 136, 137 },
            { 135, 136 },
            { 135, 140 },
            { 140, 150 },
            { 142, 150 },
            { 142, 146 },
            { 145, 146 },
            { 39, 40 },
            { 39, 51 },
            { 51, 54 },
            { 63, 67 },
            { 42, 63 },
            { 42, 106 },
            { 65, 106 },
            { 55, 65 },
            { 55, 56 },
            { 56, 60 },
            { 48, 60 },
            { 44, 48 },
            { 44, 45 },
            { 37, 45 },
            { 35, 37 },
            { 32, 35 },
            { 31, 32 },
            { 31, 61 },
            { 29, 61 },
            { 22, 29 },
            { 21, 22 },
            { 19, 21 },
            { 2, 19 },
            { 168, 169 },
            { 169, 171 },
            { 170, 171 },
            { 170, 172 },
            { 172, 199 },
            { 173, 199 },
            { 173, 174 },
            { 174, 178 },
            { 178, 243 },
            { 219, 243 },
            { 203, 219 },
            { 203, 214 },
            { 204, 214 },
            { 204, 213 },
            { 205, 213 },
            { 205, 212 },
            { 209, 212 },
            { 209, 210 },
            { 210, 211 },
            { 211, 216 },
            { 215, 216 },
            { 208, 215 },
            { 207, 208 },
            { 206, 207 },
            { 206, 241 },
            { 221, 241 },
            { 220, 221 },
            { 220, 222 },
            { 202, 222 },
            { 202, 223 },
            { 201, 223 },
            { 201, 225 },
            { 224, 225 },
            { 224, 226 },
            { 200, 226 },
            { 200, 227 },
            { 217, 227 },
            { 217, 228 },
            { 228, 240 },
            { 230, 240 },
            { 229, 230 },
            { 229, 231 },
            { 231, 234 },
            { 233, 234 },
            { 232, 233 },
            { 232, 235 },
            { 235, 239 },
            { 236, 239 },
            { 236, 238 },
            { 237, 238 },
            { 184, 185 },
            { 184, 190 },
            { 190, 191 },
            { 166, 191 },
            { 166, 198 },
            { 196, 198 },
            { 186, 196 },
            { 186, 218 },
            { 197, 218 },
            { 192, 197 },
            { 192, 193 },
            { 193, 194 },
            { 189, 194 },
            { 187, 189 },
            { 187, 188 },
            { 183, 188 },
            { 182, 183 },
            { 181, 182 },
            { 180, 181 },
            { 180, 195 },
            { 179, 195 },
            { 177, 179 },
            { 176, 177 },
            { 175, 176 },
            { 167, 175 },
            { 167, 168 },
            { 7, 8 },
            { 7, 10 },
            { 6, 8 },
            { 5, 8 },
            { 9, 11 },
            { 7, 11 },
            { 12, 13 },
            { 13, 14 },
            { 14, 69 },
            { 11, 13 },
            { 15, 17 },
            { 17, 18 },
            { 16, 18 },
            { 14, 17 },
            { 19, 20 },
            { 4, 20 },
            { 21, 23 },
            { 20, 23 },
            { 22, 24 },
            { 23, 24 },
            { 29, 30 },
            { 24, 30 },
            { 18, 26 },
            { 25, 26 },
            { 26, 28 },
            { 27, 28 },
            { 25, 27 },
            { 61, 62 },
            { 30, 62 },
            { 31, 33 },
            { 32, 34 },
            { 33, 34 },
            { 33, 62 },
            { 34, 36 },
            { 35, 36 },
            { 37, 38 },
            { 36, 38 },
            { 41, 50 },
            { 39, 50 },
            { 40, 41 },
            { 45, 47 },
            { 38, 47 },
            { 44, 46 },
            { 46, 47 },
            { 57, 60 },
            { 49, 57 },
            { 48, 49 },
            { 46, 49 },
            { 51, 53 },
            { 50, 53 },
            { 52, 53 },
            { 55, 58 },
            { 58, 59 },
            { 56, 59 },
            { 57, 59 },
            { 63, 64 },
            { 43, 64 },
            { 42, 43 },
            { 64, 68 },
            { 65, 66 },
            { 58, 66 },
            { 86, 87 },
            { 84, 86 },
            { 85, 87 },
            { 83, 86 },
            { 82, 83 },
            { 90, 93 },
            { 93, 103 },
            { 101, 103 },
            { 88, 91 },
            { 91, 92 },
            { 89, 92 },
            { 92, 93 },
            { 80, 81 },
            { 81, 95 },
            { 94, 95 },
            { 91, 95 },
            { 78, 79 },
            { 79, 97 },
            { 96, 97 },
            { 81, 97 },
            { 76, 77 },
            { 77, 99 },
            { 98, 99 },
            { 79, 99 },
            { 156, 157 },
            { 157, 159 },
            { 158, 159 },
            { 156, 158 },
            { 87, 102 },
            { 100, 102 },
            { 102, 103 },
            { 106, 107 },
            { 43, 107 },
            { 66, 107 },
            { 108, 109 },
            { 77, 109 },
            { 112, 113 },
            { 110, 112 },
            { 111, 113 },
            { 114, 115 },
            { 112, 115 },
            { 75, 115 },
            { 74, 75 },
            { 116, 117 },
            { 75, 117 },
            { 73, 117 },
            { 72, 73 },
            { 119, 121 },
            { 73, 121 },
            { 120, 121 },
            { 118, 120 },
            { 122, 123 },
            { 120, 123 },
            { 71, 123 },
            { 70, 71 },
            { 162, 163 },
            { 160, 162 },
            { 160, 161 },
            { 161, 163 },
            { 124, 125 },
            { 71, 125 },
            { 105, 125 },
            { 104, 105 },
            { 126, 127 },
            { 105, 127 },
            { 127, 153 },
            { 152, 153 },
            { 129, 131 },
            { 131, 153 },
            { 130, 131 },
            { 128, 130 },
            { 132, 134 },
            { 130, 134 },
            { 133, 134 },
            { 133, 137 },
            { 136, 139 },
            { 133, 139 },
            { 138, 139 },
            { 135, 138 },
            { 140, 141 },
            { 138, 141 },
            { 141, 151 },
            { 150, 151 },
            { 142, 143 },
            { 143, 151 },
            { 143, 149 },
            { 146, 149 },
            { 145, 148 },
            { 148, 149 },
            { 147, 148 },
            { 144, 147 },
            { 144, 145 },
            { 83, 155 },
            { 154, 155 },
            { 113, 155 }
    };
    // 3D -------------------------------------- 3D

    // IF INCREASED - FASTER ANIMATION SPEED
    float animationSpeed = 0.05f;
    // SEEN ON AN ASYMMETRICAL OBJECT
    float angle = 0f;
    float cameraDistance = 2.0f;

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

    // CONSTRUCTOR

    public DrawShape() {

        this.setDoubleBuffered(true); // TO IMPROVE REPAINTING PERFORMANCE:
        // DRAWING HAPPENS IN MEMORY(OFF-SCRREEN BUFFER), AND FRAMES GET COPIED TO THE
        // SCREEN AFTER BEING FULLY DRAWN
        this.setLayout(null);// AUTOMATIC RESIZING, AUTOPLACEMENT: FALSE
        this.setOpaque(false);

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
    }

    // BUILDING THE ACTUAL CANVAS POINT
    public void point(Graphics2D g, int x, int y) {
        g.setColor(compColor);
        g.fillRect(
                x - compSize / 2, // center at center
                y - compSize / 2, // center at center
                compSize,
                compSize);
        // MOVE TOP AND LEFT BY THE SIZE OF
        // SQUAREWIDTH/HEIGHT : 2 TO CENTER THE
        // CENTER POINT OF THE SQUARE(-0.5 width
        // extent, -0.5 height extent)
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// CLEAR THE PANEL AND INITIALIZE THE GRAPHICS OBJECT
        Graphics2D g2 = (Graphics2D) g; // CAST GRAPHICS OBJECT INTO A GRAPHICS2D OBJECT

        Vec2[] screenPoints = new Vec2[points.length];
        // CREATING AN ARRAY TO STORE PROJECTED SCREEN 2D POINTS FOR A 3D POINT AFTER
        // ROTATION
        float c = (float) Math.cos(angle);
        float s = (float) Math.sin(angle);

        Vec3 center = new Vec3(0, 0, 0);
        for (Vec3 p : points) {

            // ADD EACH POINT COORDS TO CENTER COORDS
            // TO STORE THE SUM OF ALL POINTS COORDS AFTE RTHE LOOP
            center.x += p.x;
            center.y += p.y;
            center.z += p.z;
        }
        // DIVIDE EACH OF THOSE SUMMED COORDS BY THE AMOUNT OF POINTS TO AVERAGE THE
        // GEOMETRIC CENTER OF THE SHAPE
        // CENTROID
        center.x /= points.length;
        center.y /= points.length;
        center.z /= points.length;

        for (int i = 0; i < points.length; i++) {
            Vec3 point = points[i];// INITIALIZE CURRENT POINT AS I INDEX OF A LOOP

            // THESE LINES CENTER THE ROTATION AXIS
            // ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

            // SUBTRACT AVERAGED CENTER PPOSITIONS TO MAKE THE POINTS COORDS RELATIVE TO THE
            // CENTER OF (0, 0, 0)
            // VERY INTUITIVE, I GET IT NOW, BUT MAY NOT BE ABLE TO REMEMBER AND REDISCRIBE
            // THIS IN FUTURE, IF I FORGET MATHS
            float x = point.x - center.x;
            float y = point.y - center.y;
            float z = point.z - center.z;

            // ROTATED VECTOR FORMULA(X,Z BC AROUND Y AXIS)
            float x2 = x * c - z * s;
            float z2 = x * s + z * c;

            // x2 += center.x;
            // z2 += center.z;

            // ^^^^^^^^^^^^^^^^^^^^^^
            // THESE LINES CENTER THE ROTATION AXIS

            screenPoints[i] = screen(x2, y, z2);

        }

        /*
         * for (int i = 0; i < points.length; i++) {
         * 
         * Vec3 p = points[i];
         * 
         * // ROTATED COORDS - Y AXIS STATIC
         * float x2 = p.x * c - p.z * s;
         * float z2 = p.x * s + p.z * c;
         * 
         * screenPoints[i] = screen(x2, p.y, z2);// PROJECT THOSE ROTATED POINTS AND
         * // STATIC Y ONTO 2D SCREEN SPACE
         * }
         */

        g2.setColor(compColor);
        g2.setStroke(strokeWidth);

        // DRAW LINE OF : CONNECTIONS {0,1} -> POINT 0.X,Y TO POINT 1.X,Y ...

        // USING PATH TO DRAW THE LINE ONCE, FROM POSITION TO POSITION, NOT WITH A
        // SINGLE SEPARATE LINES

        Path2D path = new Path2D.Float();
        for (int[] edge : edges) {
            Vec2 p1 = screenPoints[edge[0]];
            Vec2 p2 = screenPoints[edge[1]];
            path.moveTo(p1.x, p1.y);
            path.lineTo(p2.x, p2.y);
        }
        g2.draw(path);

        // DRAW POINTS
        /*
         * 
         * for (Vec2 sp : screenPoints) {
         * point(g2, (int) sp.x, (int) sp.y);
         * }
         * 
         */

        // for (Vec3 p : points) {
        // point(g2, (int) sp.x, (int) sp.y);
        // }

    }
}
