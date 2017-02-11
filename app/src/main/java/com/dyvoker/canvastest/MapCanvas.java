package com.dyvoker.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Canvas for drawing game map
 */

public class MapCanvas extends View {

    public MapCanvas(Context context) {
        super(context);
    }

    public MapCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#afe4f4"));
        //Draw map here
    }

}
