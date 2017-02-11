package com.dyvoker.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Canvas for drawing game map
 */

public class MapCanvas extends View {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private static int BLOCK_SIZE = 200;
    private static int HALF_BLOCK = BLOCK_SIZE / 2;

    private Map map;
    private IsometricMapHelper isometricHelper;
    private float scale = 1.0f; //Scale for map
    private int shiftX = 0; //Shift for map position
    private int shiftY = 0;

    private Rect canvasRect = new Rect(0, 0, 0, 0);

    public MapCanvas(Context context) {
        super(context);
        isometricHelper = new IsometricMapHelper(BLOCK_SIZE);
    }

    public MapCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        isometricHelper = new IsometricMapHelper(BLOCK_SIZE);
    }

    public MapCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        isometricHelper = new IsometricMapHelper(BLOCK_SIZE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (map != null) {
            //Shift map to center
            shiftX = w / 2;
            shiftY = h / 2 - (int) (isometricHelper.getCellPosY(map.getXSize() / 2, map.getYSize() / 2) * scale);
        } else {
            shiftX = w / 2;
            shiftY = h / 2;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#afe4f4"));
        drawMap(canvas);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private void drawMap(Canvas canvas) {
        if (map == null) return;
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvasRect.set(0, 0, width, height);

        for (int x = 0; x < map.getXSize(); x++) {
            for (int y = 0; y < map.getYSize(); y++) {
                List<MapObject> objects = map.getObjectsAtPosition(x, y);
                for (MapObject object : objects) {
                    Drawable pic = getResources().getDrawable(object.getPictureResource());
                    int posX = shiftX + (int) (isometricHelper.getCellPosX(x, y) * scale);
                    int posY = shiftY + (int) (isometricHelper.getCellPosY(x, y) * scale);
                    int halfBlock = (int) (HALF_BLOCK * scale);
                    canvasRect.set(posX - halfBlock, posY - halfBlock, posX + halfBlock, posY + halfBlock);
                    pic.setBounds(canvasRect);
                    pic.draw(canvas);
                }
            }
        }
    }
}
