package com.dyvoker.canvastest;

import android.graphics.PointF;

/**
 * Class for in-game map objects (trees, characters, etc)
 */

public class MapObject extends DrawableOnMap {
    public static final MapObject TREE = new MapObject(R.drawable.tree, new PointF( 0.147f, -0.8f), 2.0f);

    private MapObject(int drawableResourceId) {
        super(drawableResourceId);
    }

    private MapObject(int drawableResourceId, PointF offset, float scale) {
        super(drawableResourceId, offset, scale);
    }
}
