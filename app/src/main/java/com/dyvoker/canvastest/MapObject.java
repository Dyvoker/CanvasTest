package com.dyvoker.canvastest;

/**
 * Class for in-game map objects (trees, characters, etc)
 */

public class MapObject extends DrawableOnMap {
    static MapObject TREE = new MapObject(R.drawable.tree, 0.2f, -0.2f, 3.0f);

    private MapObject(int drawableResourceId) {
        super(drawableResourceId);
    }

    private MapObject(int drawableResourceId, float shiftX, float shiftY, float scale) {
        super(drawableResourceId, shiftX, shiftY, scale);
    }
}
