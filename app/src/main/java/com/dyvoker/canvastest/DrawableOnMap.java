package com.dyvoker.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Class that contains all information needed for correct drawing on map cell
 */

public class DrawableOnMap {
    private static int BLOCK_SIZE = 200;
    private static int HALF_BLOCK = BLOCK_SIZE / 2;
    private static IsometricMapHelper ISOMETRIC_HELPER = new IsometricMapHelper(BLOCK_SIZE);
    private static Rect canvasRect = new Rect(0, 0, 0, 0);

    private int drawableResourceId; //Can't create drawable without context
    private Drawable drawable; //Picture resource id of the object
    private float shiftX;
    private float shiftY;
    private float scale;

    public DrawableOnMap(int drawableResourceId) {
        this(drawableResourceId, 0.0f, 0.0f);
    }

    public DrawableOnMap(int drawableResourceId, float shiftX, float shiftY) {
        this(drawableResourceId, shiftX, shiftY, 1.0f);
    }

    public DrawableOnMap(int drawableResourceId, float shiftX, float shiftY, float scale) {
        this.drawableResourceId = drawableResourceId;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.scale = scale;
    }

    public void draw(Context context, Canvas canvas, int x, int y, int shiftXMap, int shiftYMap, float scaleMap) {
        canvasRect.set(
                shiftXMap + (int) ((ISOMETRIC_HELPER.getCellPosX(x, y) + BLOCK_SIZE * shiftX - HALF_BLOCK * scale) * scaleMap),
                shiftYMap + (int) ((ISOMETRIC_HELPER.getCellPosY(x, y) + BLOCK_SIZE * shiftY - HALF_BLOCK * scale) * scaleMap),
                shiftXMap + (int) ((ISOMETRIC_HELPER.getCellPosX(x, y) + BLOCK_SIZE * shiftX + HALF_BLOCK * scale) * scaleMap),
                shiftYMap + (int) ((ISOMETRIC_HELPER.getCellPosY(x, y) + BLOCK_SIZE * shiftY + HALF_BLOCK * scale) * scaleMap));
        if (drawable == null) { //Try to load drawable from resource
            drawable = context.getResources().getDrawable(drawableResourceId);
        }
        if (drawable == null) return; //Don't draw if can't load
        drawable.setBounds(canvasRect);
        drawable.draw(canvas);
    }
}
