package com.dyvoker.canvastest;

/**
 * Class for in-game map selector (for selecting block with objects)
 */

public class MapSelector extends DrawableOnMap {
    public static final MapSelector SIMPLE_SELECTOR = new MapSelector(R.drawable.simple_selector);

    private MapSelector(int drawableResourceId) {
        super(drawableResourceId);
    }
}
