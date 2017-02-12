package com.dyvoker.canvastest;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

/**
 * Helper for isometric map calculation
 */

public final class IsometricHelper {
    public static final int BLOCK_WIDTH = 200;
    public static final int BLOCK_HEIGHT = (int) (BLOCK_WIDTH * (Math.sin(Math.toRadians(15.0f))) * 2.0f);
    private static final int HALF_BLOCK_WIDTH = BLOCK_WIDTH / 2;
    private static final int HALF_BLOCK_HEIGHT = BLOCK_HEIGHT / 2;

    public static final Rect CELL_RECT = new Rect(-HALF_BLOCK_WIDTH, -HALF_BLOCK_WIDTH, HALF_BLOCK_WIDTH, HALF_BLOCK_WIDTH);

    private static Region CELL_REGION = new Region(); //Region for checking interception with touch, it's have correct form of map cell
    static {
        Path path = new Path();
        path.moveTo(0, -HALF_BLOCK_HEIGHT); //up point
        path.lineTo(HALF_BLOCK_WIDTH, 0); //right point
        path.lineTo(0, HALF_BLOCK_HEIGHT); //bottom point
        path.lineTo(-HALF_BLOCK_WIDTH, 0); //left point
        path.close();
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        CELL_REGION.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }

    public static Point getCellPosition(Point positionInMap) {
        int posX = (int)((positionInMap.x - (positionInMap.x + positionInMap.y) / 2.0f) * BLOCK_WIDTH);
        int posY = (positionInMap.x + positionInMap.y) * HALF_BLOCK_HEIGHT;
        return new Point(posX, posY);
    }

    public static boolean isMapCellClicked(Point positionInMap, Point clickCanvasPosition) {
        Point cellPosition = getCellPosition(positionInMap);
        //Rect doesn't correct for checking this interception, I think I can use something like... Region from path? Yes!
        return CELL_REGION.contains(clickCanvasPosition.x - cellPosition.x, clickCanvasPosition.y - cellPosition.y);
    }
}
