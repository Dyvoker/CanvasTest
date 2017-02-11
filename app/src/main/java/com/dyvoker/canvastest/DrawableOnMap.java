package com.dyvoker.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;

/**
 * Class that contains all information needed for correct drawing on map cell
 */

public class DrawableOnMap {
    private int drawableResourceId; //Picture resource id of the object
    private Drawable drawable;
    private PointF offset; //Offset for drawable in cell
    private float scale;

    public DrawableOnMap(int drawableResourceId) {
        this(drawableResourceId, new PointF(0.0f, 0.0f));
    }

    public DrawableOnMap(int drawableResourceId, PointF offset) {
        this(drawableResourceId, offset, 1.0f);
    }

    public DrawableOnMap(int drawableResourceId, PointF offset, float scale) {
        this.drawableResourceId = drawableResourceId;
        this.offset = offset;
        this.scale = scale;
    }

    public void draw(Context context, Canvas canvas, Point pos) {
        if (drawable == null) { //Try to load drawable from resource
            drawable = context.getResources().getDrawable(drawableResourceId);
        }
        if (drawable == null) return; //Don't draw if can't load
        canvas.save();
        Point cellPosition = IsometricHelper.getCellPosition(pos);
        canvas.translate(cellPosition.x + IsometricHelper.BLOCK_WIDTH * offset.x,
                cellPosition.y + IsometricHelper.BLOCK_WIDTH * offset.y);
        canvas.scale(scale, scale);
        drawable.setBounds(IsometricHelper.CELL_RECT);
        drawable.draw(canvas);
        canvas.restore();
    }
}
