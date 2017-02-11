package com.dyvoker.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

/**
 * Canvas for drawing game map
 */

public class MapCanvas extends View {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private Map map;
    private float scale = 1.0f; //Scale for map
    private PointF offset = new PointF(0.0f, 0.0f);

    public MapCanvas(Context context) {
        super(context);
        setupOnClickListener();
    }

    public MapCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupOnClickListener();
    }

    public MapCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupOnClickListener();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //Set map offset to center
        if (map != null) {
            offset.set(w / 2, h / 2 - IsometricHelper.getCellPosition(new Point(map.getXSize() / 2, map.getYSize() / 2)).y);
        } else {
            offset.set(w / 2, h / 2);
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
        canvas.scale(scale, scale);
        canvas.translate(offset.x, offset.y);
        for (int x = 0; x < map.getXSize(); x++) {
            for (int y = 0; y < map.getYSize(); y++) {
                MapCell cell = map.getObjectsAtPosition(x, y);
                MapBlock block = cell.getBlock();
                Point pos = new Point(x, y);
                if (block != null) {
                    block.draw(getContext(), canvas, pos);
                    MapObject object = cell.getObject();
                    if (object != null) {
                        object.draw(getContext(), canvas, pos);
                    }
                }
            }
        }
        canvas.restore();
    }

    private void setupOnClickListener() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PointF clickPosition = new PointF(getX(), getY());
                //So, find map cell by coordinates...
            }
        });
    }
}
