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
    private MapController mapController;
    private float scaleFactor = 1.0f; //Scale factor for map
    private PointF scaleFocus = new PointF(0, 0);

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
        mapController = new MapController(null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        scrollToMapCenter();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(BACKGROUND_COLOR);
        drawMap(canvas);
    }

    public void setMap(Map map) {
        this.map = map;
        mapController.setMap(map);
        scrollToMapCenter();
    }

    private void scrollToMapCenter() {
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int yMapCenter = IsometricHelper.getCellPosition(new Point(map.getXSize() / 2, map.getYSize() / 2)).y;
        if (map != null) {
            scrollTo(-x, -y + yMapCenter);
            scaleFocus.set(0, yMapCenter);
        } else {
            scrollTo(-x, -y);
            scaleFocus.set(0, yMapCenter);
        }
    }

    private void drawMap(Canvas canvas) {
        if (map == null) return;
        canvas.scale(scaleFactor, scaleFactor, scaleFocus.x, scaleFocus.y);
        for (int x = 0; x < map.getXSize(); x++) {
            for (int y = 0; y < map.getYSize(); y++) {
                MapCell cell = map.getObjectsAtPosition(x, y);
                Point pos = new Point(x, y);
                cell.draw(getContext(), canvas, pos, mapController.isCellSelected(cell));
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
            scaleFocus.set(detector.getFocusX() + getScrollX(), detector.getFocusY() + getScrollY());
            // Don't let the object get too small or too large.
            scaleFactor = Math.max(MINIMUM_SCALE_FACTOR, Math.min(scaleFactor, MAXIMUM_SCALE_FACTOR));
            MapCanvas.this.invalidate();
            return true;
        }
    }

    private class MoveListener extends GestureDetector.SimpleOnGestureListener {
        private Point tapCanvasPosition = new Point(0, 0);

        @Override
        public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
            scrollBy((int)distanceX, (int)distanceY); //Scroll view and invalidate it
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            Point pos = new Point(0, 0);
            tapCanvasPosition.set(
                    (int) ((event.getX() + MapCanvas.this.getScrollX() - scaleFocus.x) / scaleFactor + scaleFocus.x),
                    (int) ((event.getY() + MapCanvas.this.getScrollY() - scaleFocus.y) / scaleFactor + scaleFocus.y));
            for (int x = 0; x < map.getXSize(); x++) {
                for (int y = 0; y < map.getYSize(); y++) {
                    pos.set(x, y);
                    if (IsometricHelper.isMapCellClicked(pos, tapCanvasPosition)) {
                        mapController.onMapCellClick(pos);
                        break;
                    }
                }
            }
            invalidate();
            return true;
        }
    }
}
