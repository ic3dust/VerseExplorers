package src;

import java.awt.Color;
import java.awt.BasicStroke;

public class WindowDesign {

    // ------------- DESIGNAL ELEMENTS -----------------

    final static Color darkBg = Color.decode("#051511");
    final static Color compColor = Color.decode("#30C7A9");
    final static BasicStroke strokeWidth = new BasicStroke(1f);

    // ------------- DESIGNAL ELEMENTS -----------------

    // ------------- SCREEN SETTINGS -----------------

    final static int originalTileSize = 32; // 32x32 TILE
    final static int scale = 2;
    final static int tileSize = originalTileSize * scale; // 64x64 TILE

    final static int maxScreenCol = 10;
    final static int maxScreenRow = 10;
    final static int screenWidth = tileSize * maxScreenCol; // 1024 pixels X 1024 pixels PANEL
    final static int screenHeight = tileSize * maxScreenRow;
    // final static int compSize = 16;

    // ------------- SCREEN SETTINGS -----------------
}
