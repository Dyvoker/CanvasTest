package com.dyvoker.canvastest;

/**
 * Helper for isometric map calculation
 */

public class IsometricMapHelper {
    private int blockWidth;
    private int blockHeight;

    public IsometricMapHelper(int blockWidth) {
        this.blockWidth = blockWidth;
        this.blockHeight = (int) (blockWidth * (Math.sin(Math.toRadians(15.0f))));
    }

    public int getCellPosX(int x, int y) {
        float posX = x - (x + y) / 2.0f;
        return (int) (posX * blockWidth);
    }

    public int getCellPosY(int x, int y) {
        return (x + y) * blockHeight;
    }
}
