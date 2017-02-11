package com.dyvoker.canvastest;

import android.graphics.Point;
import android.graphics.Rect;

/**
 * Helper for isometric map calculation
 */

public final class IsometricHelper {
    public static int BLOCK_WIDTH = 200;
    public static int BLOCK_HEIGHT = (int) (BLOCK_WIDTH * (Math.sin(Math.toRadians(15.0f))));
    private static int HALF_BLOCK_WIDTH = BLOCK_WIDTH / 2;

    public static Rect CELL_RECT = new Rect(-HALF_BLOCK_WIDTH, -HALF_BLOCK_WIDTH, HALF_BLOCK_WIDTH, HALF_BLOCK_WIDTH);

    public static Point getCellPosition(Point positionInMap) {
        int posX = (int)((positionInMap.x - (positionInMap.x + positionInMap.y) / 2.0f) * BLOCK_WIDTH);
        int posY = (positionInMap.x + positionInMap.y) * BLOCK_HEIGHT;
        return new Point(posX, posY);
    }
}
