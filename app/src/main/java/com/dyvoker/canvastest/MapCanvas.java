package com.dyvoker.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Canvas for drawing game map
 */

public class MapCanvas extends View {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    private static final int BACKGROUND_COLOR = Color.parseColor("#afe4f4");
    private static final float MINIMUM_SCALE_FACTOR = 0.5f;
    private static final float MAXIMUM_SCALE_FACTOR = 2.0f;

    private ScaleGestureDetector scaleDetector;
    private GestureDetector moveDetector;

    private Map map;
    private float scaleFactor = 1.0f; //Scale for map
    private PointF scaleFocus = new PointF(0, 0);
    private PointF offset = new PointF(0.0f, 0.0f);

    public MapCanvas(Context context) {
        this(context, null, 0);
    }

    public MapCanvas(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MapCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        moveDetector = new GestureDetector(context, new MoveListener());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (map != null) { //Set map offset to center
            offset.set(w / 2, h / 2 - IsometricHelper.getCellPosition(new Point(map.getXSize() / 2, map.getYSize() / 2)).y);
        } else {
            offset.set(w / 2, h / 2);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(BACKGROUND_COLOR);
        drawMap(canvas);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private void drawMap(Canvas canvas) {
        if (map == null) return;
        canvas.scale(scaleFactor, scaleFactor, scaleFocus.x, scaleFocus.y);
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleDetector.onTouchEvent(event);
        moveDetector.onTouchEvent(event);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor(); // scaleFactor change since previous event
            scaleFocus.set(detector.getFocusX(), detector.getFocusY());
            // Don't let the object get too small or too large.
            scaleFactor = Math.max(MINIMUM_SCALE_FACTOR, Math.min(scaleFactor, MAXIMUM_SCALE_FACTOR));
            invalidate();
            return true;
        }
    }

    private class MoveListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
            scrollBy((int)distanceX, (int)distanceY);
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent event) { //TODO: create selecting objects
            float x = event.getX();
            float y = event.getY();
            return super.onSingleTapUp(event);
        }
    }
}
